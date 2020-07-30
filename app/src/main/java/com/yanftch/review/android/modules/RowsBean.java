package com.yanftch.review.android.modules;

import java.util.List;

public class RowsBean {
    public RowsBean(String picList) {
        this.picList = picList;
    }

    public RowsBean(String videoUrl, String picList) {
        this.videoUrl = videoUrl;
        this.picList = picList;
    }

    /**
     * impressFid : 8a90a5946826b81b01682b6d58e80008
     * content : 大胆大大好大好大哈是的哈是的哈是大坏蛋哈收到撒花
     * labelList : ["好多人啊","洗澡去了"]
     * picList : [{"picUrl":"${cloudimg_url}6621bfd3-6689-43cf-bcc2-ff7c7a5c00f7.jpg${pic_size_1200_800}.jpg","height":0,"width":0},{"picUrl":"${cloudimg_url}6621bfd3-6689-43cf-bcc2-ff7c7a5c00f7.jpg${pic_size_1200_800}.jpg","height":0,"width":0},{"picUrl":"${cloudimg_url}6621bfd3-6689-43cf-bcc2-ff7c7a5c00f7.jpg${pic_size_1200_800}.jpg","height":0,"width":0}]
     * videoUrl : null
     * uid : 6cf0125e-b6ee-439e-8efc-b99c9ed9b94f
     * nickname : null
     * headPicUrl : null
     * praiseCount : 0
     * commentCount : 0
     * createDate : 1546917095000
     * isPraise : -1
     * impressStatus : null
     * mediaType : 1
     */

    private String impressFid;
    private String content;
    private String videoUrl;
    private String uid;
    private String nickname;
    private String headPicUrl;
    private int praiseCount; // 点赞数量
    private int commentCount;
    private long createDate;
    private int isPraise; // 1-已点赞  0-未点赞
    private String impressStatus;
    private int mediaType; // 媒体类型 1 图片；2 视频
    private List<String> labelList;
    private String picList;
    private boolean isPublishing = false;

    public boolean isPublishing() {
        return isPublishing;
    }

    public void setPublishing(boolean publishing) {
        isPublishing = publishing;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public String getImpressStatus() {
        return impressStatus;
    }

    public void setImpressStatus(String impressStatus) {
        this.impressStatus = impressStatus;
    }

    public String getImpressFid() {
        return impressFid;
    }

    public void setImpressFid(String impressFid) {
        this.impressFid = impressFid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(int isPraise) {
        this.isPraise = isPraise;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public boolean isVideo() {
        return 2 == mediaType;
    }

    /**
     * 是否已经点赞
     *
     * @return TRUE-已经点赞
     */
    public boolean isPraised() {
        return 1 == isPraise;
    }

}