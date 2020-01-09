package com.yanftch.review.javabasic;

/**
 * User : yanftch
 * Date : 2019-11-05
 * Time : 17:56
 * Desc :
 */
public class Outer {
    static {
        System.out.println("静态代码块....");
    }

    class InnerClass {
        {
            System.out.println("fei......静态内部类....");
        }
    }

    static class StaticInnerClass {
        static {
            System.out.println("静态内部类....");
        }

        static void show() {
            System.out.println("静态内部类de 静态方法....");
        }
    }

    static int[] share = new int[1];
    static int count = 0;

    public static void main(String[] args) {
//        Outer outer = new Outer();
        System.out.println("...........");
//        Outer.StaticInnerClass.show();

        new Thread(() -> {
            synchronized (share) {
                while (count <= 100) {
                    try {
                        share.notify();
                        System.out.println("thread 1 print " + count++);
                        share.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();


        new Thread(() -> {
            synchronized (share) {
                while (count <= 100) {
                    try {
                        share.notify();
                        System.out.println("thread 2 print " + count++);
                        share.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

    }
}
