package com.yanftch.review.android.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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
import com.yanftch.review.android.modules.VideoEvaluateBean
import com.yanftch.review.android.modules.VideoEvaluateOptionBean
import com.yanftch.review.android.utils.ScreenUtils

class EvaluateDialogFragment : DialogFragment() {

    // 数据对象
    private var model: VideoEvaluateBean? = null

    // 标题
    private lateinit var tvTitle: TextView

    // 副标题
    private lateinit var tvSubTitle: TextView

    private lateinit var rg: RadioGroup

    private lateinit var tvButton: TextView

    companion object {
        fun getInstance(priceDialogModel: VideoEvaluateBean?): EvaluateDialogFragment {
            val dialogFragment = EvaluateDialogFragment()
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
                model = arguments?.getSerializable("model") as VideoEvaluateBean?
            }
        }
        model = VideoEvaluateBean()
        model?.title = "评价标题"
        model?.subTitle = "评价副标题-公积金将国家国际其具体改价格叫他经济条件"

        val list = mutableListOf<VideoEvaluateOptionBean>()

        val a = VideoEvaluateOptionBean()
        a.option = "A"
        a.text = "选项A的提示文案"

        val b = VideoEvaluateOptionBean()
        b.option = "B"
        b.text = "选项B的提示文案"

        val c = VideoEvaluateOptionBean()
        c.option = "C"
        c.text = "选项C的提示文案"

        val d = VideoEvaluateOptionBean()
        d.option = "D"
        d.text = "选项D的提示文案"

        list.add(a)
        list.add(b)
        list.add(c)
        list.add(d)
        model?.list = list
        Log.e("debug_EvaluateDialogFragment:", "onCreate==>" + "曝光埋点")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zra_dialog_share_evaluate_view, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        tvTitle = view.findViewById(R.id.tv_title)
        tvSubTitle = view.findViewById(R.id.tv_sub_title)
        rg = view.findViewById(R.id.rg_group)
        tvButton = view.findViewById(R.id.tv_submit)

        view.findViewById<View>(R.id.iv_close_dialog).setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()
    }

    @SuppressLint("LongLogTag")
    private fun render() {
        model?.let {
            tvTitle.text = it.title
            tvSubTitle.text = it.subTitle

            rg.removeAllViews()

            if (!it.list.isNullOrEmpty()) {
                it.list.forEachIndexed { index, videoEvaluateOptionBean ->
                    rg.addView(getRadioButton(videoEvaluateOptionBean, index))
                }
            }
        }

        rg.setOnCheckedChangeListener { _, _ ->
            tvButton.setBackgroundResource(R.drawable.bg_rectangle_c4_radius_4)
            context?.let { ContextCompat.getColor(it, R.color.color_ct2) }?.let {
                tvButton.setTextColor(
                    it
                )
            }
        }

        tvButton.setOnClickListener {
            // 两种方式都可以，但是第二种感觉有风险...
            for (index in 0 until rg.childCount) {
                val rb = rg.getChildAt(index) as RadioButton
                if (rb.isChecked) {
                    val tag = rb.tag
                    Toast.makeText(context, "tag = $tag", Toast.LENGTH_SHORT).show()
                }
            }
//            val btn = view?.findViewById<RadioButton>(rg.checkedRadioButtonId)
//            Toast.makeText(context, "btn.text = ${btn?.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getRadioButton(bean: VideoEvaluateOptionBean, index: Int): RadioButton {
        val radioButton = RadioButton(context)
        val params = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        if (index > 0) {
//            params.topMargin = 16.dp
            params.topMargin = ScreenUtils.dp2px(context, 16f)
        } else {
            params.topMargin = ScreenUtils.dp2px(context, 0f)
        }

        radioButton.layoutParams = params
        radioButton.text = bean.text
        radioButton.tag = bean.option
        radioButton.setLines(1)
        radioButton.ellipsize = TextUtils.TruncateAt.END
        radioButton.setButtonDrawable(0) // 隐藏默认圆圈
        radioButton.setPadding(
            ScreenUtils.dp2px(context, 16f),
            ScreenUtils.dp2px(context, 14f),
            0,
            ScreenUtils.dp2px(context, 14f)
        )
        radioButton.textSize = 15f
        val color = context?.let { ContextCompat.getColorStateList(it, R.color.video_rb_tv_color) }
        radioButton.setTextColor(color)
        radioButton.setBackgroundResource(R.drawable.video_rb_bg)
        return radioButton
    }

}