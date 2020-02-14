package com.yanftch.review.android.unit_test

/**
 *
 * User : yanftch
 * Date : 2020-01-29
 * Time : 21:08
 * Desc :
 */
class UnitTestPresenter(val view: UnitTestContract.View) : UnitTestContract.Presenter {
    private var mView: UnitTestContract.View = view

    init {
        mView.setPresenter(this)
    }

    override fun login(name: String, pwd: String) {
        Runnable {
            Thread.sleep(5000)
            if (name == "aaa") {
                mView.onLoginSucceed("login success...name=$name, pwd=$pwd")
            } else {
                mView.onLoginError("login error...name=$name")
            }
        }.run()
    }

    override fun register(name: String, pwd: String) {
        Runnable {
            Thread.sleep(5000)
            mView.onLoginError("注册失败...")
        }.run()
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }

}