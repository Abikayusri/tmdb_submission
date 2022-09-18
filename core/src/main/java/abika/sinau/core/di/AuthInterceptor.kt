package abika.sinau.core.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 8/27/2022
 */
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().build()
        return chain.proceed(request)
    }
}