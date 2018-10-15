package com.hou.leetcode.solution.dp;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 */
public class InterleavingString97Solution {
    /**
     * s1代表行，即在左边,s2代表列在上边
     * step1:分别求出以单个字符串构成s2的dp，即dp数组的第一行、第一列
     * step2:dp[i][j]的值可以从左边来，此时需要判断dp[i][j-1]的值和s2[j-1]和s3[i+j-1]是否匹配，如果从上边来就是判断s1和s3
     *
     * 即递推公式: dp[i][j] = (dp[i][j-1]&&s2[j-1] == s3[i+j-1]) || (dp[i-1][j]&&s1[i-1] == s3[i-1+j)
     *
     *
     *    0        d       b       b       c       a
     * 0 true 	false	false	false	false	false
     * a true 	false	false	false	false	false
     * a true	true	true	true	true	false
     * b false	true	true	false	true	false
     * c false	false	true	true	true	true
     * c false	false	false	true	false	true
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean solution(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        char[] s1c = s1.toCharArray();
        char[] s3c = s3.toCharArray();
        char[] s2c = s2.toCharArray();

        boolean[][] dp = new boolean[s1c.length+1][s2c.length+1];

        dp[0][0] = true;
        for (int i = 1; i<= s1c.length; i++){
            if (dp[i-1][0] && s1c[i-1] == s3c[i-1]){
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
            }
        }

        for (int j=1; j<=s2c.length; j++){
            if (dp[0][j-1] && s2c[j-1] == s3c[j-1]){
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }

        for (int i=1; i<=s1c.length; i++){
            for (int j=1; j<=s2c.length; j++){
                if ((dp[i][j-1] && s2c[j-1] == s3c[i + j -1])
                        || (dp[i-1][j] && s1c[i-1] == s3c[i -1 + j])){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1c.length][s2c.length];
    }

    public static void main(String[] args) {
        InterleavingString97Solution solution = new InterleavingString97Solution();
        System.out.println(solution.solution("", "b", "b"));
    }
}
