package com.yanftch.review.android.fragment.new_home;

import android.content.Context;

import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;
import com.yanftch.review.android.fragment.new_home.model.ZraMainPageBaseModel;

import java.util.ArrayList;
import java.util.List;

public class ZraMainViewTopPresenter implements ZraMainFragmentContract.Top.Presenter {
    private Context mContext;
    private ZraMainFragmentContract.Top.View mView;

    public ZraMainViewTopPresenter(Context context, ZraMainFragmentContract.Top.View view) {
        mContext = context;
        mView = view;
    }

    /**
     * start 方法，默认用来调用头部部分两个
     */
    @Override
    public void start() {
        getHeaderData();
    }

    @Override
    public void getHeaderData() {
        // TODO:yanfeng 2021/1/8 此处是请求的头部接口，获取所有数据(除了瓷片营销区域的数据)
        ZraMainPageBaseModel baseModel = new ZraMainPageBaseModel();

        List<ZraEntryBean> entryBeanList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ZraEntryBean entryBean = new ZraEntryBean();
            entryBean.setTitle("合租" + i);
            entryBean.setImg("https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png");
            entryBean.setIcon("https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png");
            entryBean.setIconSvga("https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga");
            entryBeanList.add(entryBean);
        }

        // 封装
        baseModel.setEntry(entryBeanList);

        // TODO:yanfeng 2021/1/8 外层，需要判断 baseMode 是否为空

        if (getView() != null && getView().isActive()) {
            getView().renderEntry(baseModel.getEntry());
        }

    }

    @Override
    public void getCouponInfo() {

    }


    @Override
    public ZraMainFragmentContract.Top.View getView() {
        return mView;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
