package com.example.bernard_di.provider

interface IProvider {
    fun init()
}

fun installProvider(provider: List<IProvider>){
    provider.forEach {
        it.init()
    }
}