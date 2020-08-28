package com.yanftch.review.android.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.yanftch.review.R
import com.yanftch.review.android.modules.ItemBean
import com.yanftch.review.android.modules.PriceDialogModel
import com.yanftch.review.android.utils.DateUtil
import com.yanftch.review.android.utils.DensityUtil
import com.yanftch.review.android.view.CountDownView
import org.jetbrains.anko.backgroundColorResource
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.textColorResource
import java.lang.Exception

class TransDialogFragment : DialogFragment() {
    private lateinit var mLayoutInflater: LayoutInflater

    // 数据对象
    private var mModel: PriceDialogModel? = null
    private var mTimeCount: TimeCount? = null

    // 全局标记，用来表示是否显示【优惠价】的一列
    private var mHidePrePriceColumn = false

    // 标题
    private lateinit var mTvTitle: TextView
    private lateinit var mTvTime: TextView

    // 副标题
    private lateinit var mTvSubTitle: TextView

    // 按钮
    private lateinit var mTvButton: TextView

    // 表格 rows 根布局
    private lateinit var mLlTableRowsContainer: LinearLayout

    // 表格三个表头
    private lateinit var mTvTitleLease: TextView
    private lateinit var mTvTitlePrePrice: TextView
    private lateinit var mTvTitleOriginalPrice: TextView

    // 表头根容器
    private lateinit var mLlTableTitleContainer: LinearLayout

    private lateinit var mCountDownView: CountDownView

