package com.yanftch.review.android.pages.two_tab;


import java.io.Serializable;
import java.util.List;

/**
 * Created by huangjin.
 * Date: 2019-02-19 2:29 PM
 * Description:
 * <p>
 * 房源详情的轮播的媒体
 */

public class HouseMedia implements Serializable {


    public final static int TYPE_VR = 1;
    public final static int TYPE_VIDEO = 2;
    // 图片
    public final static int TYPE_IMAGE = 3;
    // 户型图
    public final static int TYPE_IMAGE_HOUSE_TYPE = 4;
    public final static int TYPE_VR_PREVIEW = 5;

    private int type;

    private String tag;

    // 详情页展示的图
    private String imgShow;

    // 此media对应的所有图片资源
    private List<String> imgs;

    // vr或者视频的时候，为vr或视频的链接
    private String link;


    // 视频的播放位置
    private int videoTime;

    private String videoLinkType;

    private String videoLinkName;

    private Integer videoWidth;
    private Integer videoHeight;
    private String videoBgImg;
    private int videoType;//2 全景视频


    private String vrName;
    private String vrShareContent;
    private String vrShareImg;

    private String question;

    /**
     * 配置信息
     */
    private String area;
    private String face;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgShow() {
        return imgShow;
    }

    public void setImgShow(String imgShow) {
        this.imgShow = imgShow;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoLinkType() {
        return videoLinkType;
    }

    public void setVideoLinkType(String videoLinkType) {
        this.videoLinkType = videoLinkType;
    }

    public String getVideoLinkName() {
        return videoLinkName;
    }

    public void setVideoLinkName(String videoLinkName) {
        this.videoLinkName = videoLinkName;
    }

    public String getVrName() {
        return vrName;
    }

    public void setVrName(String vrName) {
        this.vrName = vrName;
    }

    public String getVrShareContent() {
        return vrShareContent;
    }

    public void setVrShareContent(String vrShareContent) {
        this.vrShareContent = vrShareContent;
    }

    public String getVrShareImg() {
        return vrShareImg;
    }

    public void setVrShareImg(String vrShareImg) {
        this.vrShareImg = vrShareImg;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getVideoBgImg() {
        return videoBgImg;
    }

    public void setVideoBgImg(String videoBgImg) {
        this.videoBgImg = videoBgImg;
    }


    /**
     * 获取视频对应的视频控件的Constraint宽高比
     * @return
     */
    public String getVideoConstraintDimensionRatio() {
        if (videoWidth == null || videoHeight == null || videoWidth <= 0 || videoHeight <= 0) {
            return "16:9";
        } else {
            return videoWidth + ":" + videoHeight;
        }
    }

    /**
     * 是否是竖版视频
     * @return
     */
    public boolean isVerticalVideo() {
        return videoWidth != null && videoHeight != null && videoWidth > 0 && videoHeight >= videoWidth;
    }


    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }
}
