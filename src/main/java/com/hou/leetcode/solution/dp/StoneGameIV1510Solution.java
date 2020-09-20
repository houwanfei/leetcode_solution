package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-09 12:29
 */
public class StoneGameIV1510Solution {
    /**
     * 思想：递归+备忘录
     *
     * 要求n的alice是否能赢，只需要判断i从1到n的平方数，是否存在一种让对手在n-i输的取法，如果存在那么alice在n就能赢
     * 因为要求是对手也是最优，因此bob也执行和alice一样的过程
     *
     * 递归调用层数太深，会栈溢出
     *
     * @param n
     * @return
     */
    public boolean winnerSquareGame(int n) {
        return helper(n, new Boolean[n+1]);
    }

    private boolean helper(int n, Boolean[] memo) {
        if (n==0) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        boolean res = true;
        int i=1;
        while ((i*i) <= n) {
            res &= helper(n-(i*i), memo);
            i++;
        }
        return memo[n] = !res;
    }

    /**
     * bottom to top 优化递归调用
     * @param n
     * @return
     */
    public boolean winnerSquareGame2(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        for (int i=1; i<= n; i++) {
            int k=1;
            boolean res = true;
            while ((k*k) <= i) {
                res &= dp[i-k*k];
                k++;
            }
            dp[i] = !res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StoneGameIV1510Solution solution = new StoneGameIV1510Solution();
        System.out.println(solution.winnerSquareGame(5));
        System.out.println(solution.winnerSquareGame2(5));
    }

}
