package com.yanftch.review.android.fragment.new_home;

import android.content.Context;

import com.google.gson.Gson;
import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;
import com.yanftch.review.android.fragment.new_home.model.ZraMainMarketBean;
import com.yanftch.review.android.fragment.new_home.model.ZraMainPageBaseModel;
import com.yanftch.review.android.fragment.new_home.model.ZraMarketModel;

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
//        SpecialPriceHouseBean specialPriceHouseBean = gson.fromJson(specialPriceBean, SpecialPriceHouseBean.class);

        // 营销区域  瓷片区
        List<ZraMarketModel> zraMarketModelList = new ArrayList<>();
        ZraMarketModel model1 = new ZraMarketModel();
        model1.setType("1");
        List<ZraMainMarketBean> l1 = new ArrayList<>();
        ZraMainMarketBean bean1 = new ZraMainMarketBean();
        bean1.setTitle("预订优惠");
        bean1.setSubTitle("早订优惠哈");
        bean1.setImg("https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg");
        l1.add(bean1);
        model1.setList(l1);
        zraMarketModelList.add(model1);

        ZraMarketModel model2 = new ZraMarketModel();
        model2.setType("2");
        List<ZraMainMarketBean> l2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ZraMainMarketBean bean2 = new ZraMainMarketBean();
            bean2.setTitle("预订优惠"+i);
            bean2.setSubTitle("早订优惠哈"+i);
            bean2.setImg("https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg");
            l2.add(bean2);
        }
        model2.setList(l2);
        zraMarketModelList.add(model2);

        // 多媒体

        // 封装
