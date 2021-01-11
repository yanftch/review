package com.yanftch.review.android.fragment.new_home.model;

import java.util.List;

public class ZraMainPageBaseModel {
    // 金刚位
    private List<ZraEntryBean> entry;
    // banner
    private List<ZraEntryBean> banner;

    // 特价房
    private SpecialPriceHouseBean speicalPriceHouse;



    // ============================
    // ============================
    // ============================


    public SpecialPriceHouseBean getSpeicalPriceHouse() {
        return speicalPriceHouse;
    }

    public void setSpeicalPriceHouse(SpecialPriceHouseBean speicalPriceHouse) {
        this.speicalPriceHouse = speicalPriceHouse;
    }

    public List<ZraEntryBean> getBanner() {
        return banner;
    }

    public void setBanner(List<ZraEntryBean> banner) {
        this.banner = banner;
    }

    public List<ZraEntryBean> getEntry() {
        return entry;
    }

    public void setEntry(List<ZraEntryBean> entry) {
        this.entry = entry;
    }
}
