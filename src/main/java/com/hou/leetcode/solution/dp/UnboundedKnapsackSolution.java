package com.hou.leetcode.solution.dp;

/**
 * @Description 无限背包问题
 * @auther houwf
 * @create 2020-03-25 17:41
 */
public class UnboundedKnapsackSolution {

    public int solution(int[] v, int[] w, int W) {
        if (v.length == 0 || w.length == 0) {
            return 0;
        }

        int[][] dp = new int[v.length+1][W+1];
        for (int j=0; j<=W; j++) {
            dp[0][j] = 0;
        }

        for (int i=0; i<v.length; i++) {
            for (int j=0; j<=W; j++) {
                if (j < w[i]) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i+1][j - w[i]]+v[i]);
                }
            }
        }
        return dp[v.length][W];
    }

    public static void main(String[] args) {
        int[] v = new int[]{4, 5, 3};
        int[] w = new int[]{3, 4, 2};
        System.out.println(new UnboundedKnapsackSolution().solution(v, w, 7));
    }
}
