package com.yanftch.review.android.fragment.new_home.model;

import java.io.Serializable;
import java.util.List;

public class ZraRecommendzryEntity implements Serializable {
    private String title;
    private String sub_title;
    private MoreBean title_more;
    private MoreBean more;
    private List<RecommendZRY> data;

    // 快筛标签数据集合，需要从外部解析后设置进来
    private List<TagModel> rapidLabelVoList;

    private ZraImageEntity map;  //根据接口数据 本地构造的地图入口

    /**
     * 是否是 UGC版本---接口不会返回这个字段，需要从外部传入进来。
     */
    private String ugcVersion;

    public String getUgcVersion() {
        return ugcVersion;
    }

    public void setUgcVersion(String ugcVersion) {
        this.ugcVersion = ugcVersion;
    }

    public List<TagModel> getRapidLabelVoList() {
        return rapidLabelVoList;
    }

    public void setRapidLabelVoList(List<TagModel> rapidLabelVoList) {
        this.rapidLabelVoList = rapidLabelVoList;
    }

    public ZraImageEntity getMap() {
        return map;
    }

    public void setMap(ZraImageEntity map) {
        this.map = map;
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

    public MoreBean getTitle_more() {
        return title_more;
    }

    public void setTitle_more(MoreBean title_more) {
        this.title_more = title_more;
    }

    public MoreBean getMore() {
        return more;
    }

    public void setMore(MoreBean more) {
        this.more = more;
    }

    public List<RecommendZRY> getData() {
        return data;
    }

    public void setData(List<RecommendZRY> data) {
        this.data = data;
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

    public static class RecommendZRY implements Serializable {
        private String title;
        private String sub_title;
        private String description;
        private List<ZraImgPagerEntity> imgs;
        private List<ZraImgPagerEntity> sortedImgs;
        private List<LabelInfoBean> labelVoList;
        private String distance;
        private String vedio_url;
        private String vedio_img;
        private String target;
        private String type;
        private String parameter;
        /**
         * 2020年04月02日21:27:43 新增
         */
        private String rapidLabel; // 卡片顶部标签文案
        private String evaluate; // 卡片评价信息
        private String author; // 卡片评价作者
        private String textAndNumber; // 卡片底部标签文案
        private String newSubTitle;

        private String price; // 原价，划线价
        private String price_unit; // 价格单位
        private String unit;
        // 划线价
        private String prePrice; // 优惠价，非划线价
        private Style prePriceStyle;
        private Style priceStyle;
        private int isLive; // 1=直播中


        public boolean isInLiving() {
            return isLive == 1;
        }
        // -------


        public int getIsLive() {
            return isLive;
        }

        public void setIsLive(int isLive) {
            this.isLive = isLive;
        }

        public String getPrePrice() {
            return prePrice;
        }

        public void setPrePrice(String prePrice) {
            this.prePrice = prePrice;
        }

        public Style getPrePriceStyle() {
            return prePriceStyle;
        }

        public void setPrePriceStyle(Style prePriceStyle) {
            this.prePriceStyle = prePriceStyle;
        }

        public Style getPriceStyle() {
            return priceStyle;
        }

        public void setPriceStyle(Style priceStyle) {
            this.priceStyle = priceStyle;
        }

        public String getNewSubTitle() {
            return newSubTitle;
        }

        public void setNewSubTitle(String newSubTitle) {
            this.newSubTitle = newSubTitle;
        }

        public String getRapidLabel() {
            return rapidLabel;
        }

        public void setRapidLabel(String rapidLabel) {
            this.rapidLabel = rapidLabel;
        }

        public String getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(String evaluate) {
            this.evaluate = evaluate;
        }

        public String getTextAndNumber() {
            return textAndNumber;
        }

        public void setTextAndNumber(String textAndNumber) {
            this.textAndNumber = textAndNumber;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        public List<ZraImgPagerEntity> getSortedImgs() {
            return sortedImgs;
        }

        public void setSortedImgs(List<ZraImgPagerEntity> sortedImgs) {
            this.sortedImgs = sortedImgs;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
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

        public List<LabelInfoBean> getLabelVoList() {
            return labelVoList;
        }

        public void setLabelVoList(List<LabelInfoBean> labelVoList) {
            this.labelVoList = labelVoList;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice_unit() {
            return price_unit;
        }

        public void setPrice_unit(String price_unit) {
            this.price_unit = price_unit;
        }

        public List<ZraImgPagerEntity> getImgs() {
            return imgs;
        }

        public void setImgs(List<ZraImgPagerEntity> imgs) {
            this.imgs = imgs;
        }

        public String getTarget() {
            return target;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
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


        public class ImageEntity implements Serializable {
            private String url;
            private List<MoreBean> link;

            public List<MoreBean> getLink() {
                return link;
            }

            public void setLink(List<MoreBean> link) {
                this.link = link;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }

    }


}
