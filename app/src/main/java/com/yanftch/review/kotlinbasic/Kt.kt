package com.yanftch.review.kotlinbasic

fun main(args: Array<String>) {
    println("Hello World")

    // 变量的数据类型
    var byte: Byte
    var float: Float = 1.0F
    var double: Double = 2.0
    var int: Int = 3
    var long: Long = 33
    var short: Short = 4
    var boolean: Boolean = false
    var char: Char = 'c'
    var string: String = "string"
    var intArray: IntArray = intArrayOf(1, 2, 3)
    var booleanArray: BooleanArray = booleanArrayOf(false, true)
    var stringArray: Array<String> = arrayOf("a", "b", "c")

    val s = "Hello Kotlin" // 定义一个字符串
    // 字符串查找

    println(s.first()) // 获取第一个字符
    println(s.last()) // 获取最后一个字符
    println(s.get(1)) // 获取索引值为 1 的字符
    println(s.lastIndexOf("l")) // 获取指定字符最有一次出现的索引值
    val a = "a"
    val b = "${a}b"
    println("b = $b") // b = ab

    println(s.find {
        it == 'o'
    })
    println(s)
    println(s[0]) // 根据索引值来获取对应位置上的字符
    for (c in s) { // 对字符串进行遍历
        print("$c,")
    }
    println()
    // 同时，kotlin 标准库中也提供了对应的字符串遍历的方法。
    s.forEach {
        print("$it,")
    }
    println()

    // if 语句
    val point = 60
    if (point < 60) {
        println("不及格")
    } else if (60 < point && point < 90) {
        println("良好")
    } else {
        println("优秀")
    }
    val result = if (point < 60) "淘汰" else "过关"
    println("result = $result")

    // when 语句
    val season = 3
    val seasonResult = when (season) {
        1, 2, 3 -> "春季"
        4, 5, 6 -> "夏季"
        else -> "其他季节"
    }
    println(seasonResult)

    // for 循环
    for (i in 1..4) {
        println("string--->$i")
    }

    val forArray = arrayOf("a", "b", "c")
    forArray.forEach {
        println("forEach----$it")
    }
    forArray.forEachIndexed { index, it ->
        println("forEachIndexed----index=$index  it=$it")
    }

    // 区间
    val qujian = 1.rangeTo(3) // 等价于 1 <= qujian <= 3
    val qujian2 = 1..3 // 等价于 1 <= qujian <= 3
    for (index in qujian) {
        println("区间的值：$index")
    }
    // 输出结果只有 1，2 两个值，因为右边不包含 3
    for (index in 1 until 3) {
        println("until的值：$index")
    }
    // 输出：3，2，1
    for (index in 3.downTo(1)) {
        println("区间的值：$index")
    }
    // 输出 1，3，5，7，9
    for (index in 1..10 step 2) {
        println("step = $index")
    }


    // 数组
    val array = arrayOf<String>("a", "b", "c", "b")
    println("值为 b 的索引值是：${array.indexOf("b")}")

    // 通过[]直接获取索引值处的元素
    println("索引值为 1 的元素是：${array[1]}")
    println("索引值为 1 的元素是：${array.get(1)}")
    println("数组的长度是：${array.size}")
    array.set(1, "bb")
    array[1] = "bb"
    println("索引值为 1 的元素是：${array[1]}")


    // 遍历
    array.forEach {
        println("数组元素：$it")
    }
    array.forEachIndexed { index, content ->
        println("数组元素：index=$index  content=$content")
    }
    for (content in array) {
        println("数组元素(for 循环)：$content")
    }
    for ((index, content) in array.withIndex()) {
        println("数组元素(withIndex)：index=$index content=$content")
    }


    // 类型判断
    val typeBoolean: Boolean = false
    println("typeBoolean 的类型是：${typeBoolean is Boolean}")

    val aStr = "aaaa"
    val bString = aStr as String
    println("bString 的类型是：${bString.javaClass}") // class java.lang.String

    val aInt = 1
    val bInt = aInt as? String
    println(bInt)

    // 空安全调用 ?.
    val name: String? = null
    val nameResult = name ?: "default"
    println("nameResult 的值是: $nameResult")


    /**
     * 函数
     */
    fun method(a: Int, b: Int): Int {
        val sum = a + b
        return sum
    }

    // 函数的函数体如果只有一行代码，可以缩写为如下格式，省略掉大括号以及返回类型
    fun getAge() = 18

//    val user1 = User1(name = "小明", age = 13)
//    println("user1===>$user1")

    // 具名函数
    fun method2(name: String, age: Int = 20) {
        println("name=$name, age=$age")
    }
    // 调用
    method2(name = "tom") // 输出：name=tom, age=20
    val dataClassModel = DataClassModel("xiao", 33)
    println("${dataClassModel.age}, ${dataClassModel.name}")
    val singleton1 = Singleton.saySingleton()

}

// 简单单例类
object Singleton {
    var name = "单例模式"
    fun saySingleton() {
        println("我是单例模式。。。。")
    }
}

data class DataClassModel(var name: String, var age: Int)

class Outer {
    private var mName: String? = null
    private var mAge: Int = 0

    class Inner {
        init {
        }
    }
}

/**
 * 面向对象-构造函数
 */
open class User1 constructor(name: String) {
    private var mName: String? = null
    private var mAge: Int = 0
    fun user1Method() {
        println("name=$mName,  age=$mAge")
    }

    open fun sayHello() {
        print("hello~")
    }

    // 定义次构造函数,传递两个参数，并调用主构造函数
//    constructor(name: String, age: Int) : this(name) {
//        this.mAge = age
//    }

    init {
        this.mName = name
    }

    override fun toString() = "User1[mName=$mName, mAge=$mAge]"
}

class User2 constructor(name: String) : User1(name) {
    override fun sayHello() {
        super.sayHello()
    }
}