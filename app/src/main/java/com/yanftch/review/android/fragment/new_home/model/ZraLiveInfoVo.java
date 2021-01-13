package com.yanftch.review.android.fragment.new_home.model;


import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User : yanftch
 * Date : 2020-02-17
 * Time : 13:39
 * Desc : 自如寓直播相关信息 model
 */
@SuppressWarnings("unused")
public class ZraLiveInfoVo implements Serializable {

    /**
     * 主标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 直播相关优惠信息
     */
    private String favourMsg;

    /**
     * 更多直播 URL
     */
    private String moreLiveUrl;

    /**
     * 直播数据
     */
    private LiveDataBean liveData;
    /**
     * 预告数据
     */
    private List<LiveDataBean> preLiveData;

    public String getFavourMsg() {
        return favourMsg;
    }

    public void setFavourMsg(String favourMsg) {
        this.favourMsg = favourMsg;
    }

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

    public String getMoreLiveUrl() {
        return moreLiveUrl;
    }

    public void setMoreLiveUrl(String moreLiveUrl) {
        this.moreLiveUrl = moreLiveUrl;
    }

    public LiveDataBean getLiveData() {
        return liveData;
    }

    public List<LiveDataBean> getLiveDatas() {
        List<LiveDataBean> list = new ArrayList<>();
        list.add(liveData);
        return list;
    }

    public void setLiveData(LiveDataBean liveData) {
        this.liveData = liveData;
    }

    public List<LiveDataBean> getPreLiveData() {
        return preLiveData;
    }

    public void setPreLiveData(List<LiveDataBean> preLiveData) {
        this.preLiveData = preLiveData;
    }

    public static class LiveDataBean implements Serializable {
        private String liveMessage;

        private JSONObject parameter;
        private String favourMsg;

        private String img;
        private String title;
        private String projectFid;
        private String projectImg;
        private String projectName;
        private String cityCode;
        private String projectAddr;
        /**
         * 直播显示时间
         */
        private String liveTime;

        /**
         * 需要传递给[关注]接口用
         */
        private String liveShowTime;

        private String liveZoName;
        /**
         * 抖音 ID
         */
        private String liveZoCode;
        private String liveTiktokAccount;
        private String description;
        private String target;
        private String projectId;
        /**
         * 直播状态
         * 1：直播中
         * 0：预告
         */
        private int liveStatus;
        private long liveEndTime;
        private long liveStartTime;

        /**
         * 关注状态  1-已关注  0-未关注
         */
        private int status;
        private List<LabelVoListBean> labelVoList;

        /**
         * 写入日历提醒的备注信息
         */
        private String tiktokUrl;

        /**
         * 是否已关注
         *
         * @return TRUE 表示已关注
         */
        public boolean hasWatched() {
            return status == 1;
        }

        public boolean isLiving() {
            return liveStatus == 1;
        }

        public String getLiveMessage() {
            return liveMessage;
        }

        public void setLiveMessage(String liveMessage) {
            this.liveMessage = liveMessage;
        }

        public String getLiveShowTime() {
            return liveShowTime;
        }

        public void setLiveShowTime(String liveShowTime) {
            this.liveShowTime = liveShowTime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public JSONObject getParameter() {
            return parameter;
        }

        public void setParameter(JSONObject parameter) {
            this.parameter = parameter;
        }

        public String getFavourMsg() {
            return favourMsg;
        }

        public void setFavourMsg(String favourMsg) {
            this.favourMsg = favourMsg;
        }

        public String getTitle() {
            return title;
        }

        public String getTiktokUrl() {
            return tiktokUrl;
        }

        public void setTiktokUrl(String tiktokUrl) {
            this.tiktokUrl = tiktokUrl;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getProjectAddr() {
            return projectAddr;
        }

        public void setProjectAddr(String projectAddr) {
            this.projectAddr = projectAddr;
        }

        public String getLiveTime() {
            return liveTime;
        }

        public void setLiveTime(String liveTime) {
            this.liveTime = liveTime;
        }

        public String getLiveZoName() {
            return liveZoName;
        }

        public void setLiveZoName(String liveZoName) {
            this.liveZoName = liveZoName;
        }

        public String getLiveZoCode() {
            return liveZoCode;
        }

        public void setLiveZoCode(String liveZoCode) {
            this.liveZoCode = liveZoCode;
        }

        public String getLiveTiktokAccount() {
            return liveTiktokAccount;
        }

        public void setLiveTiktokAccount(String liveTiktokAccount) {
            this.liveTiktokAccount = liveTiktokAccount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public int getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(int liveStatus) {
            this.liveStatus = liveStatus;
        }

        public long getLiveEndTime() {
            return liveEndTime;
        }

        public void setLiveEndTime(long liveEndTime) {
            this.liveEndTime = liveEndTime;
        }

        public long getLiveStartTime() {
            return liveStartTime;
        }

        public void setLiveStartTime(long liveStartTime) {
            this.liveStartTime = liveStartTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<LabelVoListBean> getLabelVoList() {
            return labelVoList;
        }

        public void setLabelVoList(List<LabelVoListBean> labelVoList) {
            this.labelVoList = labelVoList;
        }

        public static class LabelVoListBean {

            private String title;
            private int hot;
            private String bg_img;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public String getBg_img() {
                return bg_img;
            }

            public void setBg_img(String bg_img) {
                this.bg_img = bg_img;
            }
        }
    }

}
