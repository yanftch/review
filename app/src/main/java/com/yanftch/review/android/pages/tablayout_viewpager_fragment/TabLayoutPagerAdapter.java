package com.yanftch.review.android.pages.tablayout_viewpager_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabLayoutPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    public TabLayoutPagerAdapter(@NonNull FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
//        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        super(fm);
        mTitleList = titleList;
        mFragmentList = fragmentList;
    }

    public TabLayoutPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0 ){
            return TabFragment1.getInstance("new fragment 1");
        } else if (position ==1 ){
            return TabFragment2.getInstance("new fragment 2");
        } else return TabFragment3.getInstance("new fragment 3");
//        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
