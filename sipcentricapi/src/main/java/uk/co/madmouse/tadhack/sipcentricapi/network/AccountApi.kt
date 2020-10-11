package uk.co.madmouse.tadhack.sipcentricapi.network


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerItem

interface AccountApi {
    @GET("customers/{customerId}")
    suspend fun getProfile(@Path("customerId") customerId: String): Response<CustomerItem>

    @GET("customers/{customerId}/creditstatus")
    suspend fun getCreditStatus(@Path("customerId") customerId: String): Response<CreditStatusItem>
}