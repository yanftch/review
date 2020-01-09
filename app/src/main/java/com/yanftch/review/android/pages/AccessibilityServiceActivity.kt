package com.yanftch.review.android.pages

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.android.service.MyAccessibilityService
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.verticalLayout

@SuppressLint("LongLogTag")
class AccessibilityServiceActivity : AppCompatActivity() {

    private lateinit var myAccessibilityService: com.yanftch.review.android.service.MyAccessibilityService
    private lateinit var intentService: IntentService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("debug_AccessibilityServiceActivity", "onCreate: ")
        setContentView(createContentView())
        myAccessibilityService = com.yanftch.review.android.service.MyAccessibilityService()
    }

    override fun onStart() {
        super.onStart()
        Log.e("debug_AccessibilityServiceActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("debug_AccessibilityServiceActivity", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("debug_AccessibilityServiceActivity", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("debug_AccessibilityServiceActivity", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("debug_AccessibilityServiceActivity", "onDestroy: ")
    }

    private fun createContentView(): View =
        UI {
            verticalLayout {
                button {
                    text = "start"
                    onClick {
                        val intent = Intent(
                            this@AccessibilityServiceActivity,
                            com.yanftch.review.android.service.MyAccessibilityService::class.java
                        )
                        startService(intent)
                    }
                }
                button {
                    text = "stop"
                    onClick {

                    }
                }
            }
        }.view

}
