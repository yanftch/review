package com.yanftch.review.javabasic;

import com.yanftch.review.javabasic.demo.Action;
import com.yanftch.review.javabasic.demo.Animal;
import com.yanftch.review.javabasic.demo.Dog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(100);
//        list.add("0");
        list.add(0, "0");
        list.add(0, "1");

        for (String s : list) {
            System.out.println("--------s-------" + s);
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(100, "");
        Dog dog = new Dog();
        System.out.println("---------------size=" + list.toArray().length);
        LinkedList linkedList = new LinkedList();
        linkedList.add(3, "33");


        System.out.println("---------------" + "a".equals("a") + dog.equals(dog));
        System.out.println("---------------");

        int a = 100;
        Integer b = 100;
        System.out.println(a == b);

        System.out.println("Hello World!");

        String rex = "^(http|https)://.*$";

        Action<? super Dog> action = new Action<Animal>(new Animal());
//        Action<Animal> action = new Action<Dog>(new Dog());

        Dog.Container<String, Integer> container = new Dog.Container("key", 1);


        Action.getSex("a");
        Class classString = new ArrayList<String>().getClass();
        Class classInt = new ArrayList<Integer>().getClass();
        System.out.println("classString-->" + classString);
        System.out.println("classInt-->" + classInt);


//        String a = "http:www.baidu.com";
//        String b = "https://www.baidu.com";
//        String c = "htt://www.baidu.com";
//        String d = "http://";
//        System.out.println(a.matches(rex));
//        System.out.println(b.matches(rex));
//        System.out.println(c.matches(rex));
//        System.out.println(d.matches(rex));
    }
}
