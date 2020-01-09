package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick


/**
 * Author : yanftch
 * Date   : 2019-10-26
 * Time   : 20:35
 * Desc   : 探索 Android 与 JS 之间的交互
 */

class WebViewActivity : AppCompatActivity() {

    private var url = "https://www.baidu.com"

    private lateinit var webView: WebView
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view())
        initWebView()

    }

    private fun initWebView() {
        val settings = webView.settings
        settings.javaScriptEnabled = true // 设置支持 JS
        webView.webChromeClient = WebChromeClient()
        webView.loadUrl("file:///android_asset/local.html")
        webView.addJavascriptInterface(JsInterface(), "channel_name")

    }

    private fun view() = UI {

        verticalLayout {
            button {
                text = "Android 给 JS 传值(loadUrl方法): (loadUrl方法)"
                onClick {
                    // Android 通过 loadUrl 调用 JS 中的 showInfoFromJava() 方法，传递参数()
                    // loadUrl 方式的缺点是无法给 Android 返回数据...
                    webView.loadUrl("javascript:showInfoFromJava('" + "(loadUrl方法)" + "')")
                }
            }
            button {
                text = "Android 给 JS 传值(evaluateJavascript方法): (evaluateJavascript)"
                onClick {
                    // Android 通过 evaluateJavascript 调用 JS 中的 showInfoFromJava2() 方法，传递参数()
                    // 该方法会返回 String 类型的返回值，也就是回传了 JS 给 Android 的信息
                    webView.evaluateJavascript(
                        "javascript:showInfoFromJava2('" + "(loadUrl方法)" + "')"
                    ) {
                        // 此处是 JS 给 Android 的回调信息
                        toast("message back from JS: $it")
                    }

                }
            }
            textView = textView {

            }

            lparams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

            webView = webView {
                id = com.yanftch.review.R.id.webView
            }.lparams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }.view
    inner class JsInterface {

        /**
         * 一定要在这添加注解
         */
        @JavascriptInterface
        fun showInfoFromJs(name: String) {
            toast("message from JS: $name")
            textView.text = "textView.text = $name"

            Log.e("IVEN", "showInfoFromJs中的信息: $name")
        }
    }



}
