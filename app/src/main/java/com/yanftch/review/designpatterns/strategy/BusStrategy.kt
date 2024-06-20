package com.yanftch.review.designpatterns.strategy

/**
 *
 * User : yanftch
 * Date : 2019-11-28
 * Time : 18:33
 * Desc : 公交车出行价格计算策略类
 */
class BusStrategy : CalculateStrategy {

    /**
     * 公交车出行计算规则：
     * 0~10 公里 1 元
     * 10~20 2 元
     * 20~30 3 元
     * 30~ 4 元
     */
    override fun calculatePrice(km: Int) = when (km) {
        in 0..10 -> 1
        in 11..20 -> 2
        in 21..30 -> 3
        else -> 4
    }
}
