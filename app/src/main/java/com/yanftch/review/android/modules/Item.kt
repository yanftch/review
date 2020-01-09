package com.yanftch.review.android.modules

/**
 *
 * User : yanftch
 * Date : 2019-08-21
 * Time : 17:22
 * Desc :
 */
data class Item(
    var itemName: String = "",
    var itemCode: Int,
    var isSingleChecked: Boolean, // 是否单选选中
    var isMultipleChecked: Boolean, // 是否多选选中
    var enableMultipleSelect: Boolean // 是否支持多选
)