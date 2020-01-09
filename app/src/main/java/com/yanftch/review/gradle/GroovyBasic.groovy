println("开始学习 groovy...")
// 基本数据类型
int a = 1  //定义 int 型数据
String s1 = "a" // 定义 String 类型数据-通过双引号
String s2 = 'a' // 定义 String 类型数据-通过单引号
boolean bBoolean = false // 定义布尔类型数据
double d = 1 // 定义 double 类型数据
double d2 = 3.0
float f = 2
def b = 2  // 弱引用类型
def s = "a" // 弱引用类型，通过赋值表明类型

println("s == s1: " + (s == s1)) //true
println("s == s2: " + (s == s2)) //true
println("int 类型的 a = $a") // 1
println("def 类型的 b = $b") // 2
println(a.class) // 打印结果是：class java.lang.Integer
println(b.class) // 打印结果是：class java.lang.Integer
println(s.class) // 打印结果是：class java.lang.String

// 原始定义的是 int 类型的，因为是用 def 修饰的，所以后续可以赋值成其他类型的。算是优势吧
def oldParam = 10
println(oldParam.class) // 打印结果是：class java.lang.Integer
oldParam = "abc"
println(oldParam.class) // 打印结果是：class java.lang.String

// 字符串的定义以及操作
def gString = 'a'
println(gString.class) // class java.lang.String
def gString2 = """ab"""
println(gString2.class) // class java.lang.String
def gString3 = "abc"
println(gString3.class) // class java.lang.String

def hello = "hello ${gString}"
println(hello)
println(hello.class) // class org.codehaus.groovy.runtime.GStringImpl

// 新增方法
// String[int index]
def str = "abcdefg"
println(str.charAt(2)) // c
println(str[2]) // c
println(str[0..2]) // abc

// 减法
def strLong = "hello-world"
def strShort = "hello-"
def strNum = "123"
println("${strLong - strShort}") // 输出：world
// 倒序
println("${strLong.reverse()}") // 输出：dlrow-olleh
// 首字母大写
println("${strLong.capitalize()}") // 输出：Hello-world
// 是否是数字
println("a".isNumber()) // false
println("1".isNumber()) // true

// 数组/集合
// 定义一个数组
def arr = []

// 往数组中添加数据
arr[0] = "a"
arr[1] = "b"

println(arr) //[a,b]
// 根据索引值获取对应的值
println(arr[1]) // b
// 遍历数组
// 1.for 循环遍历
for (index in 0..arr.size() - 1) {
    println("arr 中的元素：${arr[index]}")
}
// 2.each{} 遍历
arr.each {
    println("arr 中的数据：${it}")
}

// map
// 空 map
def emptyMap = [:]
def map = ["key1": "value1", "key2": "value2"]

// 遍历 map
map.each { k, v ->
    println("map: key = $k  value = $v")
}


// 条件逻辑之 switch/case
def x = 100
def result
switch (x) {
    case 1:
        result = "result = 1"
        break
    case 100:
        result = "result = 100"
        break
    case "hello":
        result = "result = hello"
        break
    case BigDecimal:
        result = "result = big decimal"
        break
    default:
        result = "default"
}
println(result) // result = 100

// 循环逻辑-对范围的 for 循环
def sum = 0
for (i in 0..10) {
    sum += i
}
println("sum = $sum") // sum == 55

// 对 List 循环
def list1 = [1, 2, 3, 4, 5, 6]
for (i in list1) {
    println(i)
}

// 对 map 循环
def map1 = ["key1": "value1", "key2": "value2"]
for (i in map1) {
    println("遍历 map: key = ${i.key}  value = ${i.value}")
}

def testA
println("testA = $testA")

// 定义方法
def method1(param1, param2) {
    println("param1 = $param1, param2 = $param2")
}
// 调用方法
method1(1, 2) // 输出：param1 = 1, param2 = 2
method1 5, 6 // 输出：param1 = 5, param2 = 6

// 省略掉 return，默认选最后一行作为返回值
static def returnMethod(int param) {
    return 100 * param
}

returnMethod(2)

// 类/对象
User user = new User()
println("user.name = ${user.name}")
user.name = "xiaoming"
println("user.name = ${user.name}")
// 输出：user.name = null
//      user.name = xiaoming
class User {
    private String name
}
// 方法
static def getDate() {
    def date = new Date()
    return date.format("yyyy-MM-dd-hh-mm")
}

println(getDate())

println "闭包------start-------"

// 闭包
def b1 = {
    println "Hello Closure"
}

b1.call() // 输出：Hello Closure

// 有参数&返回值的闭包
def b2 = { key, value ->
    println "key = $key, value = $value"
    return "$key-$value"
}

