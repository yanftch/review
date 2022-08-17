package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yanftch.review.R
import kotlinx.android.synthetic.main.activity_lifecycle.*
import okhttp3.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.*
import java.io.IOException

class LifecycleActivity : AppCompatActivity() {
    //    val imgUrl = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg"
    val imgUrl =
        "http://d.ifengimg.com/w600/p0.ifengimg.com/pmop/2018/0904/EAA3EABECE3682A008BAE31AFF8CDBEA5E153DD2_size49_w700_h848.jpeg"
    val gifUrl = "http://p1.pstatp.com/large/166200019850062839d3"


    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        EventBus.getDefault().register(this)
        image = find(R.id.iv_image)
        btn_load_img.setOnClickListener {

            Glide.with(application).load(gifUrl)
                .placeholder(R.drawable.loading).error(R.drawable.loading_failed).into(image)

            // 发送 event bus  消息
            EventBus.getDefault().post("this is message")

            // 获取信息
            val tasks = this.activityManager.getRunningTasks(100)
            tasks.forEach {
                Log.e(
                    "debug_LifecycleActivity",
                    "onCreate: ${it.topActivity?.className}     ${it.baseActivity?.className}"
                )

            }
            val request: Request = Request.Builder().url("").build()
            val client: OkHttpClient = OkHttpClient()
            val newCall = client.newCall(request)
            newCall.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                }
            })
        }
    }

    private fun getSimpleView(): View = UI {
        verticalLayout {
            textView {
                text = "hello..."
            }
        }
    }.view

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onEvent(any: Any) {
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        EventBus.getDefault().unregister(this)
    }

}
