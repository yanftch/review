package com.yanftch.review.android.utils

import android.content.Context
import org.jetbrains.anko.toast

/**
 *
 * User : yanftch
 * Date : 2019-10-25
 * Time : 16:18
 * Desc :
 */
class BaseUtils {
    companion object {
        fun testFun01(context: Context, msg: String = "default") {
            context.toast(msg)
        }
    }
}