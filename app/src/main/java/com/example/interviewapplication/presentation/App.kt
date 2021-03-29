package com.example.interviewapplication.presentation

import android.app.Application
import com.example.interviewapplication.di.AppComponent
import com.example.interviewapplication.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    companion object {
        lateinit var component: AppComponent
            private set
    }
}