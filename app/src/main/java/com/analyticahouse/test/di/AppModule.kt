package com.analyticahouse.test.di

import com.analyticahouse.test.data.network.BalldontlieAPI
import com.analyticahouse.test.data.repository.BalldontlieRepository
import com.analyticahouse.test.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesBalldontlieRepository(api: BalldontlieAPI): BalldontlieRepository {
        return BalldontlieRepository(api)
    }

    @Singleton
    @Provides
    fun providesBalldontlieAPI(): BalldontlieAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(BalldontlieAPI::class.java)
    }

}