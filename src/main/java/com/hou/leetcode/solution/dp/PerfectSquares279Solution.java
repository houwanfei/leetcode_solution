package com.hou.leetcode.solution.dp;

/**
 * @outhor ikan
 * @create 2018-11-01 14:38
 */
public class PerfectSquares279Solution {
    /**
     * 思路:存储前面计算过的值，避免重复计算
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n<=0){
            return 0;
        }
        int[] dp = new int[n+1];
        int pow_len = (int)Math.sqrt(n);
        int[] pow = new int[pow_len];
        for (int i=0; i<pow_len; i++){
            pow[i] = (int) Math.pow(i+1, 2);
        }
        dp[0] = 0;
        dp[1] = 1;
        int index = 2;
        while (index <= n){
            int min = index;
            for (int i=0; i<pow_len && index>=pow[i]; i++){
                min = Math.min(min, dp[index - pow[i]] + 1);
            }
            dp[index] = min;
            index++;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares279Solution solution = new PerfectSquares279Solution();
        System.out.println(solution.numSquares(12));
    }
}