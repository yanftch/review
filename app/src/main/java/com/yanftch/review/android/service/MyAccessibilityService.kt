package com.yanftch.review.android.service

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import org.jetbrains.anko.toast



/**
 *
 * User : yanftch
 * Date : 2019-07-24
 * Time : 15:33
 * Desc :
 */
class MyAccessibilityService : AccessibilityService() {
    val TAG = "debug_MyAccessibilityService"


    // 辅助功能中断的回调，基本不用理
    override fun onInterrupt() {
    }

    // 当界面发生了什么事情，比如顶部Notification，界面更新，内容变化等， 会触发这个方法
    @SuppressLint("LongLogTag")
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.i("debug_MyAccessibilityService", "onAccessibilityEvent: event=${event.toString()}")
        val eventType = event?.eventType
        when(eventType){
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                Log.e("debug_MyAccessibilityService", "onAccessibilityEvent: $event")
                Log.e("debug_MyAccessibilityService", "onAccessibilityEvent: ${event.source}")

//                val list = event.source.findAccessibilityNodeInfosByText("深蓝")
//                Log.e("debug_MyAccessibilityService", "onAccessibilityEvent: list==$list")
//                if (null != list) {
//                    for (info in list) {
//                        Log.e("debug_MyAccessibilityService", "onAccessibilityEvent: info=${info.toString()}")
//                        if (info.text.toString() == "深蓝") {
//                            //找到你的节点以后 就直接点击他就行了
//                            info.performAction(AccessibilityNodeInfo.ACTION_FOCUS)
//                            info.performAction(AccessibilityNodeInfo.ACTION_CLICK)
//                        }
//                    }
//                }
            }
            else -> toast("error")
        }
    }

}