package com.yanftch.review.android.unit_test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UnitTestPresenterJavaTest {

    private UnitTestPresenter mPresenter;

    private UnitTestContract.View mView;


    @Before
    public void setUp() {
        mView = Mockito.mock(UnitTestContract.View.class);
        mPresenter = new UnitTestPresenter(mView);

    }

    @Test
    public void testLoginSuccess() {
        when(mView.isActive()).thenReturn(true);
        mPresenter.login("aaa","1");
        verify(mView).onLoginSucceed("logon ok?");
    }

    @Test
    public void testLoginError() {

    }
}
