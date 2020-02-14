package com.yanftch.review

import android.util.Log
import androidx.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 *
 * User : yanftch
 * Date : 2020-01-29
 * Time : 21:38
 * Desc :
 */
class UnitTestDemoTest {

    @Before
    fun testBefore() {
        Log.e("debug_UnitTestDemoTest", "testBefore: ")
    }

    @Test
    fun testLogin() {
        val appContext = InstrumentationRegistry.getTargetContext()
//        var presenter = UnitTestPresenter()
        for (index in 1..10) {
            Log.e("debug_UnitTestDemoTest", "testLogin: $index")
        }
    }

    @After
    fun testAfter() {
        Log.e("debug_UnitTestDemoTest", "testAfter: ")
    }
}