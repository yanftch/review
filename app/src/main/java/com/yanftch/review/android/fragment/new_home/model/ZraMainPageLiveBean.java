package com.yanftch.review.android.fragment.new_home.model;

import java.util.List;

public class ZraMainPageLiveBean {
    private String title;
    private String target;
    private String parameter;
    private String type; // 1 直播看房   2 视频看房
    private List<ZraLiveInfoVo.LiveDataBean> list;

    /**
     * 是直播类型
     */
    public boolean isLiveType() {
        return "1".equals(type);
    }

    /**
     * 是视频类型
     */
    public boolean isVideoType() {
        return "2".equals(type);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ZraLiveInfoVo.LiveDataBean> getList() {
        return list;
    }

    public void setList(List<ZraLiveInfoVo.LiveDataBean> list) {
        this.list = list;
    }
}
