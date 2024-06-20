package com.yanftch.review.designpatterns.strategy

/**
 *
 * User : yanftch
 * Date : 2019-11-28
 * Time : 18:42
 * Desc : Context 角色的类
 */
class TraficCalculator {


    // 提供方法，便于设置具体的策略
    var mStrategy: CalculateStrategy? = null

    fun setStrategy(strategy: CalculateStrategy) {
        mStrategy = strategy
    }

    fun calculatePrice(km: Int) = mStrategy?.calculatePrice(km)


    //// 使用
}

fun main() {
    val traficCalculator = TraficCalculator()
    traficCalculator.setStrategy(BusStrategy())
    val price = traficCalculator.calculatePrice(16)
    print("公交车行驶 16km 的费用是：$price")

}
