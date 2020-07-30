package com.yanftch.review.android.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.load.data.ExifOrientationStream
import com.yanftch.review.R
import com.yanftch.review.android.utils.AddTagUtils
import com.yanftch.review.android.view.ExpandableLinearLayout

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var mLlTags: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout2)
        mLlTags = findViewById(R.id.ll_tags)

        addTag()
        findViewById<TextView>(R.id.tv_more).setOnClickListener {
            Log.e("debug_ConstraintLayoutActivity:", "onCreate==>  ${getBooleamTest()}")
        }

        AddTagUtils.addTag(this, mLlTags, "title", R.color.black_900, R.drawable.bg_shape_outer_24, 18f,12f,6f,6f,10f, onClick = {

            null
        })
        AddTagUtils.addTag2(this, mLlTags, "title", R.color.black_900, R.drawable.bg_shape_outer_24, 18f,12f,6f,6f,10f, onClick = {

            null
        })
    }
    private var mIsBoolean = true

    fun getBooleamTest(): Boolean {
        return mIsBoolean || getB2()
    }

    fun getB1():Boolean {
        return "1".equals("1")
    }
    fun getB2():Boolean {
        return "2".equals("21")
    }


    fun addTag() {
        var tvMore = findViewById<TextView>(R.id.tv_more)

        var expandTags = findViewById<ExpandableLinearLayout>(R.id.expand_ll_tags)


        var list = mutableListOf<String>()

        for (index in 0..5) {
            list.add("标签 $index")
        }
        expandTags.removeAllViews()

        list.forEachIndexed { _, s ->
            val textView = TextView(this)
            var view = LayoutInflater.from(this).inflate(R.layout.rv_item, null)
            view.findViewById<TextView>(R.id.text_view).text = s
            textView.text = s

//            llTags.addView(textView)
            expandTags.addItem(view)
        }

        if (list.size > 3) {
            tvMore.visibility = View.VISIBLE
        }

    }
}