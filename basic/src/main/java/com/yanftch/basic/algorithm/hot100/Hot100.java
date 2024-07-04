package com.yanftch.basic.algorithm.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 热题100道
 * 1.两数之和 {@link #twoSumBetter(int[], int)} ()}
 * 2.
 */
public class Hot100 {
    public static void main(String[] args) throws Exception {
        System.out.println("1.两数之和 ======>" + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("1.两数之和 【更优】======>" + Arrays.toString(twoSumBetter(new int[]{2, 7, 11, 15}, 9)));

    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * eg:
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */

    private static int[] twoSum(int[] nums, int target) throws Exception {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    private static int[] twoSumBetter(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(length - 1);
        for (int i = 0; i < length - 1; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
