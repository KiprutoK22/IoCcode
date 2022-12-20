package com.example.bernard_di

import com.example.bernard_di.instance.factory
import com.example.bernard_di.instance.inject
import com.example.bernard_di.instance.singleton
import com.example.bernard_di.provider.IProvider
import com.example.bernard_di.provider.installProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class TestSingletonFunctionality {
    @Test
    fun testSingletonFunctionality(){
        installProvider(listOf(TestProvider()))
        val singletonInstance : ISingletonInstance = inject()
        val singletonInstance2 : ISingletonInstance = inject()
        verify(exactly = 1) { mockSingleton.invoke() }
        assert(singletonInstance == singletonInstance2)
    }

//    private val mockFactory = mockk<(List<Module>) -> PlatformApp> {
//        every { this@mockk.invoke(any()) } returns mockPlatformApp
//    }



    companion object{
         val mockSingletonInstance = mockk<ISingletonInstance> {

        }
         val mockSingleton = mockk<()->ISingletonInstance> {
            every { this@mockk.invoke() } returns mockSingletonInstance
        }
    }




    interface ISingletonInstance {
        val message: String
    }
    class SingletonInstance : ISingletonInstance {
        override val message: String = "Singleton"
    }

    class TestProvider : IProvider {
        override fun init() {
            singleton { mockSingleton() }
        }
    }
}