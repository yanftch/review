package com.yanftch.review.designpatterns.simplefactory;

/**
 * 计算机的 具体类
 */
public class LenovoComputer extends Computer {

    @Override
    public void start() {
        System.out.println("联想计算机...start...");
    }
}
