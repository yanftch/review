package com.yanftch.review.demo.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
/**
 * 登录相关实体类
 * 给两个属性值设置默认值，可以提供空构造函数。
 * var 表示可以修改的变量值
 * data class 会自动提供set/get方法
 */
data class LoggedInUser(
    var userId: String = "",
    var displayName: String = ""
)
