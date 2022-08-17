package com.yanftch.review.model;

import java.util.ArrayList;

/**
 * Created by Wangm on 2019/5/29.
 */
public class BaseFacilitiesBean {
    public ArrayList<FacilitiesBean> list;
    public String title;

    public ArrayList<FacilitiesBean> getList() {
        return list;
    }

    public void setList(ArrayList<FacilitiesBean> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BaseFacilitiesBean{" +
                "list=" + list +
                ", title='" + title + '\'' +
                '}';
    }
}
