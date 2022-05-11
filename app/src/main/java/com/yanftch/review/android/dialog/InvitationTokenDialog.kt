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
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.yanftch.review.R
import com.yanftch.review.android.modules.PriceDialogModel
import com.yanftch.review.android.modules.VideoInviteTokenBean
import org.jetbrains.anko.find

/**
 * User : yanftch
 * Date : 2022/3/26
 * Time : 10:42
 * Desc : 口令邀请，解密弹窗
 */
class InvitationTokenDialog : DialogFragment() {

    // 数据对象
    private var model: VideoInviteTokenBean? = null

    private var pvImg: View? = null
    private var pvHeader: ImageView? = null
    private var tvTitle: TextView? = null
    private var tvSubTitle: TextView?=  null
    private var tvButton: TextView? = null


    companion object {
        fun getInstance(model: VideoInviteTokenBean?): InvitationTokenDialog {
            val dialogFragment = InvitationTokenDialog()
            val bundle = Bundle()
            bundle.putSerializable("model", model)
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
                model = arguments?.getSerializable("model") as VideoInviteTokenBean?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zra_dialog_invite_token_view, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        pvImg = view.findViewById(R.id.pv_image)
        pvHeader = view.findViewById(R.id.pv_header)
        tvTitle = view.findViewById(R.id.tv_title)
        tvSubTitle = view.findViewById(R.id.tv_sub_title)
        tvButton = view.findViewById(R.id.tv_open)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        render()
    }


    private fun render() {
        model?.projectInfo?.let {
            tvTitle?.text = it.projectName
        }
        model?.shareInfo?.let {
            tvSubTitle?.text = it.userName
//        pvHeader

        }

        tvButton?.setOnClickListener {

        }

//        pvImg


    }
}