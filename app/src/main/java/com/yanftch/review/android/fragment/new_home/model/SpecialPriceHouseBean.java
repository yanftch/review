package com.yanftch.review.android.fragment.new_home.model;

import java.util.List;

public class SpecialPriceHouseBean {
    private String title;
    private String bigTitle;
    private String endTime;
    private long surplusTime;
    private String actBaseImg;
    private String titleImage;
    private List<SpecialPriceHouseVosBean> speicalPriceHouseVos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBigTitle() {
        return bigTitle;
    }

    public void setBigTitle(String bigTitle) {
        this.bigTitle = bigTitle;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getSurplusTime() {
        return surplusTime;
    }

    public void setSurplusTime(long surplusTime) {
        this.surplusTime = surplusTime;
    }

    public String getActBaseImg() {
        return actBaseImg;
    }

    public void setActBaseImg(String actBaseImg) {
        this.actBaseImg = actBaseImg;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public List<SpecialPriceHouseVosBean> getSpeicalPriceHouseVos() {
        return speicalPriceHouseVos;
    }

    public void setSpeicalPriceHouseVos(List<SpecialPriceHouseVosBean> speicalPriceHouseVos) {
        this.speicalPriceHouseVos = speicalPriceHouseVos;
    }

    public static class SpecialPriceHouseVosBean {
        public static final int TYPE_PROJECT_DETAIL = 1;
        public static final int TYPE_HOUSE_DETAIL = 2;

        /**
         * 是进入项目详情页的类型
         */
        public boolean isProjectDetailType() {
            return type == TYPE_PROJECT_DETAIL;
        }
        public boolean isHouseTypeDetailType() {
            return type == TYPE_HOUSE_DETAIL;
        }

        private String projectFid;
        private String projectName;
        private String houseTypeFid;
        private String houseTypeName;
        private String houseTypePic;
        private String amountTxt;
        private String amount;
        private String originalPrice;
        private String area;
        private String businessCircle;
        private String buyTxt;
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getProjectFid() {
            return projectFid;
        }

        public void setProjectFid(String projectFid) {
            this.projectFid = projectFid;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getHouseTypeFid() {
            return houseTypeFid;
        }

        public void setHouseTypeFid(String houseTypeFid) {
            this.houseTypeFid = houseTypeFid;
        }

        public String getHouseTypeName() {
            return houseTypeName;
        }

        public void setHouseTypeName(String houseTypeName) {
            this.houseTypeName = houseTypeName;
        }

        public String getHouseTypePic() {
            return houseTypePic;
        }

        public void setHouseTypePic(String houseTypePic) {
            this.houseTypePic = houseTypePic;
        }

        public String getAmountTxt() {
            return amountTxt;
        }

        public void setAmountTxt(String amountTxt) {
            this.amountTxt = amountTxt;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getBusinessCircle() {
            return businessCircle;
        }

        public void setBusinessCircle(String businessCircle) {
            this.businessCircle = businessCircle;
        }

        public String getBuyTxt() {
            return buyTxt;
        }

        public void setBuyTxt(String buyTxt) {
            this.buyTxt = buyTxt;
        }
    }
}
