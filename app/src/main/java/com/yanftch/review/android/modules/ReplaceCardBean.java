package com.yanftch.review.android.modules;

import java.io.Serializable;
import java.util.List;

/**
 * Author：李永飞
 * Time Created at 2022/5/7.
 */
public class ReplaceCardBean implements Serializable{
    private int ad_type; // 1换租宝
    private String title;
    private List<ReplaceCardItemBean> card_list;
    private ReplaceCardBtnBean button;

    public int getAd_type() {
        return ad_type;
    }

    public void setAd_type(int ad_type) {
        this.ad_type = ad_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ReplaceCardItemBean> getCard_list() {
        return card_list;
    }

    public void setCard_list(List<ReplaceCardItemBean> card_list) {
        this.card_list = card_list;
    }

    public ReplaceCardBtnBean getButton() {
        return button;
    }

    public void setButton(ReplaceCardBtnBean button) {
        this.button = button;
    }

    public ReplaceCardBean( String title, List<ReplaceCardItemBean> card_list, ReplaceCardBtnBean button) {
        this.title = title;
        this.card_list = card_list;
        this.button = button;
    }

    public ReplaceCardBean() {
    }

    public static class ReplaceCardItemBean implements Serializable {
        private String icon;
        private String text;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class ReplaceCardBtnBean implements Serializable{
        private String title;
        private String target;
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

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }


}
