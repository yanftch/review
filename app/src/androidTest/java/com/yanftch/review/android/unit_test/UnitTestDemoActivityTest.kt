package com.yanftch.review.android.unit_test

import android.util.Log
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UnitTestDemoActivityTest {


    // P 层
    var mPresenter: UnitTestPresenter? = null

    @Mock
    val mView: UnitTestContract.View? = null

    /**
     * 完成前期准备工作
     *
     */
    @Before
    fun setUp() {

        mPresenter = UnitTestPresenter(mView)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun onLoginSucceed() {
        print("debug_onLoginSucceed...")
        Log.e("debug_","onLoginSucceed...")
    }

    @Test
    fun onLoginError() {
    }

    @Test
    fun setPresenter() {
    }
}