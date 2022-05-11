package com.yanftch.review.android.modules;

import java.util.List;

public class ProjectBean {
    private String houseTypeName;
    private String houseTypePic;
    private String minPrice;
    private String subwayStationInfo;

    public String getSubwayStationInfo() {
        return subwayStationInfo;
    }

    public void setSubwayStationInfo(String subwayStationInfo) {
        this.subwayStationInfo = subwayStationInfo;
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

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }
}
