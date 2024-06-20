package com.yanftch.review.algorithm;

public class Search {
    static int[] baseArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100}; // 20个数
    static int[] base1 = {21, 1, 56, 2, 34, 3, 45, 4, 12, 5, 22, 6, 55, 7, 78, 8, 9, 11, 33, 92, 44, 66, 31, 77, 109, 88, 15, 99, 200, 100}; // 30个数

    public static void main(String[] args) {
        System.out.println("折半查找：" + binarySearch(baseArray, 44));
//        System.out.println("插值查找：" + Insert_Search(baseArray, 44));
    }

    /**
     * 折半查找/二分查找
     * 注意：必须是有序数组！
     * 思想：针对有序数组，可以先查询数组中间的数字，如果中间的数字大于待查找元素，再去查找数组的另一半，找前边
     * 一半的中间值
     * 步骤：
     * ①如果数组是无序，则选择合适的排序算法进行排序
     * ②定义开始下标 start=0，结束下标 end=arr.length-1
     * ③确定中间元素的索引值 middle=(start+end) >> 1, 位移运算，其实就是除以 2
     * ④判断 middle 下标对应的值与目标值，若 middle 对应的值大于目标值，则将end 移动到(middle-1)的位置；
     * 若 middle 对应的值小于目标值，则将 start 移动到(middle+1)的位置
     * ⑤继续求中间变量...
     * ⑥移动过程中，发现 start<end，则结束循环
     * <p>
     * 时间复杂度：O(logn)
     */
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        while (start <= end) {
            int middle = (start + end) >>> 1; // 其实就是除以 2，取中间索引值
            int middleVal = arr[middle]; // 中间索引对应的值
            if (middleVal < target) { // 表明目标值在中间值的右边了，所以移动 start
                start = middle + 1;
            } else if (middleVal > target) { // 表明目标值在中间值的左边了，所以移动 end
                end = middle - 1;
            } else {
                index = middle;
                break;
            }
        }
        return index;
    }


    /**
     * 折半查找
     * 时间复杂度：O(logn)
     * 适应于 有序表顺序存储
     */
    private static int Binary_Search(int[] arr, int key) {
        int low, middle, height; // 记录索引
        int length = arr.length;
        low = 0;
        height = length;
        while (low <= height) {
            middle = (low + height) / 2;
            System.out.println("middle=" + middle);
            if (key < arr[middle]) {
                height = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else return middle;
        }
        return 0;
    }

    /**
     * 插值查找
     * 折半查找的改进，
     */
    private static int Insert_Search(int[] arr, int key) {

        int low, middle, height; // 记录索引
        int length = arr.length;
        low = 1;
        height = length - 1;
        while (low <= height) {
            middle = low + (height - low) * (key - arr[low]) / (arr[height] - arr[low]); // todo 插值查找的区别
            System.out.println("middle=" + middle);
            if (key < arr[middle]) {
                height = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else return middle;
        }
        return 0;
    }
}
