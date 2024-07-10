package com.yanftch.basic.kotlinbasic

object Demo {
    val temp: String by lazy {
        print("懒加载")
        return@lazy "1"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var list: ArrayList<String> = ArrayList<String>()
        list.add("A")
        list.add("B")
        list.add("C")
        val result = list.joinToString(separator = "|")
        println("result = " + result)
    }


//    fun method1() {
//        showToast("你好")
//    }
//
//    fun method2() {
//        showToastInline("你好")
//    }
//
//    fun showToast(message: String?) {
//        T.showToast(message)
//    }
//
//    inline fun showToastInline(message: String?) {
//        T.showToast(message)
//    }

}