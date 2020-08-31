package com.hou.leetcode.solution.dp;


import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-28 10:52
 */
public class ShortestCommonSupersequence1092Solution {
    /**
     * 思路：转换为求两个字符串最长公共子序列，然后从后向前遍历查找最长公共子序列的元素，
     * 如果是在路径上的字符是最长序列的元素那么只加入一次，如果不是那就加入字符串
     * 类似快速排序的merge过程，注意最后要判断两个字符是否遍历到头
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i=0; i<str2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i=0; i<str1.length(); i++) {
            dp[i][0] = 0;
        }
        //求最长公共子序列
        for (int i=1; i<=str1.length(); i++) {
            for (int j=1; j<=str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int i=str1.length(),j=str2.length();
        StringBuilder sb = new StringBuilder();
        while (i>0 && j>0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.insert(0, str1.charAt(i-1));
                i = i-1;
                j = j-1;
            } else if (dp[i][j] == dp[i-1][j]) {
                sb.insert(0, str1.charAt(i-1));
                i = i-1;
            } else {
                sb.insert(0, str2.charAt(j-1));
                j=j-1;
            }
        }
        while (i>0) {
            sb.insert(0, str1.charAt(i-1));
            i--;
        }
        while (j>0) {
            sb.insert(0, str2.charAt(j-1));
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence1092Solution solution = new ShortestCommonSupersequence1092Solution();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int M=1000,N=700;
        Random random = new Random();
        for (int i=0;i<M; i++) {
            sb1.append((char)(random.nextInt(26)+97));
        }
        for (int i=0;i<N; i++) {
            sb2.append((char)(random.nextInt(26)+97));
        }
//        System.out.println(solution.shortestCommonSupersequence("abac", "cab"));
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(solution.shortestCommonSupersequence(sb1.toString(), sb2.toString()));
    }
}
