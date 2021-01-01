package com.yanftch.review.android.modules;

public class PriceBean {
    private double price;
    private String timeStr;
    private boolean isLowPrice;

    @Override
    public String toString() {
        return "PriceBean{" +
                "price=" + price +
                ", timeStr='" + timeStr + '\'' +
                ", isLowPrice=" + isLowPrice +
                '}';
    }

    public boolean isLowPrice() {
        return isLowPrice;
    }

    public void setLowPrice(boolean lowPrice) {
        isLowPrice = lowPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
