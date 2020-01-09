package com.yanftch.review

import android.content.Intent
import android.content.res.Configuration
import android.location.Location
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.LruCache
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk15.listeners.onClick
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val TAG = "debug_MainActivity"
    private lateinit var recyclerView: RecyclerView
    private lateinit var datas: ArrayList<com.yanftch.review.android.modules.MenuItems>
    var hashMap: HashMap<String, Any>? = null
    var hashTab: Hashtable<String, Any>? = null
    private var scale = 1.0f
    private var okHttp: OkHttpClient? = OkHttpClient()
    private var linkedHashmap: LinkedHashMap<Any, Any>? = null
    //    private var sp: SharedPreferences? = getSharedPreferences("", MODE_PRIVATE)
    private var view: View? = null
    private var lruCache: LruCache<Any, Any>? = null
    private var glide: Glide? = null
    private var viewModel: ViewModel? = null

    init {
    }


    var obj: Any? = null
    var newBidItemList = arrayListOf<String>()

    internal class User {
        var name: String? = null
        var location: Location? = null
        var testStr: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createContentView())
        Log.e("debug_MainActivity", "onCreate: ")
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreatel() {
                Log.e("debug_MainActivity", "onCreatel: livecycle")
            }
        })
        generateDatas()
        val lm = LinearLayoutManager(this)

        recyclerView.adapter = RvAdapter()
        recyclerView.layoutManager = lm

    }


    private fun generateDatas() {
        datas = ArrayList()
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "PopupWindow",
                clazz = com.yanftch.review.android.pages.PopupWindowActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Bitmap",
                clazz = com.yanftch.review.android.pages.BitmapActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Animation",
                clazz = com.yanftch.review.android.pages.AnimationActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Service",
                clazz = com.yanftch.review.android.pages.ServiceActivity::class.java
            )
        )

        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "CoordinatorLayout",
                clazz = com.yanftch.review.android.pages.RecyclerViewActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "RecyclerView",
                clazz = com.yanftch.review.android.pages.RecyclerViewActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "RxJava",
                clazz = com.yanftch.review.android.pages.RxJavaActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "ViewPager",
                clazz = com.yanftch.review.android.pages.ViewPagerActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Fragment lifecycle",
                clazz = com.yanftch.review.android.pages.FragmentActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Test Demo",
                clazz = com.yanftch.review.android.pages.TestActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Event",
                clazz = com.yanftch.review.android.pages.EventActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "WebView 与 JS",
                clazz = com.yanftch.review.android.pages.WebViewActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "AccessibilityService",
                clazz = com.yanftch.review.android.pages.AccessibilityServiceActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "JsBridge",
                clazz = com.yanftch.review.android.pages.JsBridgeActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "Life",
                clazz = com.yanftch.review.android.pages.LifecycleActivity::class.java
            )
        )
        datas.add(
            com.yanftch.review.android.modules.MenuItems(
                name = "ExpandableListView",
                clazz = com.yanftch.review.android.pages.ExpandableListViewActivity::class.java
            )
        )
    }

    private fun createContentView(): View =
        UI {
            verticalLayout {
                //                editText {
//                    hint = "hind..."
//
//                }
                button {
                    text = "click"
                    onClick {
                        newBidItemList.add(0, "4444")

//                        alert {
//                            title = "title"
//                        }.show()
                    }
                }
                recyclerView = recyclerView().lparams(matchParent, matchParent)
            }
        }.view

    inner class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
            val view = layoutInflater.inflate(R.layout.rv_item, parent, false)
            return RvViewHolder(view)
        }

        override fun getItemCount() = datas.size

        override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
            holder.render(datas[position])
        }

        inner class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private lateinit var title: TextView

            fun render(item: com.yanftch.review.android.modules.MenuItems) {
                title = itemView.find(R.id.text_view)
                title.text = item.name
                title.setOnClickListener {
                    if (item.clazz != null) {
                        startActivity(Intent(this@MainActivity, item.clazz))
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("debug_MainActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e("debug_MainActivity", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("debug_MainActivity", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("debug_MainActivity", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("debug_MainActivity", "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("debug_MainActivity", "onRestart: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("debug_MainActivity", "onNewIntent: ")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        Log.e("debug_MainActivity", "onSaveInstanceState: ")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("debug_MainActivity", "onRestoreInstanceState: ")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.e("debug_MainActivity", "onConfigurationChanged: newConfig=${newConfig}")
    }














    fun test() {


        Hashtable<Any, Any>()


        var newName = "origin"
        newName = newName.substring(1, 2)


        methodName("自动补充参数")


    }

    private fun methodName(string: String) {
        println(string)
    }

}
