package com.yanftch.review.designpatterns.simplefactory;

public class HpComputer extends Computer {
    @Override
    public void start() {
        System.out.println("惠普计算机...start...");
    }
}
