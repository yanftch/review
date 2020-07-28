package com.yanftch.review.android.pages.tablayout_viewpager_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.yanftch.review.R

class SwitchFragmentActivity : AppCompatActivity() {

    private lateinit var mTabLayout: TabLayout
    private lateinit var mFrameLayout: FrameLayout


    private var mCurrentFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_fragment)

        mTabLayout.addTab(TabLayout.Tab().setText("tab1"))
        mTabLayout.addTab(TabLayout.Tab().setText("tab2"))
        mTabLayout.addTab(TabLayout.Tab().setText("tab3"))

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
        })
    }

    // 切换Fragment
    private fun switchFragment(targetFragment: Fragment): FragmentTransaction {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (!targetFragment.isAdded) {
            if (mCurrentFragment != null) {
                fragmentTransaction.hide(mCurrentFragment!!)
            }
            fragmentTransaction.add(
                R.id.frame_layout,
                targetFragment,
                targetFragment.javaClass.name
            )
        } else {
            mCurrentFragment?.let { fragmentTransaction.hide(it).show(targetFragment) }
        }
        mCurrentFragment = targetFragment
        return fragmentTransaction
    }
}
