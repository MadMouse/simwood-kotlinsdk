package uk.co.madmouse.tadhack.sipcentricpbx.ui.sms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.tadhack.sipcentricapi.ApiHelper
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItems
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.network.SmsServiceImpl
import uk.co.madmouse.tadhack.sipcentricapi.network.smsApi
import uk.co.madmouse.tadhack.sipcentricapi.repository.SmsRepositoryImpl

class SmsViewModel : ViewModel() {
    val TAG = this::class.java.simpleName

    private val USER_NAME = "<SimWood User>"
    private val PASSWORD = "Simwood Password"

    private val apiService = SmsServiceImpl(
        ApiHelper<smsApi>(
            smsApi::class.java,
            USER_NAME,
            PASSWORD
        ).getService()
    )

    private val smsRepository = SmsRepositoryImpl(apiService)

    private val _smsList = MutableLiveData<Resource<SmsItems?>?>()
    val smsList: LiveData<Resource<SmsItems?>?> =_smsList

    fun fetchSmsList(customerId :String, pageSize : Int = 25, page :Int = 0){
        viewModelScope.launch {
            val smsItems = smsRepository.fetchSmsList(customerId, pageSize, page)
            _smsList.postValue(smsItems);
        }
    }

    fun sendSms(customerId: String, smsMessage: SmsMessage){
        viewModelScope.launch {
            val smsItems = smsRepository.sendSms(customerId, smsMessage)
            fetchSmsList(customerId)
        }
    }
}