package com.yanftch.review.android.fragment.new_home

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSONObject
import com.facebook.drawee.view.SimpleDraweeView
import com.yanftch.review.R
import com.yanftch.review.android.dialog.LoadingDialog
import com.yanftch.review.android.fragment.DividerItemDecoration
import com.yanftch.review.android.fragment.new_home.model.ZraLiveInfoVo
import com.yanftch.review.android.utils.DensityUtil
import org.jetbrains.anko.textColor
import kotlin.random.Random

private const val ARG_PARAM = "jsonStr"

// 直播按钮样式：1=直播中
private const val LIVE_BUTTON_STYLE_LIVING = 1

// 直播按钮样式：2=预告已关注
private const val LIVE_BUTTON_STYLE_PRE_LIVE_WATCHED = 2

// 直播按钮样式：3=预告未关注
private const val LIVE_BUTTON_STYLE_PRE_LIVE_UNWATCHED = 3
private const val TAG = "debug_ZraMainLiveFragment"

/**
 * User : yanftch
 * Date : 2021/1/12
 * Time : 17:15
 * Desc : 首页-直播列表Fragment
 */
class ZraMainLiveFragment : Fragment() {

    private var mFragmentActivity: FragmentActivity? = null

    private var mJsonStr: String? = null
    private var mList: MutableList<ZraLiveInfoVo.LiveDataBean> = mutableListOf()
    private lateinit var mAdapter: LiveAdapter
    private lateinit var mLayoutInflater: LayoutInflater


