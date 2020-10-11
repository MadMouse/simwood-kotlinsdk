package uk.co.madmouse.tadhack.sipcentricapi.repository

import retrofit2.Response
import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerItem

interface AccountRepository {
    suspend fun getProfile(customerId: String? = "me"): Resource<CustomerItem>?
    suspend fun getCreditStatus(customerId: String): Resource<CreditStatusItem>?
}