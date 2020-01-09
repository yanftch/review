package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.lzyzsd.jsbridge.BridgeWebView
import com.yanftch.review.MainActivity
import com.yanftch.review.R

class JsBridgeActivity : AppCompatActivity() {
    val TAG = "debug_JsBridgeActivity"


    private lateinit var button: Button
    private lateinit var webView: BridgeWebView
    var string: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_js_bridge)
        button = findViewById(R.id.button)
        webView = findViewById(R.id.webView)
        /// 加载 URL
        webView.loadUrl("file:///android_asset/demo.html")

        webView.registerHandler("submitFromWeb") { data, function ->
            Log.i(TAG, "handler = submitFromWeb, data from web = $data")
            function.onCallBack("submitFromWeb exe, response data 中文 from Java")
        }

        val user = MainActivity.User()
        user.name = "大头鬼"

        webView.callHandler("functionInJs", "this is user object") { }

        webView.send("hello")


        button.setOnClickListener {
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("weixin://")))
            webView.callHandler("functionInJs", "data from Java6") { data ->
                Log.e(TAG, "reponse data from js $data")
            }
        }
    }
}
