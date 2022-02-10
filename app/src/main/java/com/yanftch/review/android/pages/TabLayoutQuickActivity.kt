package com.yanftch.review.android.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yanftch.review.R
import com.yanftch.review.android.view.TextViewLine
import org.jetbrains.anko.find

class TabLayoutQuickActivity : AppCompatActivity() {
    private val TAG = "debug_TabLayoutQuickActivity"
    private lateinit var tvLine: TextViewLine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_quick)
        tvLine = find(R.id.tv_line_view)
        tvLine.setText("飞机上公交IG我阿基及时跟进")
        tvLine.post {
            var measuredWidth = tvLine.measuredWidth
            Log.e(TAG, "onCreate: "+measuredWidth )
        }



    }
}