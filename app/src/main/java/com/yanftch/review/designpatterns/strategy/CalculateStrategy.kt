package com.yanftch.review.designpatterns.strategy

/**
 *
 * User : yanftch
 * Date : 2019-11-28
 * Time : 18:30
 * Desc : 定义抽象的价格计算接口，并定义价格计算的方法
 */
interface CalculateStrategy {

    /**
     * 根据距离计算价格
     * @param km 行驶距离
     * @return 价格
     */
    fun calculatePrice(km: Int): Int
}