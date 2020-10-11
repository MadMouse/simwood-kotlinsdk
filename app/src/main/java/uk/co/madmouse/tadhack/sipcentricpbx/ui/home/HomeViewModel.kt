package uk.co.madmouse.tadhack.sipcentricpbx.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.iot.smsbridge.core.network.ResourceStatusEnum
import uk.co.madmouse.tadhack.sipcentricapi.ApiHelper
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerItem
import uk.co.madmouse.tadhack.sipcentricapi.network.AccountApi
import uk.co.madmouse.tadhack.sipcentricapi.network.AccountServiceImpl
import uk.co.madmouse.tadhack.sipcentricapi.repository.AccountRepositoryImpl

class HomeViewModel : ViewModel() {
    val TAG = this::class.java.simpleName
    private val USER_NAME = "<SimWood User>"
    private val PASSWORD = "Simwood Password"

    private val _myProfile = MutableLiveData<Resource<CustomerItem>>()
    val myProfile: LiveData<Resource<CustomerItem>> = _myProfile

    private val _creditStatus = MutableLiveData<Resource<CreditStatusItem>>()
    val creditStatus: LiveData<Resource<CreditStatusItem>> = _creditStatus


    private val customerService = AccountServiceImpl(
        ApiHelper<AccountApi>(
            AccountApi::class.java,
            USER_NAME,
            PASSWORD
        ).getService()
    )
    val customerRepository = AccountRepositoryImpl(customerService)

    fun refreshCreditStatus(accountId: String) {
        viewModelScope.launch {
            customerRepository.getCreditStatus(accountId)?.let {
                _creditStatus.postValue(it);
            }
        }
    }

    fun fetchMyProfile() {
        viewModelScope.launch {
            customerRepository.getProfile()?.let {
                _myProfile.postValue(it);
                if(it.status.equals(ResourceStatusEnum.SUCCESS)) {
                    it.data?.let {
                        it.id?.let { it1 -> refreshCreditStatus(it1) }
                    }
                }
            }
        }
    }
}