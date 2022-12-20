package com.example.bernard_di.di

@Suppress("UNCHECKED_CAST")
class Dependencies()  {
    private val dependencyMap : MutableMap<Class<*>, Target<*>> = mutableMapOf()

    fun <T> resolve(clazz: Class<T>): T {
        return dependencyMap[clazz]?.get() as T
    }
    fun <T> insert(clazz: Class<T>, dependency: T) {
        val singleton = Target<T>()
        singleton.dependency = dependency
        dependencyMap[clazz] = singleton
    }
    fun <T> insert(clazz: Class<T>, factory: () -> T) {
        val factoryTarget = Target<T>()
        factoryTarget.factory = factory
        dependencyMap[clazz] = factoryTarget
    }

    class Target<T>(  ) {
        lateinit var factory: () -> T
        var dependency: T? = null
        fun get(): T {
            if (this::factory.isInitialized) {
                dependency = factory()
            }
            return dependency!!
        }
    }
}
