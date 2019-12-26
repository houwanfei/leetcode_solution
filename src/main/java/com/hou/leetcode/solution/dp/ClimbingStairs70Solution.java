package com.hou.leetcode.solution.dp;

public class ClimbingStairs70Solution {
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs70Solution solution = new ClimbingStairs70Solution();
        System.out.println(solution.climbStairs(1));
    }
}
