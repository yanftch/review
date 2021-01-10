package com.yanftch.review.android.pages.tablayout_viewpager_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yanftch.review.R

class DiyTablayoutActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private lateinit var mAdapter: TabLayoutPagerAdapter
    private lateinit var mTabLayout: TabLayout

    private var mFragments: ArrayList<Fragment> = ArrayList()
    private var mTitles: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diy_tablayout)

        mViewPager = findViewById(R.id.view_pager)
        mViewPager.offscreenPageLimit = 1
        mTabLayout = findViewById(R.id.tab_layout)

        // 初始化标题和Fragment
        for (index in 0 until 3) {
            mTitles.add("标题$index")
        }
        mFragments.add(TabFragment1.getInstance("Fragment 1"))
        mFragments.add(TabFragment2.getInstance("Fragment 2"))
        mFragments.add(TabFragment3.getInstance("Fragment 3"))


        mAdapter = TabLayoutPagerAdapter(supportFragmentManager, mTitles, mFragments)

        for (index in 0 until mTitles.size) {
            val newTab = mTabLayout.newTab()
            val view = LayoutInflater.from(this).inflate(R.layout.tab_item, null, false)
            view.findViewById<TextView>(R.id.text_view).setText(mTitles[index])
            newTab.setCustomView(view)

            mTabLayout.addTab(newTab)
        }

        mViewPager.adapter = mAdapter
//        mTabLayout.setupWithViewPager(mViewPager)
        mViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mTabLayout.selectTab(mTabLayout.getTabAt(position))
            }
        })

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var customView = tab?.customView

                customView?.findViewById<TextView>(R.id.text_view)?.setTextColor(ContextCompat.getColor(this@DiyTablayoutActivity,R.color.black))

                customView?.findViewById<View>(R.id.v_shadow)?.setBackgroundColor(ContextCompat.getColor(this@DiyTablayoutActivity,R.color.transparent))
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var customView = tab?.customView
                customView?.findViewById<TextView>(R.id.text_view)?.setTextColor(ContextCompat.getColor(this@DiyTablayoutActivity,R.color.red))
                customView?.findViewById<View>(R.id.v_shadow)?.setBackgroundColor(ContextCompat.getColor(this@DiyTablayoutActivity,R.color.profile_text_red))
                mViewPager.setCurrentItem(tab?.position?:0, true)
            }

        })

    }
}