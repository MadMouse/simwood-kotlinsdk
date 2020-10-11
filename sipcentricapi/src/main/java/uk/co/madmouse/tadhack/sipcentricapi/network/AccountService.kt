package uk.co.madmouse.tadhack.sipcentricapi.network

import retrofit2.Response
import retrofit2.http.Path
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerItem

interface AccountService {
    suspend fun getProfile(customerId : String): Response<CustomerItem>

    suspend fun getCreditStatus(customerId: String): Response<CreditStatusItem>
}