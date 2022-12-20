package com.example.bernard_di.di

open class DependencyResolver {
    val dependenciesMap = Dependencies()
    inline fun <reified T> insert(dependency: T) {
        dependenciesMap.insert(T::class.java, dependency)
    }
    //add support for factory
    inline fun <reified T> insert(noinline factory: () -> T) {
        dependenciesMap.insert(T::class.java, factory)
    }

    fun <T> resolve(clazz: Class<T>): T {
        return dependenciesMap.resolve(clazz)
    }
}