//        baseModel.setTransformersList(entryBeanList);
//        baseModel.setHeadBanner(bannerList);
//        baseModel.setSpeicalPriceHouse(specialPriceHouseBean);
//        baseModel.setMarketingList(zraMarketModelList);

        baseModel = gson.fromJson(fromJson, ZraMainPageBaseModel.class);

        // TODO:yanfeng 2021/1/8 外层，需要判断 baseMode 是否为空

        if (getView() != null && getView().isActive()) {
            // 渲染 金刚位
            getView().renderEntry(baseModel.getTransformersList());

            // 渲染 banner
            getView().renderBanner(baseModel.getHeadBanner());

            // 渲染 特价房
            getView().renderSpecialHouseInfo(baseModel.getSpeicalPriceHouse());

            // 营销区域  瓷片区
            getView().renderMarketing(baseModel.getMarketingList());

            // 多媒体找房模块
            getView().renderMediaInfo(baseModel.getMediaList());

            // tab 标题
            getView().renderRecTitle(baseModel.getTab());


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

    private String fromJson = "{\n" +
            "    \"headBanner\": [\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/687cedc4-65fc-45a8-ba20-5b3d1b02b14f.jpeg\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/687cedc4-65fc-45a8-ba20-5b3d1b02b14f.jpeg\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"transformersList\": [\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"title\": \"合租\",\n" +
            "            \"icon\": \"https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png\",\n" +
            "            \"iconSvga\": \"https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"title\": \"合租\",\n" +
            "            \"icon\": \"https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png\",\n" +
            "            \"iconSvga\": \"https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"title\": \"合租\",\n" +
            "            \"icon\": \"https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png\",\n" +
            "            \"iconSvga\": \"https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"title\": \"合租\",\n" +
            "            \"icon\": \"https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png\",\n" +
            "            \"iconSvga\": \"https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"img\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "            \"target\": \"af\",\n" +
            "            \"title\": \"合租\",\n" +
            "            \"icon\": \"https://webimg.ziroom.com/e7f6a98e-a276-4abb-ba58-7e59591acde2.png\",\n" +
            "            \"iconSvga\": \"https://file.ziroom.com/g4m3/M00/26/4B/ChAZE18g8YGATHkWAAAH-dLbNOE78.svga\",\n" +
            "            \"parameter\": \"asdfaa\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"speicalPriceHouse\": {\n" +
            "        \"actBaseImg\": \"https://webimg.ziroom.com/687cedc4-65fc-45a8-ba20-5b3d1b02b14f.jpeg\",\n" +
            "        \"surplusTime\": 1000,\n" +
            "        \"endTime\": \"2021-01-01 00:00:00\",\n" +
            "        \"title\": \"秒杀特惠专区\",\n" +
            "        \"titleImage\": \"https://webimg.ziroom.com/92aa86c8-98d5-4566-9182-757673dba574.png\",\n" +
            "        \"speicalPriceHouseVos\": [\n" +
            "            {\n" +
            "                \"area\": \"28.5㎡\",\n" +
            "                \"amount\": \"¥1200\",\n" +
            "                \"amountTxt\": \"最高立减\",\n" +
            "                \"businessCircle\": \"大山子\",\n" +
            "                \"houseTypeName\": \"一居简影\",\n" +
            "                \"houseTypePic\": \"https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg\",\n" +
            "                \"buyTxt\": \"立即抢购\",\n" +
            "                \"projectFid\": \"16\",\n" +
            "                \"projectName\": \"将府全智能自如寓\",\n" +
            "                \"type\": 2,\n" +
            "                \"houseTypeFid\": \"0000000048e4565b0148e459acd40002\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"area\": \"28.5㎡\",\n" +
            "                \"amount\": \"¥1200\",\n" +
            "                \"amountTxt\": \"最高立减\",\n" +
            "                \"businessCircle\": \"大山子\",\n" +
            "                \"houseTypeName\": \"一居简影\",\n" +
            "                \"houseTypePic\": \"https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg\",\n" +
            "                \"buyTxt\": \"立即抢购\",\n" +
            "                \"projectFid\": \"16\",\n" +
            "                \"projectName\": \"将府全智能自如寓\",\n" +
            "                \"type\": 2,\n" +
            "                \"houseTypeFid\": \"0000000048e4565b0148e459acd40002\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"area\": \"28.5㎡\",\n" +
            "                \"amount\": \"¥1200\",\n" +
            "                \"amountTxt\": \"最高立减\",\n" +
            "                \"businessCircle\": \"大山子\",\n" +
            "                \"houseTypeName\": \"一居简影\",\n" +
            "                \"houseTypePic\": \"https://image.ziroom.com/g2m3/M00/40/F7/ChAZVF8fsJaATBKeACsxgUDmIT4076.jpg\",\n" +
            "                \"buyTxt\": \"立即抢购\",\n" +
            "                \"projectFid\": \"16\",\n" +
            "                \"projectName\": \"将府全智能自如寓\",\n" +
            "                \"type\": 2,\n" +
            "                \"houseTypeFid\": \"0000000048e4565b0148e459acd40002\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"marketingList\": [\n" +
            "        {\n" +
            "            \"type\": \"1\",\n" +
            "            \"list\": [\n" +
            "                {\n" +
            "                    \"title\": \"预订优惠\",\n" +
            "                    \"subTitle\": \"早定早优惠~\",\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg\",\n" +
            "                    \"buttonStatus\": \"1\",\n" +
            "                    \"buttonTitle\": \"领取\",\n" +
            "                    \"target\": \"\",\n" +
            "                    \"parameter\": \"\",\n" +
            "                    \"projectId\": \"项目id\",\n" +
            "                    \"houseTypeId\": \"房型id\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"2\",\n" +
            "            \"list\": [\n" +
            "                {\n" +
            "                    \"title\": \"右边左\",\n" +
            "                    \"subTitle\": \"早定早优惠~\",\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg\",\n" +
            "                    \"buttonStatus\": \"1\",\n" +
            "                    \"buttonTitle\": \"领取\",\n" +
            "                    \"target\": \"\",\n" +
            "                    \"parameter\": \"\",\n" +
            "                    \"projectId\": \"项目id\",\n" +
            "                    \"houseTypeId\": \"房型id\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"title\": \"右边右\",\n" +
            "                    \"subTitle\": \"早定早优惠~\",\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg\",\n" +
            "                    \"buttonStatus\": \"1\",\n" +
            "                    \"buttonTitle\": \"领取\",\n" +
            "                    \"target\": \"\",\n" +
            "                    \"parameter\": \"\",\n" +
            "                    \"projectId\": \"项目id\",\n" +
            "                    \"houseTypeId\": \"房型id\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"mediaList\": [\n" +
            "        {\n" +
            "            \"title\": \"直播找房\",\n" +
            "            \"type\": \"1\",\n" +
            "            \"target\": \"123\",\n" +
            "            \"list\": [\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2cef7579-f9f3-4281-8c0d-6fd53f979df9.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 1,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"视频找房\",\n" +
            "            \"type\": \"2\",\n" +
            "            \"target\": \"123\",\n" +
            "            \"list\": [\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"img\": \"https://webimg.ziroom.com/2f9042d4-c9dd-4627-bb48-d77da4a99282.jpg\",\n" +
            "                    \"cityCode\": \"110000\",\n" +
            "                    \"description\": \"http://m.ziroomapartment.com/zry_m/meetaDetail.html?projectId=16\",\n" +
            "                    \"title\": \"探索全智能公寓的正确打开方式\",\n" +
            "                    \"liveStartTime\": 1610443800000,\n" +
            "                    \"tiktokUrl\": \"https://v.douyin.com/pQ5S8W/\",\n" +
            "                    \"bizCircle\": \"大山子\",\n" +
            "                    \"liveEndTime\": 1610445600000,\n" +
            "                    \"parameter\": {\n" +
            "                        \"projectId\": \"16\"\n" +
            "                    },\n" +
            "                    \"projectAddr\": \"北京朝阳区\",\n" +
            "                    \"liveTime\": \"2021-1-12 17:30-18:00\",\n" +
            "                    \"liveMessage\": \"现在可以直播看房啦,看直播还可以领优惠券哦,快去关注直播吧\",\n" +
            "                    \"liveStatus\": 0,\n" +
            "                    \"liveZoName\": \"旭东\",\n" +
            "                    \"target\": \"ziroomCustomer://zrRentModule/zraDetailspage\",\n" +
            "                    \"labelVoList\": [\n" +
            "                        {\n" +
            "                            \"title\": \"全面消毒\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"封闭管理\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"title\": \"安心入住\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"liveZoCode\": \"60012527\",\n" +
            "                    \"favourMsg\": \"\",\n" +
            "                    \"liveShowTime\": \"1.12 17:30-18:00\",\n" +
            "                    \"liveTiktokAccount\": \"3579613665562510\",\n" +
            "                    \"projectFid\": \"16\",\n" +
            "                    \"projectName\": \"将府全智能自如寓\",\n" +
            "                    \"projectId\": \"16\",\n" +
            "                    \"projectImg\": \"https://image.ziroom.com/g2m3/M00/B6/9C/ChAZVF9Pex-ANMNBAAfD51Z6FwU104.jpg\",\n" +
            "                    \"status\": 0\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"tab\": [\n" +
            "        {\n" +
            "            \"title\": \"猜你喜欢\",\n" +
            "            \"type\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"项目列表\",\n" +
            "            \"type\": \"2\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
