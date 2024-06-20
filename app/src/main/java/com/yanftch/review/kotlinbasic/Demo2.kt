package com.yanftch.review.kotlinbasic

object Demo2 {
    @JvmStatic
    fun main(args: Array<String>) {
//        val user: User? = User(12, "小红")
        val user: User? = null
        user?.let {

        }
        val list = mutableListOf<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        val intList = mutableListOf<User>()
        list.mapTo(intList){
            User(age = it.toInt(), name = "name$it")
        }
        println("list == $list")
        println("intList == $intList")
//        user?.apply {
//            this.age = 24
//            this.name = "晓明"
//            println("apply")
//        }
//            ?: kotlin.run {
//            println("run...")
//        }
//
//        print(user)
    }
}