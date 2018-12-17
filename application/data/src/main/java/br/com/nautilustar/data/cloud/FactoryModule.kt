package br.com.nautilustar.data.cloud

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class FactoryModule {

    @Provides
    @Singleton
    fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }
}