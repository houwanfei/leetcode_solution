package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-15 14:13
 */
public class MaxDotProductTwoSubsequences1458Solution {
    /**
     * 递归+备忘录
     *
     * 思想：要求nums1在i位置和nums2在j位置的最大值，因为是子序列，可以转换为以下三种情况
     * 1. i和j都用上 nums1[i]*nums2[j]+helper(i-1, j-1)
     * 2. 用i不用j helper(i, j-1)
     * 3. 用j不用i helper(i-1, j)
     * 取三种情况的最大值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int i=0; i<nums1.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return helper(nums1, nums2, nums1.length-1, nums2.length-1, memo);
    }

    private int helper(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i<0 || j<0) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        int max = Math.max(nums1[i]*nums2[j], Integer.MIN_VALUE);
        int res = helper(nums1, nums2, i-1, j-1, memo);
        if (res != Integer.MIN_VALUE) {
            max = Math.max(res+nums1[i] * nums2[j], max);
        }
        max = Math.max(max, helper(nums1, nums2, i, j-1, memo));
        max = Math.max(max, helper(nums1, nums2, i-1, j, memo));
        return memo[i][j]=max;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{-1,-1};
//        int[] nums2 = new int[]{1,1};
        int M = 500;
        int N = 400;
        int[] nums1 = new int[M];
        int[] nums2 = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        for (int i=0; i<M; i++) {
            int flag = random.nextInt(3)>1?1:-1;
            nums1[i] = flag * random.nextInt(1000);
            stringBuilder.append(nums1[i]);
            if (i<M-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[");
        for (int i=0; i<N; i++) {
            int flag = random.nextInt(3)>1?1:-1;
            nums2[i] = flag * random.nextInt(1000);
            stringBuilder1.append(nums2[i]);
            if (i<N-1) {
                stringBuilder1.append(",");
            }
        }
        stringBuilder1.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder1.toString());
        MaxDotProductTwoSubsequences1458Solution solution = new MaxDotProductTwoSubsequences1458Solution();
        System.out.println("begin" + System.currentTimeMillis());
        System.out.println(solution.maxDotProduct(nums1, nums2));
        System.out.println("end" + System.currentTimeMillis());
    }
}
