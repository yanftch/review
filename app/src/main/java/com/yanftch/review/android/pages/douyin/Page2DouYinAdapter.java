package com.yanftch.review.android.pages.douyin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yanftch.review.android.modules.RowsBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Page2DouYinAdapter extends FragmentStateAdapter {


    private List<RowsBean> mList;

    public Page2DouYinAdapter(@NonNull FragmentActivity fragmentActivity, @NotNull List<RowsBean> list) {
        super(fragmentActivity);
        mList = list;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(position, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}