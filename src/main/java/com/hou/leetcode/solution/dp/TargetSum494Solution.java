package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-25 14:17
 */
public class TargetSum494Solution {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0){
            return 0;
        }

        helper(nums, 0, S);
        return res;
    }

    private void helper(int[] nums, int start, int S) {
        if (start == nums.length) {
            if (S == 0) {
                res++;
            }
            return;
        }
        helper(nums, start+1, S+nums[start]);
        helper(nums, start+1, S-nums[start]);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        if (nums.length == 0){
            return 0;
        }
        int sum = 0;
        for (int num:nums) {
            sum += num;
        }
        if (S > sum || (sum+S) % 2 != 0) {
            return 0;
        }
        sum = (sum+S) / 2;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int num:nums) {
            for (int i=sum; i>=num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(new TargetSum494Solution().findTargetSumWays(nums, 3));
        System.out.println(new TargetSum494Solution().findTargetSumWays2(nums, 3));
    }
}
