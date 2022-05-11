package com.yanftch.review.android.modules;

import com.yanftch.review.android.fragment.new_home.model.ZraEntryBean;

import java.io.Serializable;

public class VideoInviteTokenBean implements Serializable {
    private VideoInviteTokenProjectInfo projectInfo;
    private VideoInviteTokenShareInfo shareInfo;
    private ZraEntryBean button;
    private VideoInviteTokenRoomInfo roomInto;

    public VideoInviteTokenProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(VideoInviteTokenProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    public VideoInviteTokenShareInfo getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(VideoInviteTokenShareInfo shareInfo) {
        this.shareInfo = shareInfo;
    }

    public ZraEntryBean getButton() {
        return button;
    }

    public void setButton(ZraEntryBean button) {
        this.button = button;
    }

    public VideoInviteTokenRoomInfo getRoomInto() {
        return roomInto;
    }

    public void setRoomInto(VideoInviteTokenRoomInfo roomInto) {
        this.roomInto = roomInto;
    }
}
