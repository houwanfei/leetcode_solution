package com.hou.leetcode.solution.dp;

public class CombinationSumIV377Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j=1; j<=target; j++) {
            for (int i=0;i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new CombinationSumIV377Solution().combinationSum4(nums, 4));
    }
}
