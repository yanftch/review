package com.yanftch.review.android.modules;

import java.io.Serializable;
import java.util.List;

public class VideoEvaluateBean implements Serializable {
    private String title;
    private String subTitle;
    private List<VideoEvaluateOptionBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<VideoEvaluateOptionBean> getList() {
        return list;
    }

    public void setList(List<VideoEvaluateOptionBean> list) {
        this.list = list;
    }
}
