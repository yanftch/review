package com.yanftch.review.android.base

/**
 *
 * User : yanftch
 * Date : 2020-01-29
 * Time : 20:55
 * Desc : presenter 抽象类
 */
interface BasePresenter {
    fun onStart()
    fun onStop()
    fun onDestroy()
}