def r = b2.call("id", 123) // 输出：key = id, value = 123
println(r) // 输出：id-123

// 闭包常见
def b3 = {
    println "this:$this"
    println "owner:$owner"
    println "delegate:$delegate"
}
b3.call()
// 打印结果：
//this:ideaGroovyConsole@1b919693
//owner:ideaGroovyConsole@1b919693
//delegate:ideaGroovyConsole@1b919693

class InnerClass {
    def innerB1 = {
        println "InnerClass.innerB1  this:$this"
        println "InnerClass.innerB1  owner:$owner"
        println "InnerClass.innerB1  delegate:$delegate"
    }
}

InnerClass innerClass = new InnerClass()
innerClass.innerB1.call()

println "闭包------end-------"


// IO 操作
def file = new File("../file.txt")
file.eachLine { line, lineNo ->
    println "lineNo=$lineNo     $line"
}


/**
 * 进阶
 */
// 数据结构之列表
def javaList = new ArrayList() // java 中定义集合的方式

def list = [1, 2, 3]
println list.class // 输出：class java.util.ArrayList

// 定义数组的两种方式：
// 第一种：使用[as]关键字，将 List 强转成数组
def arr1 = [1, 2, 3] as int[]
// 第二种：使用强类型直接定义
int[] arr2 = [1, 2, 3]

println arr1.class // 输出：class [I
println arr2.class // 输出：class [I

// 定义一个 LinkedList
def linkedList1 = [1, 2, 3] as LinkedList
LinkedList linkedList2 = [1, 2, 3]
println linkedList1.class // 输出：class java.util.LinkedList
println linkedList2.class // 输出：class java.util.LinkedList

// 增加-add()
def addList = [1, 2, 3]
addList.add(4) //在最后添加一个元素
addList.add(0, 0) // 在指定位置添加元素
println addList // [0, 1, 2, 3, 4]

// 增加-leftShift
addList.leftShift(5)
addList << 6
println addList // [0, 1, 2, 3, 4, 5, 6]

// 增加-直接使用加号
addList = addList + 7
println addList // [0, 1, 2, 3, 4, 5, 6, 7]

def deleteList = ["A", "B", "C"]
// 删除-使用 remove
//deleteList.remove("C") // 输出：[A, B]
//deleteList.remove(0) // 输出：[B]
//deleteList.removeAt(0) // 内部实际调用了上边的 remove(index)方法

// 删除-使用减号
deleteList = deleteList - "C"
println deleteList

// 查找-get()方法
def searchList = [1, 2, 3, 4, 5]
println "第二个元素是：${searchList.get(2 - 1)}" // 第二个元素是：2
println "第三个元素是：${searchList[3 - 1]}" // 第二个元素是：3

//查找-find 返回第一个符合条件的元素
def findResult = searchList.find { it ->
    (it % 3) == 0
}
println "findResult = $findResult" // findResult = 3
//查找-返回所有符合条件的元素
println searchList.findAll { it ->
    (it % 2) == 0
} // [2, 4]
//查找-any: 只要有符合条件的就返回TRUE
println searchList.any { it ->
    (it % 3) == 0
} // true
//查找-every：所有元素都符合条件才返回 TRUE
println searchList.every { it ->
    (it % 2) == 0
} // false
//查找-返回最小/大值
println searchList.min() // 1
println searchList.max() // 5
// 查找-count：返回符合条件的元素的个数
def count = searchList.count { it ->
    (it % 2) == 0
}
println "对 2 取余为 0 的个数为：$count" // 2个


println "数据结构之列表------------------>"
/**
 * 数据结构之映射
 */
def defMap = ["name": "Tom", "age": 18, "man": true, "money": 200.56]
// 根据 key 获取 value
println "key为 name 的 value 是：${defMap.name}"
println "key为 name 的 value 是：${defMap.get("name")}"
println "key为 name 的 value 是：${defMap["name"]}"
println "key为 name 的 value 是：${defMap.getAt("name")}"
//上述 4 种方法的输出都是： key为 name 的 value 是：Tom

// 添加元素
defMap.put("height", 100)
defMap["birthday"] = "2011-11-11"
defMap.father = "Jack"

// 删除元素
defMap.remove("birthday")

// 遍历
defMap.each {
    println "key=${it.key}, value=${it.value}"
}
defMap.eachWithIndex { Map.Entry<String, Serializable> entry, int i ->
    println "i=$i, key=${entry.key}, value=${entry.value}"
}




println defMap // [name:Tom, age:18, man:true]
println defMap.getClass() // class java.util.LinkedHashMap












