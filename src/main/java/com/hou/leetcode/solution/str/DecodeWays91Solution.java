package com.hou.leetcode.solution.str;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-27 12:00
 */
public class DecodeWays91Solution {
    public int numDecodings(String s) {
        if (s == null || "".equals(s) || s.startsWith("0")){
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length+1];
        dp[0] = 1;
        dp[1] = chars[0] == '0'?0:1;
        for (int i=2; i<=chars.length; i++) {
            if (chars[i-1] != '0'){
                dp[i] += dp[i-1];
            }

            if (chars[i-2] == '1' || (chars[i-2] == '2' && chars[i-1] <= '6')){
                dp[i] += dp[i-2];
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        DecodeWays91Solution solution = new DecodeWays91Solution();
        String str = "110";
        System.out.println(solution.numDecodings(str));
    }
}
