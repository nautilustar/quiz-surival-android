package br.com.nautilustar.data.cloud

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun okHttpClient(
        @Named(USER_AGENT_INTERCEPTOR) userAgentInterceptor: Interceptor,
        @Named(RESPONSE_INTERCEPTOR) responseInterceptor: Interceptor,
        logInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(userAgentInterceptor)
            .addInterceptor(responseInterceptor)
            .addInterceptor(logInterceptor)
            .build()
    }

    @Provides
    fun retrofitBuilder(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    fun retrofit(
        @Named(URL_DOMAIN) urlDomain: String,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit {
        return retrofitBuilder
            .baseUrl(urlDomain)
            .build()
    }
}