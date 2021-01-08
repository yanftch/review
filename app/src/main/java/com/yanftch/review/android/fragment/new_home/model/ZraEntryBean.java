package com.yanftch.review.android.fragment.new_home.model;

public class ZraEntryBean {
    /**
     * 底图
     */
    private String img;
    /**
     * 标题
     */
    private String title;
    /**
     * 右上角角标
     */
    private String icon;
    /**
     * 右上角角标-动图
     */
    private String iconSvga;

    private String target;
    private String parameter;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconSvga() {
        return iconSvga;
    }

    public void setIconSvga(String iconSvga) {
        this.iconSvga = iconSvga;
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
}
