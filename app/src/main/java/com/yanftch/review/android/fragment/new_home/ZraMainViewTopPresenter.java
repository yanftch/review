package com.yanftch.review.android.fragment.new_home;

import android.content.Context;

import com.google.gson.Gson;
import com.yanftch.review.android.fragment.new_home.model.SpecialPriceHouseBean;
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
        // 金刚位
        for (int i = 0; i < 5; i++) {
            ZraEntryBean entryBean = new ZraEntryBean();
            entryBean.setTitle("合租" + i);
            entryBean.setImg("https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png");
            entryBean.setIcon("https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png");
            entryBean.setIconSvga("https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga");
            entryBeanList.add(entryBean);
        }

        // banner
        List<ZraEntryBean> bannerList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ZraEntryBean entryBean = new ZraEntryBean();
            entryBean.setTitle("合租" + i);
            entryBean.setImg("https://webimg.ziroom.com/687cedc4-65fc-45a8-ba20-5b3d1b02b14f.jpeg");
            entryBean.setIcon("https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png");
            entryBean.setIconSvga("https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga");
            bannerList.add(entryBean);
        }

        // 特价房
        Gson gson = new Gson();
        SpecialPriceHouseBean specialPriceHouseBean = gson.fromJson(specialPriceBean, SpecialPriceHouseBean.class);

        // 封装
        baseModel.setEntry(entryBeanList);
        baseModel.setBanner(bannerList);
        baseModel.setSpeicalPriceHouse(specialPriceHouseBean);


        // TODO:yanfeng 2021/1/8 外层，需要判断 baseMode 是否为空

        if (getView() != null && getView().isActive()) {
            // 渲染 金刚位
            getView().renderEntry(baseModel.getEntry());

            // 渲染 banner
            getView().renderBanner(baseModel.getBanner());

            // 渲染 特价房
            getView().renderSpecialHouseInfo(baseModel.getSpeicalPriceHouse());
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

    private String specialPriceBean = "{\n" +
            "            \"actBaseImg\":\"https://webimg.ziroom.com/687cedc4-65fc-45a8-ba20-5b3d1b02b14f.jpeg\",\n" +
            "            \"surplusTime\":1000,\n" +
            "            \"endTime\":\"2021-01-01 00:00:00\",\n" +
            "            \"title\":\"秒杀特惠专区\",\n" +
            "            \"titleImage\":\"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"speicalPriceHouseVos\":[\n" +
            "               \n" +
            "              \n" +
            "                {\n" +
            "                    \"area\":\"28.5㎡\",\n" +
            "                    \"amount\":\"¥1200\",\n" +
            "                    \"amountTxt\":\"最高立减\",\n" +
            "                    \"businessCircle\":\"大山子\",\n" +
            "                    \"houseTypeName\":\"一居简影\",\n" +
            "                    \"houseTypePic\":\"https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg\",\n" +
            "                    \"buyTxt\":\"立即抢购\",\n" +
            "                    \"projectFid\":\"16\",\n" +
            "                    \"projectName\":\"将府全智能自如寓\",\n" +
            "                    \"type\":2,\n" +
            "                    \"houseTypeFid\":\"0000000048e4565b0148e459acd40002\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }" ;
}
