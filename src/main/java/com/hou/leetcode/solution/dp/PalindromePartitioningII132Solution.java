package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-24 10:27
 */
public class PalindromePartitioningII132Solution {
    /**
     * 思想：递归
     * 要求aab的最小切割满足都是回文串，只需要(a,ab),(aa,b)的最小切割
     * 一般化的，求s的最小切割转换为已k为位置进行不同位置的切割，最后求左右两边和的最小值
     * @param s
     * @return
     */
    public int minCut(String s) {
        int[][] memo = new int[s.length()][s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i==j || (j-i == 1) || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(s, 0, s.length()-1, memo, dp);
}

    private int helper(String s, int i, int j, int[][] memo, boolean[][] dp) {
        if (memo[i][j] != -1) {
//            System.out.println("dp");
            return memo[i][j];
        }
        if (dp[i][j]) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            min = Math.min(min, helper(s, i, k, memo, dp)+helper(s, k+1, j, memo, dp)+1);
        }
        return memo[i][j] = min;
    }

    /**
     * bottom to top
     * 求位置i的最小切割
     *            0 s(i,len)为回文
     *          /
     * dp[i] =
     *          \
     *           min(dp[k+1]+1) s(i,k)为回文 i<=k<len
     * @param s
     * @return
     */
    public int minCut2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        boolean[][] dp1 = new boolean[s.length()][s.length()];
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i==j || (j-i == 1) || dp1[i+1][j-1])) {
                    dp1[i][j] = true;
                }
            }
        }
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i=s.length()-1; i>=0; i--) {
            if (dp1[i][s.length()-1]) {
                dp[i][s.length()-1] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int k=s.length()-1; k>=i; k--) {
                    if (dp1[i][k]) {
                        min = Math.min(min, dp[k+1][s.length()-1]+1);
                    }
                }
                dp[i][s.length()-1] = min;
            }
        }
        return dp[0][s.length()-1];
    }

    /**
     * 空间复杂度优化
     * @param s
     * @return
     */
    public int minCut3(String s) {
        int[] dp = new int[s.length()];
        boolean[][] dp1 = new boolean[s.length()][s.length()];
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i==j || (j-i == 1) || dp1[i+1][j-1])) {
                    dp1[i][j] = true;
                }
            }
        }
        for (int i=s.length()-1; i>=0; i--) {
            if (dp1[i][s.length()-1]) {
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int k=s.length()-1; k>=i; k--) {
                    if (dp1[i][k]) {
                        min = Math.min(min, dp[k+1]+1);
                    }
                }
                dp[i] = min;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        PalindromePartitioningII132Solution solution = new PalindromePartitioningII132Solution();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<1500; i++) {
            stringBuilder.append((char)(97+random.nextInt(26)));
        }
        System.out.println(stringBuilder.toString());
        System.out.println("begin:" + System.currentTimeMillis());
//        System.out.println(solution.minCut(stringBuilder.toString()));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.minCut2(stringBuilder.toString()));
        System.out.println("end2:" + System.currentTimeMillis());
        System.out.println(solution.minCut3(stringBuilder.toString()));
    }
}
