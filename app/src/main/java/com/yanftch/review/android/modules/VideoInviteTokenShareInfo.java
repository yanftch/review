package com.yanftch.review.android.modules;

import java.io.Serializable;

public class VideoInviteTokenShareInfo implements Serializable {
    private String userImg; // 用户头像
    private String userName;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
