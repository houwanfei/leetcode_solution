package com.hou.leetcode.solution.dp;

/**
 * @Description dp解法 转换为无限背包问题，n为背包的容量，1,2...n-1(到n-1是因为至少为两个数之和)为重量，价值是相乘
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(N)
 * @auther houwf
 * @create 2020-03-27 15:30
 */
public class IntegerBreak343Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            for (int j=i; j<=n; j++) {
                dp[j] = Math.max(dp[j], dp[j-i]*i);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new IntegerBreak343Solution().integerBreak(10));
    }
}
