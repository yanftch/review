package com.yanftch.review.android.fragment.new_home.model;

import com.yanftch.review.android.adapter.loadmore.LoadMoreAdapter;

import java.util.List;

public class ZraRecFlowBean implements LoadMoreAdapter.IMuilType {

    /**
     * 卡片类型，枚举值
     * 1.营销配置卡片
     * 2.房型卡片
     *
     * ......
     *
     */
    private int type;

    @Override
    public int getViewType() {
        return type;
    }

    // 视频地址
    private String videoUrl;

    // 视频时长
    private String videoDuration;

    private String target;
    private String parameter;

    private String projectName;
    private List<BaseImg> baseImg;
    private String playButton;
    private String signStatus;
    private String houseTypeName;
    private String district;
    private String bizcircleName;
    private String houseTypeShowName;
    private String area;
    private String price;
    private String prePrice;
    private String price_unit;
    private String unit;
    private List<String> tsLabel;
    private List<String> preferentialLabel;


    // ============================================================================================
    // ============================================================================================
    // ============================================================================================
    // ============================================================================================

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<BaseImg> getBaseImg() {
        return baseImg;
    }

    public void setBaseImg(List<BaseImg> baseImg) {
        this.baseImg = baseImg;
    }

    public String getPlayButton() {
        return playButton;
    }

    public void setPlayButton(String playButton) {
        this.playButton = playButton;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBizcircleName() {
        return bizcircleName;
    }

    public void setBizcircleName(String bizcircleName) {
        this.bizcircleName = bizcircleName;
    }

    public String getHouseTypeShowName() {
        return houseTypeShowName;
    }

    public void setHouseTypeShowName(String houseTypeShowName) {
        this.houseTypeShowName = houseTypeShowName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(String prePrice) {
        this.prePrice = prePrice;
    }

    public String getPrice_unit() {
        return price_unit;
    }

    public void setPrice_unit(String price_unit) {
        this.price_unit = price_unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getTsLabel() {
        return tsLabel;
    }

    public void setTsLabel(List<String> tsLabel) {
        this.tsLabel = tsLabel;
    }

    public List<String> getPreferentialLabel() {
        return preferentialLabel;
    }

    public void setPreferentialLabel(List<String> preferentialLabel) {
        this.preferentialLabel = preferentialLabel;
    }
}
