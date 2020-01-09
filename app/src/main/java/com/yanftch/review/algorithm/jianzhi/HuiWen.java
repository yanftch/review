package com.yanftch.review.algorithm.jianzhi;

/**
 * User : yanftch
 * Date : 2019-12-05
 * Time : 11:05
 * Desc : [https://my.oschina.net/edisonOnCall/blog/3080207]
 */
public class HuiWen {
    public static void main(String[] args) {
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        String string = "abcdefedcbaf";
        System.out.println("字符串 [" + string + "] 是不是回文字符串？" + isHuiWen(string));
    }

    /**
     * 判断字符串是否是回文字符串
     */
    private static boolean isHuiWen(String string) {
        char[] charArray = string.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start++] != charArray[end--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 矩阵翻转 90 度
     * 其实就是原矩阵的横坐标变成了新矩阵的纵坐标；原矩阵的纵坐标变成了新矩阵的横坐标
     */
    private static int[][] juZhenChange(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        int dst = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++, dst--) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][dst] = matrix[i][j];
            }
        }
        return temp;
    }
}
