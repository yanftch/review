package com.yanftch.review.android.dialog

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.yanftch.review.R
import com.yanftch.review.android.modules.PriceDialogModel

class ShareTokenDialogFragment : DialogFragment() {
    private lateinit var mLayoutInflater: LayoutInflater

    // 数据对象
    private var mModel: PriceDialogModel? = null

    // 标题
    private lateinit var mTvTitle: TextView

    // 副标题
    private lateinit var mTvSubTitle: TextView

    private lateinit var buttonShare: TextView

    companion object {
        fun getInstance(priceDialogModel: PriceDialogModel?): ShareTokenDialogFragment {
            val dialogFragment = ShareTokenDialogFragment()
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
        dialog?.setCanceledOnTouchOutside(true)
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
        val view = inflater.inflate(R.layout.zra_dialog_share_token_view, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        mTvTitle = view.findViewById(R.id.tv_title)
        mTvSubTitle = view.findViewById(R.id.tv_sub_title)
        buttonShare = view.findViewById(R.id.tv_share)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()
    }

    @SuppressLint("LongLogTag")
    private fun render() {

        mTvTitle.setText("分享标题")
        mTvSubTitle.text = "估计高精尖我阿囧更加聚焦哦；改进就GIA结构我阿济格我几个我偶记按国家"


        buttonShare.setOnClickListener {
            Toast.makeText(context, "分享点击", Toast.LENGTH_SHORT).show()
            dismissAllowingStateLoss()
            goWeChat(this.context)
//            val intent = Intent()
//            val cmp: ComponentName =
//                ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI")
//            intent.setAction(Intent.ACTION_MAIN)
//            intent.addCategory(Intent.CATEGORY_LAUNCHER)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            intent.setComponent(cmp)
//            startActivity(intent)
        }
    }

    fun goWeChat(context: Context?) {
        val uri = Uri.parse("weixin://")
        Intent(Intent.ACTION_VIEW, uri).apply {
            context?.startActivity(this)
        }
    }

}