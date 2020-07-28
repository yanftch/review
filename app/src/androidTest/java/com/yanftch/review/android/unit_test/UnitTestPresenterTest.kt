package com.yanftch.review.android.unit_test

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class UnitTestPresenterTest {

    var mPresenter: UnitTestPresenter? = null
    @Mock
    var mView: UnitTestContract.View? = null

    @Before
    fun setUp() {

        mPresenter = UnitTestPresenter(mView)

    }

    @Test
    public fun testLogin() {


    }


    @Test
    public fun testLoginSuccess() {

    }

    @Test
    public fun testLoginError() {

    }

    @After
    fun tearDown() {
    }
}