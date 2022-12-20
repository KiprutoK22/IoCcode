package com.example.bernard_di

import com.example.bernard_di.instance.factory
import com.example.bernard_di.instance.inject
import com.example.bernard_di.provider.IProvider
import com.example.bernard_di.provider.installProvider
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestInstallProviderTests {
    @Test
    fun testInstallProvider(){
        installProvider(listOf(TestProviderOne(), TestProviderTwo()))
        assert(inject<TestProviderOne.TestMsg>().message == "One")
        assert(inject<TestProviderTwo.TestMsg>().message == "Two")
    }

    class TestProviderOne : IProvider {
        override fun init() {
            factory { TestMsg() }
        }
        class TestMsg(
            val message: String = "One"
        )
    }
    class TestProviderTwo : IProvider {
        override fun init() {
            factory { TestMsg() }
        }
        class TestMsg(
            val message: String = "Two"
        )
    }

}