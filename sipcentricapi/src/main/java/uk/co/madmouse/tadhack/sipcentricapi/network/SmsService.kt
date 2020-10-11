package uk.co.madmouse.tadhack.sipcentricapi.network

import retrofit2.Response
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItems

interface SmsService {
    suspend fun sendSms(customerId: String, smsMessage: SmsMessage): SmsItem
    suspend fun fetchSmsList(customerId: String, pageSize: Int?, page: Int? ): Response<SmsItems>
}