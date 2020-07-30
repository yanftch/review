package com.yanftch.review.android.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.yanftch.review.R

class ViewPager2Activity : AppCompatActivity() {

    private lateinit var mViewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        mViewPager2 = findViewById(R.id.view_pager2)

    }

//    class ViewPager2Adapter(): RecyclerView.Adapter() {
//
//    }
}
