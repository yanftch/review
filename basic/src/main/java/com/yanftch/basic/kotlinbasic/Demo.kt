package com.yanftch.basic.kotlinbasic

class Demo {
    val temp: String by lazy {
        print("懒加载")
        return@lazy "1"
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