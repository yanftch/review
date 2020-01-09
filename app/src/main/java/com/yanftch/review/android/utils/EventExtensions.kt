package com.yanftch.review.android.utils

/**
 *
 * User : yanftch
 * Date : 2019-10-28
 * Time : 12:17
 * Desc :
 */
fun Int?.toActionName(parent: String?): String {
    return when (this) {
        0 -> "ACTION = ACTION_DOWN, NAME = $parent"
        1 -> "ACTION = ACTION_UP,   NAME = $parent"
        2 -> "ACTION = ACTION_MOVE, NAME = $parent"
        3 -> "ACTION = ACTION_CANCEL, NAME = $parent"
        else -> "非法"
    }
}