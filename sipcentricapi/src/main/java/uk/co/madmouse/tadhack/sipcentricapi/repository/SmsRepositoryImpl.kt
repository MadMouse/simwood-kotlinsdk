package uk.co.madmouse.tadhack.sipcentricapi.repository

import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsItems
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.network.SmsService
import uk.co.madmouse.tadhack.sipcentricapi.network.mapper.SmsItemsMapperImpl

class SmsRepositoryImpl(val smsService: SmsService) : SmsRepository {
    override suspend fun sendSms(customerId: String, smsMessage: SmsMessage): SmsItem {
        return smsService.sendSms(customerId, smsMessage)
    }

    override suspend fun fetchSmsList(
        customerId: String,
        pageSize: Int?,
        page: Int?
    ): Resource<SmsItems?>? {
        val response = smsService.fetchSmsList(customerId, pageSize, page)
        if (response.isSuccessful && response.body() != null) {
            val mapper = SmsItemsMapperImpl()
            return response.body()?.let {
                val mapped = mapper.map(it)

                return@let mapped?.let {
                    return@let Resource.success(it)
                }
            }
        }
        return Resource.error(null, response.message())
    }
}