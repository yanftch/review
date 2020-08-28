package com.yanftch.review.android.modules

import java.io.Serializable


data class PriceDialogModel(
    var buttonText: String = "", // 按钮文案
    var leaseTitle: String = "", // 租期
    var list: List<ItemBean> = mutableListOf(),
    var originalPriceTitle: String = "", // 原价
    var prePriceTitle: String = "", // 优惠价
    var subTitle: String = "", // 副标题
    var title: String = "", // 标题
    var time: Long = 0L,
    var endMessage: String = ""
) : Serializable

data class ItemBean(
    var color: String = "#FF3737",
    var lease: String = "",
    var originalPrice: String = "",
    var prePrice: String = "",
    var priceUnit: String = "",
    var unit: String = ""
) : Serializable {
    override fun toString(): String {
        return "ItemBean(color='$color', lease='$lease', originalPrice='$originalPrice', prePrice='$prePrice', priceUnit='$priceUnit', unit='$unit')"
    }
}