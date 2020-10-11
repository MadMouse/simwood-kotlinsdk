package uk.co.madmouse.tadhack.sipcentricapi.network

import retrofit2.Response
import retrofit2.http.*
import uk.co.madmouse.tadhack.sipcentricapi.model.local.SmsMessage
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.SmsItems

interface smsApi {
    @POST("customers/{customerId}/sms")
    suspend fun sendSms(
        @Path("customerId") customerId: String,
        @Body smsMessage: SmsMessage
    ): SmsItem

    @GET("customers/{accountId}/sms")
    suspend fun fetchSmsList(
        @Path("accountId") accountId: String,
        @Query("pageSize") pageSize: Int? = 20,
        @Query("page") page: Int? = 1 ): Response<SmsItems>
}