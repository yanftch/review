package com.yanftch.review.android.pages.vp2

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.yanftch.review.R
import com.yanftch.review.android.modules.HouseListItem
import com.yanftch.review.android.utils.DensityUtil

class FindZraMapPopView @kotlin.jvm.JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var ctx: Context = context
    private lateinit var bannerView: ViewPager2
    private var mIndicatorMarginRight = 0
    private var mIndicatorMarginBottom = 0
    private val TAG = "debug_FindZraMapPopView"


    init {
        mIndicatorMarginRight = DensityUtil.dip2px(ctx, 20f)
        mIndicatorMarginBottom = DensityUtil.dip2px(ctx, 20f)

        LayoutInflater.from(ctx).inflate(R.layout.z_find_zra_map_popwindow_child_view, this, true)
        bannerView = findViewById(R.id.vp_banner_container)

        bannerView.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.e(TAG, "onPageSelected: position ==== $position")
            }

            override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {
            }
        })
    }

    fun updateData(dataList: List<HouseListItem>) {
        if (dataList.isNullOrEmpty()) {
            this.visibility = View.GONE
            bannerView.visibility = View.GONE
            return
        }
        // 赋值
        this.visibility = View.VISIBLE
        bannerView.visibility = View.VISIBLE
        bannerView.adapter = FindZraPopAdapter(ctx, dataList)
        bannerView.setPageTransformer(getMarginTransformer())
    }


    private fun getMarginTransformer(
        padding: Int = DensityUtil.dip2px(ctx, 20f),
        marginTransformer: Int = DensityUtil.dip2px(ctx, 10f)
    ): CompositePageTransformer {
        (bannerView.getChildAt(0) as RecyclerView).apply {
            setPadding(padding, 0, padding, 0)
            clipToPadding = false
        }
        CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(marginTransformer))
            return this
        }
    }

}