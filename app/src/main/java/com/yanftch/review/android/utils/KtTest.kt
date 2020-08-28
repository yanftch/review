package com.yanftch.review.android.utils

fun main() {
    println("begin>>>")
    getResultWithoutBack { lonInfo("无返回参数的方法 作为函数的参数！") }

    getResultWithBack { getBoolean(false) }
}

/**
 * 此方法，接收一个 无返回参数 的 方法 作为参数
 */
private fun getResultWithoutBack(method: () -> Unit) {
    method()
}

/**
 * 此方法，接收一个
 */
private fun getResultWithBack(method: () -> Boolean) {
    lonInfo("${method()}")
}

fun getBoolean(boolean: Boolean): Boolean {
    println("我是内部执行逻辑...")
    return boolean
}


fun lonInfo(msg: String) {
    println("lonInfo....msg = $msg")
}