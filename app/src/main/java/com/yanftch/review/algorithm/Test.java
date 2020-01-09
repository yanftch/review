package com.yanftch.review.algorithm;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Test {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 128, f4 = 128;
        Integer f5 = new Integer(200);
        Integer f6 = new Integer(200);

        System.out.println("开始");
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        System.out.println(f5 == f6);

        System.out.println(f1.equals(f2));
        System.out.println(f3.equals(f4));
        System.out.println(f5.equals(f6));
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("3");
//        System.out.println("list.size === " + list.size());
//        int[] arr = new int[]{1, 2, 3, 4, 3, 5, 3, 6, 3, 7, 3};
//        System.out.println("arr.size=" + arr.length);
//        Set set = new HashSet();
//        for (int i = 0; i < arr.length-1; i++) {
//            set.add(arr[i]);
//        }
//        System.out.println("set.size=" + set.size());

    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    private static String replaceChar(String string) {
        int length = string.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char b = string.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }

}
