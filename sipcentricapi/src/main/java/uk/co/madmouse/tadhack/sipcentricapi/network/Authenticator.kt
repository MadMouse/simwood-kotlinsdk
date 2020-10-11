package uk.co.madmouse.tadhack.sipcentricapi.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticatorInterceptor(private val userName: String, private val password: String) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header("Authorization", Credentials.basic(userName, password))
            .method(original.method, original.body)
            .build();
        return chain.proceed(request)
    }
}