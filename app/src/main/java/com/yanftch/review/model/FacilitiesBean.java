package com.yanftch.review.model;

/**
 * Created by Wangm on 2019/5/29.
 */
public class FacilitiesBean {
    public String facilitiesName;// (string, optional): 设施名称 ,
    public String iconUrl;// (string, optional): 图片地址
    public String facilitiesTypeCode;// (string, optional): code

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getFacilitiesTypeCode() {
        return facilitiesTypeCode;
    }

    public void setFacilitiesTypeCode(String facilitiesTypeCode) {
        this.facilitiesTypeCode = facilitiesTypeCode;
    }

    @Override
    public String toString() {
        return "{" +
                "facilitiesName='" + facilitiesName + '\'' +
                '}';
    }
}
