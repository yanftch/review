package com.yanftch.review.designpatterns.strategy

/**
 *
 * User : yanftch
 * Date : 2019-11-28
 * Time : 18:38
 * Desc : 地铁出行价格计算策略类
 */
class SubwayStrategy : CalculateStrategy {

    override fun calculatePrice(km: Int) =
        when (km) {
            in 0..6 -> 3
            in 7..12 -> 4
            in 13..22 -> 5
            in 23..32 -> 6
            else -> 7
        }
}