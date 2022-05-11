package com.yanftch.review.android.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.yanftch.review.R
import com.yanftch.review.android.modules.VideoCouponBean
import com.yanftch.review.android.modules.VideoEvaluateBean
import com.yanftch.review.android.modules.VideoEvaluateOptionBean
import com.yanftch.review.android.utils.ScreenUtils

class VideoCouponDialog : DialogFragment() {

    // 数据对象
    private var model: VideoCouponBean? = null

    // 标题
    private lateinit var tvTitle: TextView

    // 副标题
    private lateinit var tvSubTitle: TextView

    // 金额
    private lateinit var tvPrice: TextView

    // 时间
    private lateinit var tvDate: TextView

    private lateinit var tvButton: TextView

    interface OnAcceptClick{
        fun accept()
    }
    private var listener: OnAcceptClick? = null
    fun setOnAcceptClick(l: OnAcceptClick) {
        listener = l
    }

    companion object {
        fun getInstance(priceDialogModel: VideoCouponBean?): VideoCouponDialog {
            val dialogFragment = VideoCouponDialog()
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
        dialog?.setCanceledOnTouchOutside(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            if (arguments?.containsKey("model") == true) {
                model = arguments?.getSerializable("model") as VideoCouponBean?
            }
        }
        model = VideoCouponBean()
        model?.name = "优惠券的名字"
        model?.money = "1000大洋"
        model?.endTime = "结束时间是：2022年03月22日"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zra_dialog_video_coupon_view, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        tvTitle = view.findViewById(R.id.tv_title)
        tvSubTitle = view.findViewById(R.id.tv_content_title)
        tvPrice = view.findViewById(R.id.tv_price)
        tvDate = view.findViewById(R.id.tv_date)
        tvButton = view.findViewById(R.id.tv_button)

        view.findViewById<View>(R.id.iv_close_dialog).setOnClickListener {
            Log.e("debug_", "isNet = $isNeting")
if (isNeting) {

} else {

            dismissAllowingStateLoss()
}
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()
    }

    var isNeting = false

    @SuppressLint("LongLogTag")
    private fun render() {
        model?.let {
            tvSubTitle.text = it.name
            tvPrice.text = it.money
            tvDate.text = it.endTime
        }
        tvButton.setOnClickListener {
            Toast.makeText(context, "领取按钮", Toast.LENGTH_SHORT).show()
            listener?.accept()
            isNeting = true
            Handler().postDelayed(Runnable {
                                           Log.e("debug_lingquan", "领钱了")
                isNeting = false
            }, 4000)
        }
    }

}