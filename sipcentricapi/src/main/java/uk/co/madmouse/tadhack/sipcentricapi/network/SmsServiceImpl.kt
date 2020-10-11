package uk.co.madmouse.tadhack.sipcentricapi.network

import retrofit2.Response
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItems

class SmsServiceImpl(private val smsApi: smsApi) : SmsService {
    override suspend fun sendSms(customerId: String, smsMessage: SmsMessage): SmsItem {
        return smsApi.sendSms(customerId, smsMessage)
    }

    override suspend fun fetchSmsList(
        customerId: String,
        pageSize: Int?,
        page: Int?
    ): Response<SmsItems> {
        return smsApi.fetchSmsList(accountId = customerId, pageSize, page)
    }
}