package com.yanftch.review.android.fragment.new_home.model;

import java.util.List;

public class ZraMarketModel {

    public boolean isSingleType() {
        return "1".equals(type);
    }
    public boolean isMulType() {
        return "2".equals(type);
    }
    private String type; // 1 = 表示的是纯展示类型(单个)   2 = 表示的是有按钮的类型(多个子视图)
    private List<ZraMainMarketBean> list;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ZraMainMarketBean> getList() {
        return list;
    }

    public void setList(List<ZraMainMarketBean> list) {
        this.list = list;
    }
}
