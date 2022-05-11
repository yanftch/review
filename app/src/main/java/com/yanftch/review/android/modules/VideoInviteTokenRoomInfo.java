package com.yanftch.review.android.modules;

import java.io.Serializable;

public class VideoInviteTokenRoomInfo implements Serializable {
    private String roomId;
    private int roomStatus; // 1 正常  2 房间已关闭

    /**
     * 房间正常，可以进入房间
     */
    public boolean canEnterRoom() {
        return roomStatus == 1;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }
}
