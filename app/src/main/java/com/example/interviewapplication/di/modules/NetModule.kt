package com.example.interviewapplication.di.modules

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @NotNull
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @NotNull
    @Singleton
    fun provideObjectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}