    private lateinit var mRvList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentActivity = activity
        arguments?.let {
            mJsonStr = it.getString(ARG_PARAM)
        }
        try {
            mList = JSONObject.parseArray(mJsonStr, ZraLiveInfoVo.LiveDataBean::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // TODO:yanfeng 2021/1/25 测试
//        mList = mList.subList(2 ,3)

        mLayoutInflater = LayoutInflater.from(mFragmentActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.zra_fragment_main_live_layout, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderData()
    }

    fun initView(view: View) {

        mRvList = view.findViewById(R.id.rv_live_list)
        if (mList.size == 2) {
            val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            lp.rightMargin = DensityUtil.dip2px(mFragmentActivity, 16f)
            mRvList.layoutParams = lp

            mRvList.layoutManager =
                LinearLayoutManager(mFragmentActivity, LinearLayoutManager.VERTICAL, false)
            mRvList.addItemDecoration(DividerItemDecoration(mFragmentActivity, 10f))
        } else {
            mRvList.layoutManager =
                LinearLayoutManager(mFragmentActivity, LinearLayoutManager.HORIZONTAL, false)
        }
        mAdapter = LiveAdapter()
        mRvList.adapter = mAdapter

    }

    private fun renderData() {

    }

    companion object {
        @JvmStatic
        fun newInstance(jsonStr: String) =
            ZraMainLiveFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, jsonStr)
                }
            }
    }

    inner class LiveAdapter : RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {
        private val TYPE_ITEM_ONE = 1 // 单个卡片
        private val TYPE_ITEM_TWO = 2 // 单个卡片
        private val TYPE_ITEM_MORE = 3 // 大于1个卡片

        inner class LiveViewHolder(_itemView: View) : RecyclerView.ViewHolder(_itemView) {
            private var mTvName: TextView? = null
            private var mTvSubTitle: TextView? = null
            private var mTvButton: TextView? = null
            private var mPvHeader: SimpleDraweeView? = null // 头像

            //            private var mPvHeader: PictureView? = null // 头像
            private var mRootView: View

            // 直播中的UI
            private var mRlLiveContainer: RelativeLayout? = null
            private var mPvLiveIcon: SimpleDraweeView? = null

            //            private var mPvLiveIcon: PictureView? = null
            private var mIvLiveState: ImageView? = null
            private var mFlOuterContainer: FrameLayout? = null
            private var mFlHeaderContainer: FrameLayout? = null
//            private var mFlRootView: FrameLayout

            init {
                mTvName = _itemView.findViewById(R.id.tv_name)
                mTvSubTitle = _itemView.findViewById(R.id.tv_sub_title)
                mTvButton = _itemView.findViewById(R.id.tv_btn)
                mPvHeader = _itemView.findViewById(R.id.pv_keeper_header)
                mRootView = _itemView
                mRlLiveContainer = _itemView.findViewById(R.id.rl_container_base)
                mPvLiveIcon = _itemView.findViewById(R.id.zra_pv_user_icon)
                mIvLiveState = _itemView.findViewById(R.id.iv_live_state)
                mFlOuterContainer = _itemView.findViewById(R.id.fl_container_outer)
                mFlHeaderContainer = _itemView.findViewById(R.id.fl_header_container)

//                mFlRootView = _itemView.findViewById(R.id.fl_container)

//                if (mList.size == 2) {
//                    var lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
//                    mFlRootView.layoutParams = lp
//                }

            }

            fun render(bean: ZraLiveInfoVo.LiveDataBean?) {
                bean ?: return

                // 名字
                mTvName?.text = bean.projectName
                // TODO:yanfeng 2021/1/12 左边添加小图标  android:drawableStart="@drawable/l_time"
                // 时间
                mTvSubTitle?.text = bean.liveShowTime
                mIvLiveState?.setImageResource(if (bean.isLiving) R.drawable.img_live_bg_28_zra else R.drawable.img_notice_bg_28_zra)

                if (bean.isLiving) {
                    mPvHeader?.visible = false
                    mRlLiveContainer?.visible = true

                    mPvLiveIcon?.setImageURI(bean.img)
                    // TODO:yanfeng 2021/1/12 替换如下方法
//                    mPvLiveIcon?.setImageUri(bean.img)?.display()

                    // TODO:yanfeng 2021/1/12 放开代码
//                    mPvLiveIcon?.setPlaceHolderImage(R.drawable.img_portrait)

                    val animatorSet = AnimatorSet()
                    // 外圈
                    val objectAnimator: ObjectAnimator =
                        ObjectAnimator.ofFloat(mFlOuterContainer, View.SCALE_X, 1f, 1.2f)
                    val objectAnimator2 =
                        ObjectAnimator.ofFloat(mFlOuterContainer, View.SCALE_Y, 1f, 1.2f)
                    val objectAnimator3 =
                        ObjectAnimator.ofFloat(mFlOuterContainer, View.ALPHA, 1f, 0f)
                    objectAnimator.repeatCount = Animation.INFINITE // 设置循环次数(无限循环)

                    objectAnimator2.repeatCount = Animation.INFINITE
                    objectAnimator3.repeatCount = Animation.INFINITE
                    val oaHeaderViewX =
                        ObjectAnimator.ofFloat(mFlHeaderContainer, View.SCALE_X, 1f, 0.8f, 1f)
                    val oaHeaderViewY =
                        ObjectAnimator.ofFloat(mFlHeaderContainer, View.SCALE_Y, 1f, 0.8f, 1f)
                    oaHeaderViewX.repeatCount = Animation.INFINITE // 设置循环次数(无限循环)

                    oaHeaderViewY.repeatCount = Animation.INFINITE
                    animatorSet.duration = 1000 // 动画时间

                    animatorSet.playTogether(
                        objectAnimator,
                        objectAnimator2,
                        objectAnimator3,
                        oaHeaderViewX,
                        oaHeaderViewY
                    )
                    animatorSet.start()

                } else { // 非直播中
                    mPvHeader?.visible = false
                    mRlLiveContainer?.visible = true
                    mPvLiveIcon?.setImageURI(bean.img)


//                    mPvHeader?.setImageURI(bean.img)
                    // TODO:yanfeng 2021/1/12 替换如下方法
//                    mPvHeader?.setImageUri(bean?.img)?.display()

                }

                var buttonStyle = LIVE_BUTTON_STYLE_PRE_LIVE_UNWATCHED // 按钮样式默认为3(关注直播)
                buttonStyle = if (bean.isLiving) {
                    LIVE_BUTTON_STYLE_LIVING
                } else {
                    if (bean.hasWatched()) {
                        LIVE_BUTTON_STYLE_PRE_LIVE_WATCHED
                    } else {
                        LIVE_BUTTON_STYLE_PRE_LIVE_UNWATCHED
                    }
                }

                toggleButtonStyle(buttonStyle)

                mTvButton?.setOnClickListener {
//                    mOnItemClickListener?.onCallClick(bean)
                    // TODO:yanfeng 2021/1/13 调用接口，接口回来以后切换按钮样式
                    val loadingDialog = LoadingDialog(object :LoadingDialog.OnDismissCallback{

                        @SuppressLint("LongLogTag")
                        override fun onCallBack() {
                            val random = (1..3).random()

                            Log.e(TAG, "onCallBack: random = $random" )
                            toggleButtonStyle(random)

                        }
                    })
                    mFragmentActivity?.supportFragmentManager?.let { it1 -> loadingDialog.show(it1, "loading") }

//                    toggleButtonStyle()
                }

                mRootView.setOnClickListener {
                    //                    mOnItemClickListener?.onItemClick(bean)
                }
            }

            /**
             * 切换按钮的样式，目前分三种：
             * 1: 直播中(进入直播)
             * 2: 预告未关注(关注直播)
             * 3: 预告已关注(已关注)
             */
            fun toggleButtonStyle(value: Int) {
                when (value) {
                    LIVE_BUTTON_STYLE_LIVING -> {
                        mTvButton?.text = "进入直播"
                        mTvButton?.textColor = ContextCompat.getColor(
                            mFragmentActivity ?: mRootView.context,
                            R.color.white
                        )
                        mTvButton?.background = ContextCompat.getDrawable(
                            mFragmentActivity ?: mRootView.context,
                            R.drawable.bg_rectangle_ct4_radius_14
                        )
                    }
                    LIVE_BUTTON_STYLE_PRE_LIVE_UNWATCHED -> {
                        mTvButton?.text = "关注直播"
                        mTvButton?.textColor = ContextCompat.getColor(
                            mFragmentActivity ?: mRootView.context,
                            R.color.color_ct4
                        )
                        mTvButton?.background = ContextCompat.getDrawable(
                            mFragmentActivity ?: mRootView.context,
                            R.drawable.bg_rectangle_ct4_stock_1_radius_14
                        )
                    }
                    LIVE_BUTTON_STYLE_PRE_LIVE_WATCHED -> {
                        mTvButton?.text = "已关注"
                        mTvButton?.textColor = ContextCompat.getColor(
                            mFragmentActivity ?: mRootView.context,
                            R.color.color_D9000000
                        )
                        mTvButton?.background = ContextCompat.getDrawable(
                            mFragmentActivity ?: mRootView.context,
                            R.drawable.bg_rectangle_c13_radius_14
                        )
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
            if (getItemViewType(viewType) == TYPE_ITEM_ONE) {
                return LiveViewHolder(
                    mLayoutInflater.inflate(
                        R.layout.zra_item_layout_live_item_single,
                        parent,
                        false
                    )
                )
            } else if (getItemViewType(viewType) == TYPE_ITEM_TWO) {
                return LiveViewHolder(
                    mLayoutInflater.inflate(
                        R.layout.zra_item_layout_live_item_single,
                        parent,
                        false
                    )
                )
            }
            return LiveViewHolder(
                mLayoutInflater.inflate(
                    R.layout.zra_item_layout_live_item,
                    parent,
                    false
                )
            )
        }

        override fun getItemViewType(position: Int): Int {
            return itemCount
        }

        override fun getItemCount() = mList.size

        override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
            holder.render(mList[position])
        }
    }
}