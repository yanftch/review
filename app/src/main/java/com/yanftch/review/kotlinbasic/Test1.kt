package com.yanftch.review.kotlinbasic

import com.yanftch.review.model.BaseFacilitiesBean
import com.yanftch.review.model.FacilitiesBean

fun main(args: Array<String>) {
    val baseBean = BaseFacilitiesBean()
    baseBean.title = "标题字段"
    val list = arrayListOf<FacilitiesBean>()
    for (index in 0 until 17) {
        val item = FacilitiesBean()
        item.facilitiesName = "facilitiesName $index"
        item.iconUrl = "iconUrl $index"
        item.facilitiesTypeCode = "facilitiesTypeCode $index"

        list.add(item)
    }
    baseBean.list = list

    // 后台返回的数据源
    println("baseBean.list.size = ${baseBean.list.size}")
    val size = baseBean.list.size

    val a = size / 8
    val b = size % 8
    println("a = $a, b = $b")

    val splitList = ListUtil.splitList(list, 8)
    val bannerSize = splitList.size
    println("bannerSize = $bannerSize")
    for (index in 0 until bannerSize) {
        println("index = $index, size = ${splitList[index].size}, " + splitList[index]).toString()
    }


}

