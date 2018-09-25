package com.hou.leetcode.solution.dp;

import java.util.Arrays;

public class CoinChange322Soluton {

    /**
     * 动态规划
     * 先将币面值排序
     * @param coins
     * @param amount
     * @return
     */
    public int solution(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.sort(coins);

        for (int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE -1;
            for (int j = 0; j<coins.length && coins[j]<=i; j++){
                dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : Math.max(dp[amount], -1);
    }

    public static void main(String[] args) {
        CoinChange322Soluton soluton = new CoinChange322Soluton();
        int[] coins = {186,419,83,408};
        System.out.println(soluton.solution(coins, 6249));
    }
}
