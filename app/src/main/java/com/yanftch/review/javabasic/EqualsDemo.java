package com.yanftch.review.javabasic;

/**
 * User : yanftch
 * Date : 2019-11-29
 * Time : 23:54
 * Desc : 验证 equals 和 ==  针对 Integer，String，int 的判断
 */

/*
### == 和 equals 的区别
先说结论：
① == 是操作符；equals 是 Object 的一个方法
② 对于基本数据类型，只能用 == 来比较，比较的是他们的实际的值
③ 对于引用数据类型，== 比较的是两者的内存地址；equals 比较的是内容(在不重写 equals 方法的前提下)
④ equals 方法默认是通过 == 来进行比较的！常用的 String,Integer 等类重写了该方法，具体自己处理

注意：== 判断的时候，只有两者是同一个 new 出来的对象，才会返回 TRUE，否则都是 FALSE，因为每次 new 都会开辟新空间

#### 数据类型
java 中的数据类型，分为两类：基本数据类型和引用数据类型
##### 基本数据类型
byte,short,char,int,long,float,double,boolean等

##### 引用数据类型
各类对象

 */
public class EqualsDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = "Hell" + "o";
        String s5 = "Hell" + new String("o");

        System.out.println("s1 == s2 的返回值是：" + (s1 == s2)); // TRUE
        System.out.println("s1.equals(s2) 的返回值是：" + s1.equals(s2)); // TRUE ,String 类重写了 equals()，实际是比较他们的值
        System.out.println("s1 == s3 的返回值是：" + (s1 == s3)); // FALSE
        System.out.println("s1.equals(s3) 的返回值是：" + s1.equals(s3)); // TRUE
        System.out.println("s1 == s4 的返回值是：" + (s1 == s4)); // TRUE
        System.out.println("s1.equals(s4) 的返回值是：" + s1.equals(s4)); // TRUE
        System.out.println("s1 == s5 的返回值是：" + (s1 == s5)); // FALSE
        System.out.println("s1.equals(s5) 的返回值是：" + s1.equals(s5)); // TRUE
        System.out.println("-----------------------------");

        int int1 = 100;
        Integer integer1 = 100;
        Integer integer2 = 100;
        Integer integer3 = 200;
        Integer integer4 = 200;
        System.out.println("integer3====" + integer3.intValue()  + "   integer4="+integer4.intValue());
        System.out.println("int1 == integer1 的返回值是：" + (int1 == integer1)); // TRUE
        System.out.println("integer1 == integer2 的返回值是：" + (integer1 == integer2)); // TRUE
        System.out.println("integer3 == integer4 的返回值是：" + (integer3 == integer4)); // FALSE
        System.out.println("integer1.equals(integer2) 的返回值是：" + (integer1.equals(integer2))); // TRUE
        System.out.println("integer3.equals(integer4) 的返回值是：" + (integer3.equals(integer4))); // TRUE
    }

}