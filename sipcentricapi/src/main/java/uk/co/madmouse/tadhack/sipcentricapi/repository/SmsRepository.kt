package uk.co.madmouse.tadhack.sipcentricapi.repository

import retrofit2.Response
import retrofit2.http.Path
import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItems
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem

interface SmsRepository {
    suspend fun sendSms(customerId: String, smsMessage: SmsMessage): SmsItem
    suspend fun fetchSmsList(customerId: String, pageSize: Int?, page: Int?): Resource<SmsItems?>?
}