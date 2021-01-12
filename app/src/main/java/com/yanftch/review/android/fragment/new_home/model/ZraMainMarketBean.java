package com.yanftch.review.android.fragment.new_home.model;

public class ZraMainMarketBean extends ZraEntryBean {
    private String subTitle;
    private String buttonStatus; // 1 = 去领取   2 = 去使用
    private String buttonTitle;
    private String projectId;
    private String houseTypeId;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(String buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId;
    }
}
