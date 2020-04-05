package com.hou.leetcode.solution.dp;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-26 15:17
 */
public class LongestCommonSubSequence1143Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0
                || text2 == null || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i=0; i<text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(dp, text1, text2, text1.length()-1, text2.length()-1);
    }

    /**
     * 自顶向下 备忘录
     * @param dp
     * @param text1
     * @param text2
     * @param i
     * @param j
     * @return
     */
    private int helper(int[][] dp, String text1, String text2, int i, int j) {
        if (i<0 || j < 0){
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = helper(dp, text1, text2, i-1, j-1) + 1;
        } else {
            dp[i][j] = Math.max(helper(dp, text1, text2, i, j-1), helper(dp, text1, text2, i-1, j));
        }
        return dp[i][j];
    }

    /**
     * 自底向上 填表法 从1,1开始填表
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text1.length() == 0
                || text2 == null || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i=0; i<=text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i=0; i<=text2.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<=text1.length(); i++) {
            for (int j=1; j<=text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubSequence1143Solution().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LongestCommonSubSequence1143Solution().longestCommonSubsequence2("abcde", "ace"));
    }
}
