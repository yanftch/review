package com.yanftch.review.android.fragment.new_home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.yanftch.review.R
import com.yanftch.review.android.fragment.new_home.model.SpecialPriceHouseBean
import com.yanftch.review.android.utils.DensityUtil
import com.yanftch.review.android.utils.ScreenUtils

/**
 * User : yanftch
 * Date : 2021/1/11
 * Time : 14:07
 * Desc : 首页特价房列表adapter
 */
class ZraMainSpecialHouseListAdapter(
    context: Context,
    list: MutableList<SpecialPriceHouseBean.SpecialPriceHouseVosBean>
) :
    RecyclerView.Adapter<ZraMainSpecialHouseListAdapter.SpecialHouseViewHolder>() {


    private val TYPE_ITEM_ONE = 1 // 单个卡片
    private val TYPE_ITEM_TWO = 2 // 2个卡片
    private val TYPE_ITEM_THREE = 3 // 大于三个卡片

    private var mLayoutInflater: LayoutInflater
    private var mContext: Context = context

    private var mList: MutableList<SpecialPriceHouseBean.SpecialPriceHouseVosBean> = mutableListOf()

    init {
        this.mList = list
        mLayoutInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialHouseViewHolder {
        if (getItemViewType(viewType) == TYPE_ITEM_ONE) {
            val inflate =
                mLayoutInflater.inflate(
                    R.layout.zra_item_layout_special_house_itemview_one,
                    parent,
                    false
                )
            return SpecialHouseViewHolder(inflate, viewType)
        }
        val inflate =
            mLayoutInflater.inflate(R.layout.zra_item_layout_special_house_itemview, parent, false)
        return SpecialHouseViewHolder(inflate, viewType)
    }

    override fun getItemCount() = Math.min(TYPE_ITEM_THREE, mList.size)

    override fun getItemViewType(position: Int) = itemCount

    override fun onBindViewHolder(holder: SpecialHouseViewHolder, position: Int) {
        holder.render(mList[position], position)
    }

    inner class SpecialHouseViewHolder(_itemView: View, viewType: Int) :
        RecyclerView.ViewHolder(_itemView) {

        private var mTvTitle: TextView
        private var mTvSubTitle: TextView
        private var mTvContentLeft: TextView
        private var mTvContentRight: TextView
        private var mPvImage: SimpleDraweeView
        private var mViewType: Int

        private var mRootView: View = _itemView

        private val ASPECT_RATIO_TWO = 151.5f / 114
        private val ASPECT_RATIO_THREE = 120f / 90


        init {
            mTvTitle = mRootView.findViewById(R.id.tv_title)
            mTvSubTitle = mRootView.findViewById(R.id.tv_sub_title)
            mTvContentLeft = mRootView.findViewById(R.id.tv_content_left)
            mTvContentRight = mRootView.findViewById(R.id.tv_content_right)
            mPvImage = mRootView.findViewById(R.id.pv_image)
            mViewType = viewType
        }

        @SuppressLint("SetTextI18n")
        fun render(
            bean: SpecialPriceHouseBean.SpecialPriceHouseVosBean?,
            position: Int
        ) {
            bean ?: return
            // TODO:yanfeng 2021/1/11 图片加载方式替换
            // 图片
            mPvImage.setImageURI(bean.houseTypePic)
            //            mPvImage.setController(ImageUtil.frescoController(bean.houseTypePic));

            if (getItemViewType(position) == TYPE_ITEM_TWO) {
                // 展示两个卡片
                val screenWidth = ScreenUtils.getScreenWidth(mContext)
                val itemWidth = (screenWidth - DensityUtil.dip2px(
                    mContext,
                    24f + 16 * 2
                ) - DensityUtil.dip2px(
                    mContext,
                    20f
                )) / 2 // 计算每个卡片的宽度，-24是因为整个容器距离屏幕左右各有8dp距离，然后内部距离左边又有8dp的距离，所以-24dp,然后再减去左右各自的16dp(距离屏幕距离)
                val layoutParams = mRootView.layoutParams
                layoutParams.width = itemWidth
                val pvLayoutParams = mPvImage.layoutParams
                pvLayoutParams.width = itemWidth
                pvLayoutParams.height = (itemWidth / ASPECT_RATIO_TWO).toInt()
                mPvImage.requestLayout()

            } else if (getItemViewType(position) == TYPE_ITEM_THREE) {
                // 展示三个卡片
                val screenWidth = ScreenUtils.getScreenWidth(mContext)
                val itemWidth = (screenWidth - DensityUtil.dip2px(
                    mContext,
                    24f + 16 * 2
                )) / 2.5 // 计算每个卡片的宽度，-24是因为整个容器距离屏幕左右各有8dp距离，然后内部距离左边又有8dp的距离，所以-24dp
                val layoutParams = mRootView.layoutParams
                layoutParams.width = itemWidth.toInt()
                val pvLayoutParams = mPvImage.layoutParams
                pvLayoutParams.width = itemWidth.toInt()
                pvLayoutParams.height = (itemWidth / ASPECT_RATIO_THREE).toInt()
                mPvImage.requestLayout()
            }

            // 标题
            val titleSb = StringBuffer()
            if (!TextUtils.isEmpty(bean.houseTypeName)) {
                titleSb.append(bean.houseTypeName)
            }
            if (!TextUtils.isEmpty(bean.projectName) && getItemViewType(position) == TYPE_ITEM_ONE) {
                if (titleSb.isNotEmpty()) {
                    titleSb.append(" · ")
                }
                titleSb.append(bean.projectName)
            }
            mTvTitle.text = titleSb.toString()


            // 副标题
            mTvSubTitle.text = "${bean.businessCircle}|${bean.area}"

            // 描述信息
            mTvContentLeft.text = bean.amountTxt
            mTvContentRight.text = bean.amount

            // TODO:yanfeng 2021/1/11 点击事件，跳转项目页或者房型页！！！！！

            mRootView.setOnClickListener {
                if (bean.isProjectDetailType) {
                    val bundle = Bundle()
                    bundle.putString(
                        "projectId",
                        if (bean.projectFid == null) "" else bean.projectFid
                    )
                    // TODO:yanfeng 2021/1/11 放开下边的代码
//                    Routers.open(mContext, ConstantValues.DataUrls.MEETA_ZRA_DETAILS_PAGE, bundle)
                } else if (bean.isHouseTypeDetailType) {
                    val bundle = Bundle()
                    bundle.putString(
                        "projectId",
                        if (bean.projectFid == null) "" else bean.projectFid
                    )
                    bundle.putString(
                        "projectName",
                        if (bean.projectName == null) "" else bean.projectName
                    )
                    bundle.putString(
                        "houseTypeId",
                        if (bean.houseTypeFid == null) "" else bean.houseTypeFid
                    )
                    bundle.putBoolean("isProjectInfoShow", true)
                    // TODO:yanfeng 2021/1/11 放开下边的代码
//                    Routers.open(mContext, ConstantValues.DataUrls.ZRA_HOUSE_TYPE_INFO, bundle)
                }
            }
        }
    }
}