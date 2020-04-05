package com.hou.leetcode.solution.sliding_window;

public class MinimumSizeSubarraySum209Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - j+1);
                sum -= nums[j++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new MinimumSizeSubarraySum209Solution().minSubArrayLen(15, nums));
    }
}
