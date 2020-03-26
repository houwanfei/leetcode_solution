package com.hou.leetcode.solution.dp;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-26 14:10
 */
public class LongestPalindromicSubsequence516Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int[][] dp = new int[s.length()][s.length()];

        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(dp, s, 0, s.length()-1);
    }

    /**
     * 自顶向下 备忘录
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int helper(int[][] dp, String s, int i, int j) {
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if (i > j) {
            return 0;
        }
        if (i==j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(dp, s, i+1, j-1)+2;
        } else {
            dp[i][j] = Math.max(helper(dp, s, i, j-1), helper(dp, s, i+1, j));
        }
        return dp[i][j];
    }

    /**
     * 自底向上 填表法
     * @param s
     * @return
     */
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];

        for (int i=s.length()-1; i>=0; i--) {
            dp[i][i] = 1;
            for (int j=i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence516Solution().longestPalindromeSubseq("bbbabaaadddddaaa"));
        System.out.println(new LongestPalindromicSubsequence516Solution().longestPalindromeSubseq2("bbbabaaadddddaaa"));
    }
}
