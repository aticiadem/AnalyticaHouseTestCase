package com.analyticahouse.test.di

import android.content.Context
import androidx.room.Room
import com.analyticahouse.test.common.Constants.BASE_URL
import com.analyticahouse.test.common.Constants.PLAYER_DATABASE
import com.analyticahouse.test.common.Constants.TEAM_DATABASE
import com.analyticahouse.test.data.local.PlayerDatabase
import com.analyticahouse.test.data.local.TeamDatabase
import com.analyticahouse.test.data.remote.BalldontlieAPI
import com.analyticahouse.test.data.repository.BalldontlieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideTeamDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TeamDatabase::class.java,
        TEAM_DATABASE
    ).build()

    @Singleton
    @Provides
    fun providePlayerDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PlayerDatabase::class.java,
        PLAYER_DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideTeamDao(database: TeamDatabase) = database.teamDao()

    @Singleton
    @Provides
    fun providePlayerDao(database: PlayerDatabase) = database.playerDao()

}