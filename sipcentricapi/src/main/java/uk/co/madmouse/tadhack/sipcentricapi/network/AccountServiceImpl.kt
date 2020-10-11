package uk.co.madmouse.tadhack.sipcentricapi.network

import retrofit2.Response
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.remote.CustomerItem

class AccountServiceImpl(val customerApi: AccountApi) : AccountService {
    override suspend fun getProfile(customerId: String): Response<CustomerItem> {
        return customerApi.getProfile(customerId)
    }

    override suspend fun getCreditStatus(customerId: String): Response<CreditStatusItem> {
       return customerApi.getCreditStatus(customerId)
    }
}