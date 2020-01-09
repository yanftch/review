package com.yanftch.review.android.pages

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.yanftch.review.android.service.MyService
import org.jetbrains.anko.UI
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.verticalLayout

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(UI {
            verticalLayout {
                button {
                    text = "startService"
                    onClick {
                        startService(Intent(this@ServiceActivity, com.yanftch.review.android.service.MyService::class.java))
                    }
                }
                button {
                    text = "bindService"
                    onClick {
                        bindService(
                            Intent(this@ServiceActivity, com.yanftch.review.android.service.MyService::class.java),
                            object : ServiceConnection {
                                override fun onServiceDisconnected(name: ComponentName?) {
                                }

                                override fun onServiceConnected(
                                    name: ComponentName?,
                                    service: IBinder?
                                ) {
                                }

                            },
                            Context.BIND_AUTO_CREATE
                        )
                    }
                }
            }
        }.view)
    }
}
