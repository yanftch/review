package com.yanftch.review.android.modules;

import java.io.Serializable;

public class VideoInviteTokenProjectInfo implements Serializable {
    private String projectFid;
    private String projectImg;
    private String projectName;

    public String getProjectFid() {
        return projectFid;
    }

    public void setProjectFid(String projectFid) {
        this.projectFid = projectFid;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
