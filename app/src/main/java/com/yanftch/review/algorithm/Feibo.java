package com.yanftch.review.algorithm;

public class Feibo {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 40; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            sum = arr[i];
        }
        System.out.println("sum====" + sum);
        int digui = 0;
//        for (int i = 0; i < 4; i++)
        digui = getFbByArr(9);

        System.out.println("digui====" + digui);

    }

    /**
     * 递归
     */
    private static int digui(int i) {
        if (i < 2) {
            return i == 0 ? 0 : 1;
        }
        return digui(i - 1) + digui(i - 2);
    }

    /**
     * 递归实现
     *
     * @param i
     * @return
     */
    private static int getFb(int i) {
        if (i < 2) {
            return i == 0 ? 0 : 1;
        }
        return getFb(i - 1) + getFb(i - 2);
    }


    /**
     * 数组实现
     */
    private static int getFbByArr(int i) {
        if (i < 2) {
            return i == 0 ? 0 : 1;
        }
        int[] arr = new int[i + 1];
        arr[0] = 0;
        arr[1] = arr[2] = 1;
        for (int j = 3; j <= i; j++) {
            arr[j] = arr[j - 1] + arr[j - 2];
        }
        return arr[i];
    }
}
