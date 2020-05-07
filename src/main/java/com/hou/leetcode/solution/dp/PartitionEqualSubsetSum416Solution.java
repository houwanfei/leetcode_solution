package com.hou.leetcode.solution.dp;

/**
 * @Description 0/1背包问题，看是否能平分数组，只需要找到一个子数组能满足值为sum/2，所以背包的容量为sum/2，而每个数组可以选择或不选择
 * @auther houwf
 * @create 2020-03-25 13:23
 */
public class PartitionEqualSubsetSum416Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return false;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i>=num; i--) {
                if (dp[i-num]){
                    dp[i] = true;
                }
            }
        }
        return dp[sum];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(new PartitionEqualSubsetSum416Solution().canPartition(nums));
    }
}
