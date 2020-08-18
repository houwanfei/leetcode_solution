package com.hou.leetcode.solution.dp;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-18 11:50
 */
public class JumpGameV1340Solution {
    /**
     * 简单思路：递归+备忘录 效率有点低
     * @param arr
     * @param d
     * @return
     */
    public int maxJumps(int[] arr, int d) {
        int max = 1;
        int[] memo = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            max = Math.max(max, helper(arr, d, i, memo));
        }
        return max;
    }

    private int helper(int[] arr, int d, int index, int[] memo) {
        if (memo[index] > 0) {
            return memo[index];
        }
        int maxAns = 1;
        int max = Integer.MIN_VALUE;
        for (int i=index-1; i>=index-d && i>=0; i--) {
            if (arr[i] < arr[index] && arr[index] > max) {
                maxAns = Math.max(maxAns, helper(arr, d, i, memo)+1);
            }
            max = Math.max(arr[i], max);
        }

        max = Integer.MIN_VALUE;
        for (int i=index+1; i<=index+d && i< arr.length; i++) {
            if (arr[i] < arr[index] && arr[index] > max) {
                maxAns = Math.max(maxAns, helper(arr, d, i, memo)+1);
            }
            max = Math.max(arr[i], max);
        }
        return memo[index] = maxAns;
    }


    public static void main(String[] args) {
        JumpGameV1340Solution solution = new JumpGameV1340Solution();
        int N = 1000;
        int[] arr = new int[]{6};
        int[] nums = new int[N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            nums[i] = random.nextInt(100000);
            stringBuilder.append(nums[i]);
            if (i < N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.maxJumps(nums, 400));

    }
}
