package com.yanftch.review.android.fragment.new_home.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ZraImageEntity implements Serializable{
        private String img;
        private String img2;
        private String title;
        private String sub_title;
        private String target;
        private String type;
        private JSONObject parameter;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
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

        public JSONObject getParameter() {
            return parameter;
        }

        public void setParameter(JSONObject parameter) {
            this.parameter = parameter;
        }
    }
