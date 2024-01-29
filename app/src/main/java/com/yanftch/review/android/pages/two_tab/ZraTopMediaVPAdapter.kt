package com.yanftch.review.android.pages.two_tab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.yanftch.review.R

/**
 * 多媒体模块VP2 adapter
 */
class ZraTopMediaVPAdapter : RecyclerView.Adapter<ZraTopMediaVPAdapter.BaseViewHolder>() {
    private var context: Context? = null
    private var data: ArrayList<Media> = ArrayList() // 整合数据，相册中的每一项都整合为一个media


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        return when (viewType) {
            TYPE_ALBUM -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.zra_item_top_media_album_view, parent, false)
                NormalViewHolder(itemView)
            }
            TYPE_VIDEOQJ -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.zra_item_top_media_album_view, parent, false)
                NormalViewHolder(itemView)
            }
            TYPE_VR -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.zra_item_top_media_album_view, parent, false)
                NormalViewHolder(itemView)
            }

            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.zra_item_top_media_album_view, parent, false)
                NormalViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is NormalViewHolder -> {
                bindNormalHolder(holder, position)
            }
//            is VRViewHolder -> {
//                //vr陀螺仪效果
//                bindVrHolder(holder, position)
//            }
//            is PinTuViewHolder -> {
//                //拼图类型
//                bindPinTuHolder(holder, position)
//            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].interaction_type
    }

    fun setData(transformData: ArrayList<Media>) {
        data = transformData
        notifyDataSetChanged()
    }

    // TODO:yanfeng 2022/8/17 重启播放
    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        super.onViewAttachedToWindow(holder)
//        if(holder is VRViewHolder){
//            holder.slVr.start()
//            holder.svgaImage.startAnimation()
//        }
    }
    // TODO:yanfeng 2022/8/17 暂停操作，释放资源
    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
//        if(holder is VRViewHolder){
//            holder.slVr.stop()
//            holder.svgaImage.stopAnimation()
//        }
    }


    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //一张图片+中间logo的类型
    class NormalViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val pvMedia: SimpleDraweeView = itemView.findViewById(R.id.pv_media)
        val ivVideo: ImageView = itemView.findViewById(R.id.iv_video)
    }

    private fun bindNormalHolder(holder: NormalViewHolder, position: Int) {
        data[position].let {
            holder.ivVideo.visibility = View.GONE
            val layoutParams = holder.pvMedia.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.dimensionRatio = "3:4"

            when (it.interaction_type) {
                TYPE_VIDEO -> {
                    //视频
                    holder.ivVideo.visibility = View.VISIBLE
                    holder.pvMedia.setImageURI(it.video?.cover)
                    holder.pvMedia.setOnClickListener { _ ->
                        it.video?.apply {
                            onMediaClickListener?.onVideoClick(position, this)
                        }
                    }
                }
                TYPE_HX -> {
                    //户型图
                    holder.pvMedia.setImageURI(it.hx_photo?.photo)
                    holder.pvMedia.setOnClickListener {
                        onMediaClickListener?.onHxPhotoClick()
                    }
                    if (it.hx_photo?.photo_type == 0) {
                        layoutParams.dimensionRatio = "4:3"
                    }
                }
                else -> {

                }
            }
            holder.pvMedia.layoutParams = layoutParams
        }
    }

    private var onMediaClickListener: OnMediaClickListener? = null

    fun setOnMediaClickListener(onMediaClickListener: OnMediaClickListener){
        this.onMediaClickListener = onMediaClickListener
    }
}

interface OnMediaClickListener{
    fun onPhotoClick(index: Int)//点击图片，跳转图集页
    fun onVrClick(index: Int, vr: Media.Vr){} //跳转VR，view内部实现
    fun onVideoClick(index: Int, video: Media.Video){}//普通视频，view内部实现
    fun onHxPhotoClick(index: Int = 0)
    fun onQjVideoClick(index: Int, videoQj: Media.Video){}//全景视频
}