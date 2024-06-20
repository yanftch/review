package com.yanftch.review.bean

/**
 *
 * User : yanftch
 * Date : 2019-07-24
 * Time : 12:35
 * Desc :
 */
data class MenuItems(
    var name: String = "",
    var highlight: Boolean = false,
    var clazz: Class<*>? = null
)