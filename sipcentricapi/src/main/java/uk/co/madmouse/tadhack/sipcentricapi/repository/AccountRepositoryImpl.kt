package uk.co.madmouse.tadhack.sipcentricapi.repository

import retrofit2.Response
import uk.co.madmouse.iot.smsbridge.core.network.Resource
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CreditStatusItem
import uk.co.madmouse.tadhack.sipcentricapi.model.local.CustomerItem
import uk.co.madmouse.tadhack.sipcentricapi.network.AccountService
import uk.co.madmouse.tadhack.sipcentricapi.network.mapper.CreditStatusMapperImpl
import uk.co.madmouse.tadhack.sipcentricapi.network.mapper.CustomerItemMapperImpl
import java.security.InvalidParameterException

class AccountRepositoryImpl(private val customerService: AccountService) : AccountRepository {
    val customerItemMapper = CustomerItemMapperImpl()
    val creditStatusItemMapper = CreditStatusMapperImpl()
    override suspend fun getProfile(customerId: String?): Resource<CustomerItem>? {
        customerId?.let {
            val response = customerService.getProfile(it)
            if (response.isSuccessful && response.body() != null) {
                return response.body()?.let {
                    val mapped = customerItemMapper.map(it)
                    mapped?.let {
                        return@let Resource.success(it);
                    }
                }
            }
            return Resource.error(null, response.message())
        }
        throw InvalidParameterException("CustomerId Required")
    }

    override suspend fun getCreditStatus(customerId: String): Resource<CreditStatusItem>? {

        customerId?.let {
            val response = customerService.getCreditStatus(it)
            if (response.isSuccessful && response.body() != null) {
                return response.body()?.let {
                    val mapped = creditStatusItemMapper.map(it)
                    mapped?.let {
                        return@let Resource.success(it);
                    }
                }
            }
            return Resource.error(null, response.message())
        }
        throw InvalidParameterException("CustomerId Required")
    }
}