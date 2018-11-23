package com.hou.leetcode.solution.dp;

/**
 * @outhor ikan
 * @create 2018-11-23 11:36
 */
public class MaximumProductSubarray152Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int currMax;
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            currMax = Math.max(Math.max(preMax*nums[i], preMin*nums[i]), nums[i]);
            preMin = Math.min(Math.min(preMax*nums[i], preMin*nums[i]), nums[i]);
            preMax = currMax;
            max = Math.max(currMax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        MaximumProductSubarray152Solution solution = new MaximumProductSubarray152Solution();
        solution.maxProduct(nums);
    }
}