package com.hou.leetcode.solution.array;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-09 16:17
 */
public class NumberSubsequencesGivenSumCondition1498Solution {

    public int numSubseq(int[] nums, int target) {
        int mod = (int) (Math.pow(10, 9)+7);
        Arrays.sort(nums);
        int sumCount = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                if (nums[i]+nums[j] <= target) {
                    int len = j-i-1 < 0?0:j-i-1;
                    int sum = 1;
                    while (len>0) {
                        sum*=2;
                        sum %= mod;
                        len--;
                    }
                    sumCount = sumCount + sum;
                    sumCount %= mod;
                }
            }
        }
        return sumCount;
    }

    /**
     * 思路：题目要求的是子序列，那么一个区间内，数字必然在最小值和最大值之间，只要求出最小值最大值之间有多少元素，就可以知道有多少子序列为2^元素数
     * 通过排序，就可以求得最小值和最大值的位置差就是元素个数
     * @param nums
     * @param target
     * @return
     */
    public int numSubseq2(int[] nums, int target) {
        int[] pows = new int[nums.length];
        int mod = (int) (Math.pow(10, 9)+7);
        pows[0] = 1;
        for (int i=1; i<pows.length;i++) {
            pows[i] = (pows[i-1]*2)%mod;
        }
        Arrays.sort(nums);
        int sumCount = 0;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            if (nums[start]+nums[end] <= target) {
                sumCount = (sumCount + pows[end-start]) % mod;
                start++;
            } else {
                end--;
            }
        }
        return sumCount;
    }

    public static void main(String[] args) {
        NumberSubsequencesGivenSumCondition1498Solution solution = new NumberSubsequencesGivenSumCondition1498Solution();
        int[] nums = new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        System.out.println(solution.numSubseq2(nums, 22));
    }
}
