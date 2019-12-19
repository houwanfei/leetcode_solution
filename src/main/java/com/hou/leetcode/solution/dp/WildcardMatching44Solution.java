package com.hou.leetcode.solution.dp;

/**
 * 动态规划，？只能匹配当前字符，因此看dp表左上方，*可以匹配空和任意字符，因此可以看左上方 上方 左前方三个方向
 */
public class WildcardMatching44Solution {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        boolean[][] dp = new boolean[pc.length+1][sc.length + 1];

        dp[0][0] = true;
        for (int i=1; i<=sc.length; i++) {
            dp[0][i] = false;
        }
        for (int i=1; i<=pc.length; i++) {
            dp[i][0] = dp[i-1][0] && pc[i-1] == '*';
        }
        for (int i=1; i<=pc.length; i++) {
            for (int j=1; j<=sc.length; j++) {
                if (pc[i-1] == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                } else if (pc[i-1] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] && (pc[i-1] == sc[j-1]);
                }
            }
        }
        return dp[pc.length][sc.length];
    }

    public static void main(String[] args) {
        WildcardMatching44Solution solution = new WildcardMatching44Solution();
//        System.out.println(solution.isMatch("adceb", "*a*b"));
//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "*"));
//        System.out.println(solution.isMatch("cb", "?b"));
        System.out.println(solution.isMatch("a", "a*"));
    }
}
