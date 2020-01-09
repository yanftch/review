package com.yanftch.review.android.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*

/**
 *
 * User : yanftch
 * Date : 2019-11-09
 * Time : 15:27
 * Desc :
 */
class MyService : Service() {
    private var arrayList: ArrayList<Any>? = null
    private var linkedList: LinkedList<Any>? = null
private var hashtable: HashMap<Any,Any>? = null

    override fun onCreate() {
        Log.e("debug_MyService", "onCreate: ")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("debug_MyService", "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("debug_MyService", "onBind: ")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("debug_MyService", "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e("debug_MyService", "onDestroy: ")
        super.onDestroy()
    }
}