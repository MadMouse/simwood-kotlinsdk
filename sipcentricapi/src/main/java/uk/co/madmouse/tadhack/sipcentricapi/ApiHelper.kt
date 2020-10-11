package uk.co.madmouse.tadhack.sipcentricapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.madmouse.tadhack.sipcentricapi.network.AuthenticatorInterceptor

class ApiHelper<T>(
    private val classType: Class<T>,
    private val userName: String,
    private val password: String
) {
    val SIP_CENTRIC_BASE: String = "https://pbx.sipcentric.com/api/v1/"

    private fun buildOKHttpBuilder(): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder();
        httpClient.addInterceptor(AuthenticatorInterceptor(userName, password))
        return httpClient
    }

    fun getService(): T {
        var retrofit = Retrofit.Builder()
            .baseUrl(SIP_CENTRIC_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOKHttpBuilder().build())
            .build()

        return retrofit.create(classType)
    }
}