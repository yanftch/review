package com.yanftch.review.android.pages.douyin;

import com.yanftch.review.android.modules.RowsBean;

import java.util.List;

public class OutModel {
    private InnerModel data;

    public InnerModel getData() {
        return data;
    }

    public void setData(InnerModel data) {
        this.data = data;
    }

    class InnerModel {
        private List<RowsBean> rows;

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }
    }
}
