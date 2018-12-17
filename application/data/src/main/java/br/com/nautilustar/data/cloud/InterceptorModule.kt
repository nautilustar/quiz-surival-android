package br.com.nautilustar.data.cloud

import br.com.nautilustar.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
class InterceptorModule {

    @Provides
    @Named(RESPONSE_INTERCEPTOR)
    @Singleton
    fun interceptorResponse(): Interceptor {
        return Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header("Content-Type", "application/json")
            chain.proceed(requestBuilder.build())
        }
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        return httpLoggingInterceptor
    }

    @Provides
    @Named(USER_AGENT_INTERCEPTOR)
    @Singleton
    fun userAgentInterceptor(): Interceptor {
        return Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("User-Agent", userAgent())
            chain.proceed(requestBuilder.build())
        }
    }

    private fun userAgent(): String {
        val version = "1.0.0"
        val osVersion = android.os.Build.VERSION.RELEASE
        val pack = " br.com.nautilustar"
        val device = android.os.Build.MODEL
        return "Quiz Survival/$version ($pack; OS Version:$osVersion; Android $device)"
    }
}