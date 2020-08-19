package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-19 14:06
 */
public class GuessNumberHigherLowerII375Solution {
    /**
     * 根据题目可以得到当有两个数时选小的那个，当有3个数时选中间那个
     * 任意选择一个位置判断左右，选择大的那一边加上k，1<=k<=n，选择使得支付钱最少的
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        return helper(1, n, new int[n+1][n+1]);
    }

    private int helper(int s, int e, int[][] memo) {
        if (e - s <= 0) {
            return 0;
        } else if (e - s == 1) {
            return s;
        } else if (e - s == 2) {
            return s+1;
        }
        if (memo[s][e] != 0) {
            return memo[s][e];
        }
        int min = Integer.MAX_VALUE;
        for (int i=s; i<=e; i++) {
            min = Math.min(min, Math.max(helper(s,i-1, memo), helper(i+1, e, memo))+i);
        }
        return memo[s][e] = min;
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i=2; i<=n; i++) {
            for (int j=i-1; j>0; j--) {
                int ans = Integer.MAX_VALUE;
                for (int k=j+1; k<i; k++) {
                    ans = Math.min(ans, Math.max(dp[j][k-1], dp[k+1][i])+k);
                }
                dp[j][i] = j+1 == i?j:ans;//如果是j-i相邻，取小的j
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        GuessNumberHigherLowerII375Solution solution = new GuessNumberHigherLowerII375Solution();
        System.out.println("begin" + System.currentTimeMillis());
        System.out.println(solution.getMoneyAmount(1000));
        System.out.println("end" + System.currentTimeMillis());
        System.out.println(solution.getMoneyAmount2(1000));
        System.out.println("end2" + System.currentTimeMillis());
    }
}