    companion object {
        fun getInstance(priceDialogModel: PriceDialogModel?): TransDialogFragment {
            val dialogFragment = TransDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable("model", priceDialogModel)
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onStart() {
        super.onStart()
        val defaultDisplay = dialog?.window?.windowManager?.defaultDisplay
//        val w = (defaultDisplay?.width?.times(0.8))?.toInt()
        val point = Point()
        defaultDisplay?.getSize(point)
        val width = point.x.times(0.8).toInt()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog?.window
        val layoutParams = window?.attributes
        layoutParams?.width = width
        window?.attributes = layoutParams
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            if (arguments?.containsKey("model") == true) {
                mModel = arguments?.getSerializable("model") as PriceDialogModel?
            }
        }
        mLayoutInflater = LayoutInflater.from(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zra_dialog_price_view, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        mTvTitle = view.findViewById(R.id.tv_title)
        mTvTime = view.findViewById(R.id.tv_time)
        mTvSubTitle = view.findViewById(R.id.tv_sub_title)
        mTvButton = view.findViewById(R.id.tv_button)
        mLlTableRowsContainer = view.findViewById(R.id.ll_table_rows_container)
        mLlTableTitleContainer = view.findViewById(R.id.ll_table_title_container)
        mTvTitleLease = view.findViewById(R.id.tv_title_lease)
        mTvTitlePrePrice = view.findViewById(R.id.tv_title_pre_price)
        mTvTitleOriginalPrice = view.findViewById(R.id.tv_title_original_price)
        mCountDownView = view.findViewById(R.id.countdown_view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()
    }

    @SuppressLint("LongLogTag")
    private fun render() {


        mTimeCount = TimeCount(3270000, 1000)
        mTimeCount?.start()

        mModel ?: return

        mCountDownView.setData(mModel?.time ?: 3600000, mModel?.endMessage)

        mTvTitle.text = mModel?.title
        mTvSubTitle.text = mModel?.subTitle
        mTvButton.text = mModel?.buttonText

        // 中间表格绘制
        val leaseTitle = mModel?.leaseTitle
        val prePriceTitle = mModel?.prePriceTitle
        val originalPriceTitle = mModel?.originalPriceTitle

        // 控制是否显示【优惠价】一列的赋值
        mHidePrePriceColumn = prePriceTitle.isNullOrEmpty()

        // 表头赋值
        mTvTitleLease.text = leaseTitle
        mTvTitlePrePrice.text = prePriceTitle

        // 如果不存在【优惠价】，原价的文案显示为【价格】，否则就取后端返回的
        if (mHidePrePriceColumn) {
            val p = if (originalPriceTitle.isNullOrEmpty()) "价格" else originalPriceTitle
            mTvTitleOriginalPrice.text = p
        } else {
            mTvTitleOriginalPrice.text =
                (if (originalPriceTitle.isNullOrEmpty()) "原价" else originalPriceTitle)
        }

        // 第二列是【优惠价】，可能不存在这一列
        mTvTitlePrePrice.visibility =
            if (prePriceTitle.isNullOrEmpty()) View.GONE else View.VISIBLE

        // 绘制每一行
        val list = mModel?.list ?: return
        //  先移除 所有 rows
        mLlTableRowsContainer.removeAllViews()
        list.forEach {
            // 添加分割线
            mLlTableRowsContainer.addView(getLineView())

            // 添加row
            mLlTableRowsContainer.addView(getRowView(it))
        }
        mTvButton.setOnClickListener {
            // TODO:yanfeng 2020-08-06
            toast("button click")
            mTimeCount?.cancel()
        }
    }

    private fun getLineView(): View {
        val view = View(activity)
        view.backgroundColorResource = R.color.color_14000000
        val lp = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            DensityUtil.dip2px(activity, 0.5f)
        )
        view.layoutParams = lp
        return view
    }

    /**
     * 每一横行view
     */
    @SuppressLint("SetTextI18n", "InflateParams")
    private fun getRowView(itemBean: ItemBean?): View {
        val bean = itemBean ?: return View(activity)
        val rowView = mLayoutInflater.inflate(R.layout.zra_dialog_rows_item, null, false)

        // 租期
        val tvLease = rowView.findViewById<TextView>(R.id.tv_lease)

        // 优惠价
        val tvPrePrice = rowView.findViewById<TextView>(R.id.tv_pre_price)
        val tvPrePriceUnit = rowView.findViewById<TextView>(R.id.tv_pre_price_unit)
        val flPrePriceContainer = rowView.findViewById<LinearLayout>(R.id.ll_pre_price_container)

        // 原价 OR 价格
        val tvOriginalPrice = rowView.findViewById<TextView>(R.id.tv_original_price)
        val tvOriginalPriceUnit = rowView.findViewById<TextView>(R.id.tv_original_price_unit)

        // 赋值操作
        tvLease.text = bean.lease

        tvPrePrice.text = if (bean.prePrice.isEmpty()) "/" else "${bean.unit}${bean.prePrice}"
        tvPrePriceUnit.text = if (bean.prePrice.isEmpty()) "" else bean.priceUnit

        tvOriginalPrice.text = "${bean.unit}${bean.originalPrice}"
        tvOriginalPriceUnit.text = bean.priceUnit

        // 优惠价，控制显隐一列
        flPrePriceContainer.visibility = if (mHidePrePriceColumn) View.GONE else View.VISIBLE

        // 样式处理
        if (mHidePrePriceColumn) {
            // 不显示 优惠价 一列的时候
            tvOriginalPrice.paintFlags = tvPrePrice.paintFlags
            tvOriginalPrice.textColorResource = R.color.color_ct1_85
            tvOriginalPriceUnit.textColorResource = R.color.color_ct1_85
        } else {
            // 显示 优惠价 一列的时候
            // 优惠价 变色处理
            if (bean.prePrice.isEmpty()) {
                tvPrePrice.textColorResource = R.color.color_ct1_85
                tvPrePriceUnit.textColorResource = R.color.color_ct1_85
            } else {
                if (bean.color.isEmpty()) {
                    val textColor = Color.parseColor("#FF3737")
                    tvPrePrice.setTextColor(textColor)
                    tvPrePriceUnit.setTextColor(textColor)
                } else {
                    try {
                        val textColor = Color.parseColor(bean.color)
                        tvPrePrice.setTextColor(textColor)
                        tvPrePriceUnit.setTextColor(textColor)
                    } catch (e: Exception) {
                        val textColor = Color.parseColor("#FF3737")
                        tvPrePrice.setTextColor(textColor)
                        tvPrePriceUnit.setTextColor(textColor)
                    }
                }
            }
            // 原价添加横华线
            tvOriginalPrice.paintFlags = tvPrePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            tvOriginalPrice.textColorResource = R.color.color_ct1_40
            tvOriginalPrice.textColorResource = R.color.color_ct1_40
        }
        return rowView
    }


    /**
     * 倒计时类
     */
    inner class TimeCount(total: Long, interval: Long) : CountDownTimer(total, interval) {
        override fun onFinish() {
            mTvTime.text = "完成了"
        }

        override fun onTick(millisUntilFinished: Long) {
            val second: Int = ((millisUntilFinished / 1000).toInt())
//            Log.e("debug_TimeCount:", "onTick==>second = $second")
//            val second: Int = ((millisUntilFinished / 1000).toInt())
            mTvTime.text = DateUtil.secToTime(second)

            //            mTvBottomHint.setText(btnStr + DateUtil.secToTime(second));
        }
    }
}