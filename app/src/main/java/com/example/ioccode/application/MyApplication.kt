package com.example.ioccode.application

import com.example.bernard_di.provider.installProvider


class MyApplication : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        installProvider(providerList)
    }
}

val providerList = listOf(
    MyProvider()
)