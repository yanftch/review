package com.yanftch.review.kotlinbasic

/**
 *
 * User : yanftch
 * Date : 2019-11-01
 * Time : 17:37
 * Desc :
 */
class InnerClassDemo {
    private lateinit var student: Student

    private fun defaultParams(age: Int, name: String = "默认") {

    }

    init {
        student = Student(age = 10, name = "tom")
    }

    private val age = 100

    companion object {
        val NAME = "name"
    }

    //   private static final class InnerClass {
//      public InnerClass() {
//      }
//   }
    private class InnerClass {
    }

    //   private final class InInnerClass {
    //      public InInnerClass() {
    //      }
    //   }
    private inner class InInnerClass {
        var a = age
    }

}