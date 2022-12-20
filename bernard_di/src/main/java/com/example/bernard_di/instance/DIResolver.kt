package com.example.bernard_di.instance

import com.example.bernard_di.di.DependencyResolver

object DIResolver : DependencyResolver()
inline fun <reified T> inject() = DIResolver.resolve<T>(T::class.java)
inline fun <reified T> factory(noinline factory : () -> T) = DIResolver.insert(factory)
inline fun <reified T> singleton(creationFunction : () -> T) = DIResolver.insert(creationFunction())