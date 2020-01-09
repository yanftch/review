package com.yanftch.review.android.pages

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.util.LruCache
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.disklrucache.DiskLruCache
import com.yanftch.review.R
import kotlinx.android.synthetic.main.activity_bitmap.*
import org.jetbrains.anko.sdk15.listeners.onClick

class BitmapActivity : AppCompatActivity() {

    private var lruCache: LruCache<Any, Any>? = null
    private var diskLruCache: DiskLruCache? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap)

        btn_load_image.setOnClickListener {
            val openRawResource = resources.openRawResource(R.raw.elephant)
            val bitmap = BitmapFactory.decodeStream(openRawResource)
            val byteCount = bitmap.byteCount
            var rowBytes = bitmap.rowBytes
            val width = bitmap.width
            val height = bitmap.height
            Log.e(
                "debug_BitmapActivity",
                "onCreate: byteCount=$byteCount      width=$width     height=$height"
            )

            iv_bitmap.setImageBitmap(bitmap)
        }

        btn_load_image_compress.onClick {
            val id = R.drawable.big_image
            val bitmap = decodeBitmap(resources, id, 200, 200)
            iv_bitmap.setImageBitmap(bitmap)

        }
    }
    // 对图片进行压缩处理

    fun decodeBitmap(resources: Resources, resId: Int, width: Int, height: Int): Bitmap {
        val bitmapOptions: BitmapFactory.Options = BitmapFactory.Options()
        bitmapOptions.inJustDecodeBounds = true // 设置只采样，不实际加载图片
        BitmapFactory.decodeResource(resources, resId, bitmapOptions) // 加载图片
        if (true) {
            val bitmap = BitmapFactory.decodeResource(resources, resId) // 加载图片
            Log.e(
                "debug_BitmapActivity",
                "decodeBitmap: 原图大小 bitmap.byteCount=${bitmap.byteCount}  bitmap.width=${bitmap.width}    bitmap.height=${bitmap.height}"
            )
        }

        // 计算采样率
        bitmapOptions.inSampleSize = calculateSimpleSize(bitmapOptions, width, height)
        bitmapOptions.inJustDecodeBounds = false
        val newBitmap = BitmapFactory.decodeResource(resources, resId, bitmapOptions)
        Log.e(
            "debug_BitmapActivity",
            "decodeBitmap: 压缩后的图片大小 bitmap.byteCount=${newBitmap.byteCount}  bitmap.width=${newBitmap.width}    bitmap.height=${newBitmap.height}   采样率=${bitmapOptions.inSampleSize}"

        )
        return newBitmap
    }

    // 计算采样率
    private fun calculateSimpleSize(
        bitmapOptions: BitmapFactory.Options,
        width: Int,
        height: Int
    ): Int {
        // 获取图片的实际宽高
        val outWidth = bitmapOptions.outWidth
        val outHeight = bitmapOptions.outHeight
        Log.e(
            "debug_BitmapActivity",
            "calculateSimpleSize: real width=$outWidth    real height=$outHeight"
        )

        // 采样率默认设置为 1，也就是不压缩
        var inSampleSize = 1
        // 实际宽高任意一个大于需要的宽高，即进行压缩采样处理
        if (outWidth > width || outHeight > height) {
            val halfHeight = outHeight / 2
            val halfWidth = outWidth / 2
            while (halfHeight / inSampleSize >= height && halfWidth / inSampleSize >= width) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

}
