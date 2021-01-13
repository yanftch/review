package com.yanftch.review.android.fragment.new_home.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wangm on 2019/5/15.
 */
public class ZraImgPagerEntity {
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_IMG = 0;

    String url;
    private String vedio_url;
    private String vedio_img;
    List<MoreBean> link;
    int type = TYPE_IMG;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVedio_url() {
        return vedio_url;
    }

    public void setVedio_url(String vedio_url) {
        this.vedio_url = vedio_url;
    }

    public String getVedio_img() {
        return vedio_img;
    }

    public void setVedio_img(String vedio_img) {
        this.vedio_img = vedio_img;
    }

    public List<MoreBean> getLink() {
        return link;
    }

    public void setLink(List<MoreBean> link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class MoreBean implements Serializable {

        /**
         * title :
         * target : ziroomCustomer://zrRentModule/zraProjectLis
         * type :
         * parameter : {"cityCode":"110000","cityName":"北京"}
         */

        private String title;
        private String target;
        private String type;
        private String parameter;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }
}
