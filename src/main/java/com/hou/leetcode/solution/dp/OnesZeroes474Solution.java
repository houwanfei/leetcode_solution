package com.hou.leetcode.solution.dp;

/**
 * @Description 0-1背包问题，m，n分别是两个容量，数组的每个元素可以选择或不选择，然后求最长的子数组
 * @auther houwf
 * @create 2020-04-28 12:32
 */
public class OnesZeroes474Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m ==0 && n==0)) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<strs.length; i++) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int o=0; o<strs[i].length(); o++) {
                if (strs[i].charAt(o) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            for (int j=m; j>=0; j--) {
                for (int k=n; k>=0; k--) {
                    if (j >= zeroCount && k >= oneCount) {
                        if (dp[j][k] == 0) {
                            dp[j][k] = 1;
                        }
                        dp[j][k] = Math.max(dp[j][k], dp[j-zeroCount][k-oneCount]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(new OnesZeroes474Solution().findMaxForm(strs, 5, 5));
    }
}
