package com.yanftch.review.android.fragment.new_home.model;

import java.util.List;

public class ZraMainPageBaseModel {
    // 金刚位
    private List<ZraEntryBean> transformersList;
    // banner
    private List<ZraEntryBean> headBanner;

    // 特价房
    private SpecialPriceHouseBean speicalPriceHouse;

    // 营销区域  瓷片区
    private List<ZraMarketModel> marketingList;

    // tab 标题
    private List<TabBean> tab;

    private List<ZraMainPageLiveBean> mediaList;


    // ============================
    // ============================
    // ============================


    public List<ZraMainPageLiveBean> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<ZraMainPageLiveBean> mediaList) {
        this.mediaList = mediaList;
    }

    public List<TabBean> getTab() {
        return tab;
    }

    public void setTab(List<TabBean> tab) {
        this.tab = tab;
    }

    public List<ZraMarketModel> getMarketingList() {
        return marketingList;
    }

    public void setMarketingList(List<ZraMarketModel> marketingList) {
        this.marketingList = marketingList;
    }

    public SpecialPriceHouseBean getSpeicalPriceHouse() {
        return speicalPriceHouse;
    }

    public void setSpeicalPriceHouse(SpecialPriceHouseBean speicalPriceHouse) {
        this.speicalPriceHouse = speicalPriceHouse;
    }

    public List<ZraEntryBean> getTransformersList() {
        return transformersList;
    }

    public void setTransformersList(List<ZraEntryBean> transformersList) {
        this.transformersList = transformersList;
    }

    public List<ZraEntryBean> getHeadBanner() {
        return headBanner;
    }

    public void setHeadBanner(List<ZraEntryBean> headBanner) {
        this.headBanner = headBanner;
    }
}
