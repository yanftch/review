package com.yanftch.review.android.modules;

import java.io.Serializable;

public class VideoEvaluateOptionBean implements Serializable {
    private String option;
    private String text;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
