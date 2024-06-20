package com.yanftch.review.designpatterns;

public class Singleton {


    /**
     * 饿汉式
     */
//    private Singleton(){}
//
//    private static Singleton instance = new Singleton();
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**
     * 懒汉式-线程不安全
     */
//    private Singleton(){}
//
//    private static Singleton instance;
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 懒汉式-线程安全
     */
//    private Singleton(){}
//
//    private static Singleton instance;
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }


    /**
     * DCL 模式
     */
//    private Singleton(){}
//
//    private volatile static Singleton instance;
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class){
//               if (instance == null) {
//                   instance = new Singleton();
//               }
//            }
//        }
//        return instance;
//    }

    /**
     * 静态内部类
     */
    private Singleton(){}


    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }
}
