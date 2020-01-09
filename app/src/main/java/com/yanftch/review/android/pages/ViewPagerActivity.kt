package com.yanftch.review.android.pages

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.yanftch.review.R
import kotlinx.android.synthetic.main.activity_view_pager.*
import org.jetbrains.anko.UI
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * 实现无限轮播的 ViewPager
 *
 */
class ViewPagerActivity : AppCompatActivity() {
    private lateinit var viewList: ArrayList<View>
    private lateinit var adapter: com.yanftch.review.android.pages.ViewPagerActivity.MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        viewList = ArrayList()
        for (index in 1..3) {
            viewList.add(generateView(index))
        }

        // 手动在原始数据源的首尾进行添加
        viewList.add(0, generateView(3))
        viewList.add(viewList.size, generateView(1))

        adapter = com.yanftch.review.android.pages.ViewPagerActivity.MyAdapter(viewList)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (positionOffset == 0F) {
                    if (position == 0) {
                        view_pager.setCurrentItem(viewList.size - 2, false)
                    } else if (position == viewList.size - 1) {
                        view_pager.setCurrentItem(1, false )
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                Log.e(
                    "debug_ViewPagerActivity",
                    "onPageSelected: current selected page is: $position"
                )


            }
        })
    }

    private fun generateView(index: Int) = UI {
        verticalLayout {
            gravity = Gravity.CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            textView {
                text = "index $index"
                textSize = 50F
            }
        }
    }.view

    private class MyAdapter(var viewList: List<View>) : PagerAdapter() {

        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view = viewList[position]
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }

        override fun getCount() = viewList.size

    }
}
