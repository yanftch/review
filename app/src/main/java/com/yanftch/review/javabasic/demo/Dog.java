package com.yanftch.review.javabasic.demo;

public class Dog extends Animal {


    public static class Container<K, V> {
        private K key;
        private V value;

        public Container(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}