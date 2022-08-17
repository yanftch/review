package com.yanftch.review.kotlinbasic;

import com.yanftch.review.model.FacilitiesBean;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static List<List<FacilitiesBean>> splitList(List<FacilitiesBean> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<FacilitiesBean>> result = new ArrayList<List<FacilitiesBean>>();


        int size = list.size();
        int count = (size + len - 1) / len; // 15/8 = 1


        for (int i = 0; i < count; i++) {
            List<FacilitiesBean> subList = list.subList(i * len, (Math.min((i + 1) * len, size)));
            result.add(subList);
        }
        return result;
    }
}
