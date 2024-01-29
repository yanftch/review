package com.yanftch.review.android.pages.vp2

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.opensource.svgaplayer.SVGAImageView
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity
import com.yanftch.review.MyApp
import com.yanftch.review.R
import com.yanftch.review.android.modules.HouseListItem
import com.yanftch.review.android.utils.DensityUtil
import com.yanftch.review.android.utils.dp
import com.yanftch.review.android.utils.gone
import com.yanftch.review.android.utils.visible
import com.yanftch.review.android.view.FlowLayoutLimitLine
import com.yanftch.review.ziroom.ui.PictureView
import kotlinx.android.synthetic.main.sojourn_item_maqueen.view.*

class FindZraPopAdapter(context: Context, dataList: List<HouseListItem>) :
    RecyclerView.Adapter<FindZraPopAdapter.PopViewHolder>() {
    private var list = arrayListOf<HouseListItem>()
    private var ctx: Context

    init {
        ctx = context
        this.list.clear()
        this.list.addAll(dataList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.z_find_zra_mappop_itemview, parent, false)
        return PopViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PopViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        private var dp8 = DensityUtil.dip2px(MyApp.instance, 8f).toFloat()

        private var clImageContainer: ConstraintLayout = rootView.findViewById(R.id.cl_img_collection)
        private var tvProjectName: TextView = rootView.findViewById(R.id.tv_map_pro_name)
        private var tvPrice: TextView = rootView.findViewById(R.id.tv_map_price)
        private var tvLinePrice: TextView = rootView.findViewById(R.id.tv_map_line_price)
        private var tvPriceUnit: TextView = rootView.findViewById(R.id.tv_map_price_unit)
        private var llCollectContainer: LinearLayout = rootView.findViewById(R.id.ll_map_collect)
        private var ivCollectStatus: ImageView = rootView.findViewById(R.id.iv_map_collect)
        private var tvCollectNum: TextView = rootView.findViewById(R.id.tv_map_collect_num)
        private var flTags: FlowLayoutLimitLine = rootView.findViewById(R.id.fl_map_tags)
        private var tvSubwayStationInfo: TextView =
            rootView.findViewById(R.id.tv_map_subway_station)
        private var ivSubway: ImageView = rootView.findViewById(R.id.iv_map_subway_station_img)
        private var pvCommuteImage: PictureView = rootView.findViewById(R.id.pv_map_commute_img)
        private var tvCommuteContent: TextView = rootView.findViewById(R.id.tv_map_commute_info)
        private var pvMainImage: PictureView = rootView.findViewById(R.id.pv_map_main_img)
        private var pvImage2: PictureView = rootView.findViewById(R.id.pv_map_image2)
        private var pvImage3: PictureView = rootView.findViewById(R.id.pv_map_image3)

        init {
        }

        fun render(item: HouseListItem?) {
            val projectInfo = item?.zra_aggs?.project_info

            projectInfo?.let {
                // 图片（单图+3图模式）
                if (it.focus_pic_list.isNullOrEmpty()) {

                } else {
                    when (it.focus_pic_list.size) {
                        1 -> {
                            pvMainImage.visible()
                            pvImage2.gone()
                            pvImage3.gone()
                            pvMainImage.setImageUri(it.focus_pic_list[0]).display()
                            val constrainSet = ConstraintSet()
                            constrainSet.clone(clImageContainer)
                            constrainSet.setDimensionRatio(R.id.pv_map_main_img, "h,154:311")
                            constrainSet.applyTo(clImageContainer)
                        }
                        2 -> {

                        }
                        3 -> {
                            pvImage2.visible()
                            pvImage3.visible()
                            pvMainImage.visible()
                            pvMainImage.setImageUri(it.focus_pic_list[0]).display()
                            pvImage2.setImageUri(it.focus_pic_list[1]).display()
                            pvImage3.setImageUri(it.focus_pic_list[2]).display()
                        }
                    }
                }

                // 项目名称
                tvProjectName.text = "${it.project_name ?: ""}"
                // 价格处理
                try {
                    val typeFace = Typeface.createFromAsset(ctx.assets, "fonts/d_din_bold.ttf")
                    tvPrice.typeface = typeFace
                    tvLinePrice.typeface = typeFace
                } catch (e: java.lang.Exception) {
                }
                tvPrice.text = it.min_price
                if (it.min_original_price.isNullOrEmpty()) {
                    tvLinePrice.gone()
                } else {
                    tvLinePrice.visible()
                    tvLinePrice.paintFlags = tvLinePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    tvLinePrice.text = it.min_original_price
                }
                tvPriceUnit.text = it.price_unit

                // 收藏

                // 标签
                flTags.setLimitLine(1)
                if (it.project_tags.isNullOrEmpty()) {
                    flTags.gone()
                } else {
                    flTags.visible()
                    flTags.removeAllViews()
                    it.project_tags.forEachIndexed { _, zraTagStyle ->
                        flTags.addView(getZraTag(zraTagStyle))
                    }
                }

                // 地址信息
                if (it.subway_station_info.isNullOrEmpty()) {
                    tvSubwayStationInfo.gone()
                    ivSubway.gone()
                } else {
                    ivSubway.visible()
                    tvSubwayStationInfo.visible()
                    tvSubwayStationInfo.text = it.subway_station_info
                }

                // 通勤信息
                if (it.commute_info.isNullOrEmpty()) {
                    tvCommuteContent.gone()
                    pvCommuteImage.gone()
                } else {
                    tvCommuteContent.visible()
                    pvCommuteImage.visible()
                    tvCommuteContent.text = it.commute_info
                    pvCommuteImage.setImageUri(it.commute_icon).display()
                }

                // 点击事件
                itemView.setOnClickListener {
                    Toast.makeText(ctx, "进入项目页" + projectInfo.project_id, Toast.LENGTH_SHORT).show()
                }

                // 埋点

            }
        }


        private fun getZraTag(tagBean: HouseListItem.ZraTagStyle?): View? {
            if (tagBean == null) return View(ctx)
            var tvColor = ContextCompat.getColor(ctx, R.color.color_ct1_85)
            if (!tagBean.color.isNullOrEmpty()) {
                try {
                    tvColor = Color.parseColor(tagBean.color)
                } catch (e: Exception) {
                    tvColor = ContextCompat.getColor(ctx, R.color.color_ct1_85)
                    e.printStackTrace()
                }
            } else {
                tvColor = ContextCompat.getColor(ctx, R.color.color_ct1_85)
            }

            val gradientDrawable = GradientDrawable()
            gradientDrawable.shape = GradientDrawable.RECTANGLE
            gradientDrawable.cornerRadius = 2f.dp

            if (!tagBean.background.isNullOrEmpty()) {
                try {
                    gradientDrawable.setColor(Color.parseColor(tagBean.background))
                } catch (e: java.lang.Exception) {
                    gradientDrawable.setColor(ContextCompat.getColor(ctx, R.color.color_c1_3))
                    e.printStackTrace()
                }
            } else {
                gradientDrawable.setColor(ContextCompat.getColor(ctx, R.color.color_c1_3))
            }

            val textView = TextView(ctx)
            textView.text = tagBean.title
            textView.setTextColor(tvColor)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
            textView.includeFontPadding = false
            textView.gravity = Gravity.CENTER
            textView.setPadding(5.dp, 2.dp, 5.dp, 2.dp)

            textView.background = gradientDrawable
            val layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 0, 6.dp, 0)
            textView.layoutParams = layoutParams
            return textView
        }

    }
}