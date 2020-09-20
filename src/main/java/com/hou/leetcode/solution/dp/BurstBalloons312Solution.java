package com.hou.leetcode.solution.dp;

public class BurstBalloons312Solution {
    public int maxCoins(int[] nums) {
        if (nums ==null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
    }

    private int helper(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = i; k <= j; k++) {
            int left = i - 1 < 0 ? 1 : nums[i - 1];
            int right = j + 1 >= nums.length ? 1 : nums[j + 1];
            int sum = helper(nums, i, k-1, memo) + helper(nums, k+1, j, memo) + left*nums[k]*right;
            max = Math.max(max, sum);
        }
        return memo[i][j]=max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        BurstBalloons312Solution solution = new BurstBalloons312Solution();
        System.out.println(solution.maxCoins(nums));
    }
}
