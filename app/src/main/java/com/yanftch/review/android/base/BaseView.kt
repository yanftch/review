package com.yanftch.review.android.base

/**
 *
 * User : yanftch
 * Date : 2020-01-29
 * Time : 20:57
 * Desc : base view
 */
interface BaseView<T> {
    fun setPresenter(presenter: T)
    fun isActive(): Boolean
}