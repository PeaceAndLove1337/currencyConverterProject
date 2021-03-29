package com.example.interviewapplication.di

import com.example.interviewapplication.di.modules.DataModule
import com.example.interviewapplication.di.modules.NetModule
import com.example.interviewapplication.presentation.view.MainActivity
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, DataModule::class])
interface AppComponent {

    fun getOkHttpClient(): OkHttpClient

    fun getObjectMapper(): ObjectMapper

    fun inject(mainActivity: MainActivity)
}