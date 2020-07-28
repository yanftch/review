package com.yanftch.review.android.pages.tablayout_viewpager_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yanftch.review.R

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private lateinit var mAdapter: TabLayoutPagerAdapter
    private lateinit var mTabLayout: TabLayout

    private var mFragments: ArrayList<Fragment> = ArrayList()
    private var mTitles: ArrayList<String> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        mViewPager = findViewById(R.id.view_pager)
        mViewPager.offscreenPageLimit = 1
        mTabLayout = findViewById(R.id.tab_layout)

        // 初始化标题和Fragment
        for ( index in 0..3) {
            mTitles.add("标题$index")
        }
        mFragments.add(TabFragment1.getInstance("Fragment 1"))
        mFragments.add(TabFragment2.getInstance("Fragment 2"))
        mFragments.add(TabFragment3.getInstance("Fragment 3"))


        mAdapter = TabLayoutPagerAdapter(supportFragmentManager, mTitles, mFragments)

        mViewPager.adapter = mAdapter
        mTabLayout.setupWithViewPager(mViewPager)

        mTabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

        })

    }
}
