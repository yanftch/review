package com.yanftch.review.android.fragment.new_home

import android.text.TextUtils
import android.view.View

/**
 * View 的显示隐藏
 */
var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
    }


/**
 * 字符串不为空(null,"")
 */
fun CharSequence.isNotEmpty(): Boolean = !TextUtils.isEmpty(this)
fun CharSequence.isEmpty(): Boolean = TextUtils.isEmpty(this)

