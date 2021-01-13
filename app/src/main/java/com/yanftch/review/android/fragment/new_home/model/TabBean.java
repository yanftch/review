package com.yanftch.review.android.fragment.new_home.model;

public class TabBean {
    // 1  表示的是瀑布流
    private final String TYPE_REC = "1";

    // 2 表示的是项目列表
    private final String TYPE_PROJECT_LIST = "2";


    private String title;
    private String type;

    public boolean isRecPage() {
        return TYPE_REC.equals(type);
    }

    public boolean isProjectListPage() {
        return TYPE_PROJECT_LIST.equals(type);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
