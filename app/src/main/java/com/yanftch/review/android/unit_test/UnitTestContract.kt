package com.yanftch.review.android.unit_test

import com.yanftch.review.android.base.BasePresenter
import com.yanftch.review.android.base.BaseView

/**
 *
 * User : yanftch
 * Date : 2020-01-29
 * Time : 21:03
 * Desc :
 */
interface UnitTestContract {

    // view 层
    interface View : BaseView<Presenter> {
        fun onLoginSucceed(message: Any)
        fun onLoginError(errorMsg: Any)
    }

    // Presenter 层
    interface Presenter : BasePresenter {
        fun login(name: String, pwd: String)
        fun register(name: String, pwd: String)
    }
}