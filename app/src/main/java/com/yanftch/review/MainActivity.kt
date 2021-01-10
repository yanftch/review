package com.yanftch.review

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.location.Location
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.LruCache
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yanftch.review.android.modules.MenuItems
import com.yanftch.review.android.pages.*
import com.yanftch.review.android.pages.douyin.Page2DouYinActivity
import com.yanftch.review.android.pages.smartrefreshlayout.SmartActivity1
import com.yanftch.review.android.pages.smartrefreshlayout.SmartActivity2
import com.yanftch.review.android.pages.tablayout_viewpager_fragment.DiyTablayoutActivity
import com.yanftch.review.android.pages.tablayout_viewpager_fragment.SwitchFragmentActivity
import com.yanftch.review.android.pages.tablayout_viewpager_fragment.TabLayoutActivity
import com.yanftch.review.android.unit_test.UnitTestDemoActivity
import com.yanftch.review.android.view.InputDialogFragment
import com.yanftch.review.demo.ui.login.LoginActivity
import okhttp3.OkHttpClient
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk15.listeners.onClick
import java.util.*
import kotlin.collections.ArrayList


@Suppress("unused")
class MainActivity : AppCompatActivity() {
    val TAG = "debug_MainActivity"
    private lateinit var recyclerView: RecyclerView
    private lateinit var datas: ArrayList<MenuItems>
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
    private var mEditView: EditText? = null

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

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        var density = dm.density
        Log.e("debug_MainActivity:", "onCreate==> dm.density = " + density + ", dp2pd(20) = " + dip2px(this, 20f))


    }
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        Log.e("debug_MainActivity:", "dip2px==> scale = $scale   , screenWidth = " + getScreenWidth(this))
        return (dpValue * scale + 0.5f).toInt()
    }

    fun getScreenWidth(context: Context): Int {
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }
    fun getScreenHeight(context: Context): Int {
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }


    private fun generateDatas() {
        datas = ArrayList()
        datas.add(
            MenuItems(
                name = "Diy Tablayout Page ",
                clazz = DiyTablayoutActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "New Home Page ",
                clazz = NewHomeActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Load Image Page ",
                clazz = ImageLoadActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Nsv and Rv Page ",
                clazz = NsvAndRvActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "CalendarView Page ",
                clazz = CalendarViewActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "NestedScrollView 顶部图片缩放效果",
                clazz = NestedScrollViewWithScaleHeaderImageActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "smart 2",
                clazz = SmartActivity2::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "smart+悬浮",
                clazz = SmartActivity1::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "ViewPager2实现抖音切换",
                clazz = Page2DouYinActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "抖音切换",
                clazz = DouYinActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "瀑布流",
                clazz = StaggeredGridActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "ViewPager2 Demo",
                clazz = ViewPager2DemoActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Switch Fragment",
                clazz = SwitchFragmentActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "TabLayout",
                clazz = TabLayoutActivity::class.java
            )
        )

        datas.add(
            MenuItems(
                name = "ConstraintLayout",
                clazz = ConstraintLayoutActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "DIY  view",
                clazz = DiyViewActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "LoginActivity-Kotlin",
                clazz = LoginActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "NestedScrollView",
                clazz = NestedScrollViewActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "convenientbanner",
                clazz = ConvenientbannerActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "日程提醒",
                clazz = CalendarActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "单元测试",
                clazz = UnitTestDemoActivity::class.java
            )
        )

        datas.add(
            MenuItems(
                name = "PopupWindow",
                clazz = com.yanftch.review.android.pages.PopupWindowActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Bitmap",
                clazz = com.yanftch.review.android.pages.BitmapActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Animation",
                clazz = com.yanftch.review.android.pages.AnimationActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Service",
                clazz = com.yanftch.review.android.pages.ServiceActivity::class.java
            )
        )

        datas.add(
            MenuItems(
                name = "CoordinatorLayout",
                clazz = CoordinatorLayoutActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "RecyclerView",
                clazz = com.yanftch.review.android.pages.RecyclerViewActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "RxJava",
                clazz = com.yanftch.review.android.pages.RxJavaActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "ViewPager",
                clazz = com.yanftch.review.android.pages.ViewPagerActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Fragment lifecycle",
                clazz = com.yanftch.review.android.pages.FragmentActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Test Demo",
                clazz = TestActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Test Java Page",
                clazz = TestJavaActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Event",
                clazz = com.yanftch.review.android.pages.EventActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "WebView 与 JS",
                clazz = com.yanftch.review.android.pages.WebViewActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "AccessibilityService",
                clazz = com.yanftch.review.android.pages.AccessibilityServiceActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "JsBridge",
                clazz = com.yanftch.review.android.pages.JsBridgeActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "Life",
                clazz = com.yanftch.review.android.pages.LifecycleActivity::class.java
            )
        )
        datas.add(
            MenuItems(
                name = "ExpandableListView",
                clazz = com.yanftch.review.android.pages.ExpandableListViewActivity::class.java
            )
        )
    }

    private fun createContentView(): View =
        UI {
            verticalLayout {
                mEditView = editText {
                    hint = "一定要输入数字哈..."
                    imeOptions = EditorInfo.IME_ACTION_SEARCH
                    inputType = EditorInfo.TYPE_CLASS_NUMBER
                }
                button {
                    text = "click"
                    onClick {
                        var bean = BaseBean()
                        var wifiService = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                        var connectionInfo = wifiService.connectionInfo
                        Log.e("debug_", ": bssid = ${connectionInfo.bssid} ${connectionInfo.ssid}")



//                        var dlg: InputDialogFragment = InputDialogFragment()
//                        dlg.show(supportFragmentManager,"input")
//                        var mModel: PriceDialogModel? = PriceDialogModel()
//                        mModel?.title = "短租价格说明"
//                        mModel?.subTitle = "租期不满一年会根据不同租期上浮价格"
//                        mModel?.buttonText = "咨询价格详情"
//                        mModel?.leaseTitle = "租期"
//                        mModel?.originalPriceTitle = "原价"
//                        mModel?.prePriceTitle = "优惠价"
//                        val list = mutableListOf<ItemBean>()
//                        val item1 = ItemBean()
//                        item1.color = "#ff3737"
//                        item1.lease = "12个月以上"
//                        item1.originalPrice = "82991"
//                        item1.prePrice = "80991"
//                        item1.priceUnit = "/月"
//                        item1.unit = "$"
//                        val item2 = ItemBean()
//                        item2.color = "#ff3737"
//                        item2.lease = "4-11个月"
//                        item2.originalPrice = "82993"
//                        item2.prePrice = ""
//                        item2.priceUnit = "/月"
//                        item2.unit = "$"
//                        val item3 = ItemBean()
//                        item3.color = "#ff3737"
//                        item3.lease = "1-3个月"
//                        item3.originalPrice = "82993"
//                        item3.prePrice = "80993"
//                        item3.priceUnit = "/月"
//                        item3.unit = "￥"
//
//                        list.add(item1)
//                        list.add(item2)
//                        list.add(item3)
//                        mModel?.list = list
//
//                        val s = mEditView?.text?.toString()
//                        var toInt = s?.toInt()?:0
//                        mModel?.time = (toInt * 1000).toLong()
//                        mModel?.endMessage = "$toInt 结束了"
//
//                        var dialogFragment = TransDialogFragment.getInstance(mModel)
//                        dialogFragment.show(supportFragmentManager, "trans")
////                        newBidItemList.add(0, "4444")
////                        val commentDialogFragment = CommentDialogFragment()
////                        commentDialogFragment.setOnLoginInforCompleted { userName, passWord ->
////                            toast(passWord)
////                        }
////                        commentDialogFragment.show(supportFragmentManager, "CommentDialogFragment")

                    }
                }

                recyclerView = recyclerView().lparams(matchParent, matchParent)
            }
        }.view

    inner class RvAdapter() : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
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

            fun render(item: MenuItems) {
                title = itemView.find(R.id.text_view)
                title.text = item.name
                title.setOnClickListener {
                    if (item.clazz != null) {
                        startActivity(Intent(this@MainActivity, item.clazz))
                        overridePendingTransition(
                    0,
                            0
                        )

                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
//        Log.e("debug_MainActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
//        Log.e("debug_MainActivity", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
//        Log.e("debug_MainActivity", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
//        Log.e("debug_MainActivity", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.e("debug_MainActivity", "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
//        Log.e("debug_MainActivity", "onRestart: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        Log.e("debug_MainActivity", "onNewIntent: ")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
//        Log.e("debug_MainActivity", "onSaveInstanceState: ")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
//        Log.e("debug_MainActivity", "onRestoreInstanceState: ")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
//        Log.e("debug_MainActivity", "onConfigurationChanged: newConfig=${newConfig}")
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
