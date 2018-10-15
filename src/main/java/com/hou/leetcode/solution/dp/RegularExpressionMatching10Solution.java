package com.hou.leetcode.solution.dp;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 */
public class RegularExpressionMatching10Solution {


    /**
     * 思路：动态规划
     *
     *     0     a    a
     * 0 true false false
     * a false true false
     * * true true true
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean solution(String s, String p){
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        boolean[][] dp = new boolean[pc.length+1][sc.length+1];

        dp[0][0] = true;
        for (int i=1; i<=pc.length; i++){
            dp[i][0] = i>1 && pc[i-1] == '*' && dp[i-2][0];
        }
        for (int j=1;j<=sc.length; j++){
            dp[0][j] = false;
        }

        for (int i=1; i<=pc.length; i++){
            for (int j=1; j<=sc.length; j++){
                if (pc[i-1] == '*'){
                    //1.空串
                    //2.代表前边1个或多个字符
                    dp[i][j] = dp[i-2][j] || ((pc[i-2] == '.' || pc[i-2] == sc[j-1]) && dp[i][j-1]);
                } else {
                    dp[i][j] = (pc[i-1] == '.' || pc[i-1] == sc[j-1]) && dp[i-1][j-1];
                }
            }
        }
        for (int i=0; i<=pc.length; i++){
            for (int j=0; j<=sc.length; j++){
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return dp[pc.length][sc.length];
    }

    public static void main(String[] args) {
        RegularExpressionMatching10Solution solution = new RegularExpressionMatching10Solution();
        System.out.println(solution.solution("aa", "a*"));
    }
}
