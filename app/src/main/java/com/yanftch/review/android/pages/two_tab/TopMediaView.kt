package com.yanftch.review.android.pages.two_tab

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.yanftch.review.R

const val TYPE_VIDEO = 1
const val TYPE_VR = 2
const val TYPE_ALBUM = 3
const val TYPE_VIDEOQJ = 4
const val TYPE_HX = 5

/**
 * 顶部多媒体视图
 */
class TopMediaView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var vpMedia: ViewPager2
    private var adapter: ZraTopMediaVPAdapter? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.zra_layout_detail_top_media_view, this, true)
        initView()
    }

    private fun initView() {
        vpMedia = findViewById(R.id.vp_top_media_vp2)

        // 防止跟百度地图ID重复导致crash
        val childView = vpMedia.getChildAt(0)
        if (childView is RecyclerView) {
            childView.overScrollMode = OVER_SCROLL_NEVER
            childView.setId(R.id.zra_media_rv_vp_t)
        }

        vpMedia.adapter = (ZraTopMediaVPAdapter().also { adapter = it })

        vpMedia.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                pagePosition = position
//                var interactionType = dataMedia[position].interaction_type
//                refreshTab(interactionType)
//                refreshAlbumTab(interactionType, dataMedia[position].album_after?.index ?: 0)
//                textCarouselView.setCurrentType(interactionType)
            }
        })
    }


}