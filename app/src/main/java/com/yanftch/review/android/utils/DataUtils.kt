package com.yanftch.review.android.utils

import com.yanftch.review.android.modules.Item

/**
 *
 * User : yanftch
 * Date : 2019-08-22
 * Time : 16:09
 * Desc :
 */

fun getFilterDatas(): HashMap<String, List<com.yanftch.review.android.modules.Item>> {
    val datas = HashMap<String, List<com.yanftch.review.android.modules.Item>>()

    val distanceList = mutableListOf(
        com.yanftch.review.android.modules.Item(
            "近到远", 0,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "远到近", 1,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        )
    ).toList()
    val priceList = mutableListOf(
        com.yanftch.review.android.modules.Item(
            "0~99", 0,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "100~999", 1,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "1000~9999", 2,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "10000+", 3,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        )
    ).toList()
    val catList = mutableListOf(
        com.yanftch.review.android.modules.Item(
            "衣服", 0,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "电子", 1,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "家具", 2,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "其他", 3,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        )
    ).toList()

    val otherList = mutableListOf(
        com.yanftch.review.android.modules.Item(
            "A", 0,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "B", 1,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "C", 2,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        ),
        com.yanftch.review.android.modules.Item(
            "D", 3,
            isSingleChecked = false,
            isMultipleChecked = false,
            enableMultipleSelect = false
        )
    ).toList()

    datas["距离"] = distanceList
    datas["价格"] = priceList
    datas["品类"] = catList
    datas["其他"] = otherList
    return datas
}