package com.yanftch.review.android.utils

import android.view.MotionEvent

fun MotionEvent?.getEventName(): String {
    if (this == null) return ""
    return this.actionMasked.let {
        when (it) {
            MotionEvent.ACTION_DOWN -> return "ACTION_DOWN"
            MotionEvent.ACTION_MOVE -> return "ACTION_MOVE"
            MotionEvent.ACTION_UP -> return "ACTION_UP"
            MotionEvent.ACTION_CANCEL -> return "ACTION_CANCEL"
            MotionEvent.ACTION_OUTSIDE -> return "ACTION_OUTSIDE"
            MotionEvent.ACTION_POINTER_DOWN -> return "ACTION_POINTER_DOWN"
            else -> ""
        }
    }
}