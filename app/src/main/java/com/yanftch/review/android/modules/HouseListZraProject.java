package com.yanftch.review.android.modules;

import java.util.List;

/**
 * Created by huangjin.
 * Date: 2018-10-10 下午4:44
 * Description:
 */

public class HouseListZraProject {


    /**
     * project_id : 21
     * project_name : 北京上地凌云自如寓
     * tags : []
     * subway_station_info : 小区距上地站步行约840米
     * discount_info :
     * score : 4.5
     * score_text : 优质
     */

    private String project_id;
    private String project_name;
    private String subway_station_info;
    private String discount_info;
    private Float score;
    private String score_text;
    private List<String> tags;

    private String target;
    private String parameter;
    private String router_title;

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getSubway_station_info() {
        return subway_station_info;
    }

    public void setSubway_station_info(String subway_station_info) {
        this.subway_station_info = subway_station_info;
    }

    public String getDiscount_info() {
        return discount_info;
    }

    public void setDiscount_info(String discount_info) {
        this.discount_info = discount_info;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getScore_text() {
        return score_text;
    }

    public void setScore_text(String score_text) {
        this.score_text = score_text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public String getRouter_title() {
        return router_title;
    }

    public void setRouter_title(String router_title) {
        this.router_title = router_title;
    }
}
