package com.hou.leetcode.solution.dp;

import java.util.Random;

public class BestTimeBuySellStockTransactionFee714Solution {
    /**
     * 思路：dp，用dp存放当前是否有股票的利润
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1]-prices[0]-fee);
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][1] + prices[1]-fee, dp[0][0]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i=2; i<prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i]-fee, dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }



    public static void main(String[] args) {
        BestTimeBuySellStockTransactionFee714Solution solution = new BestTimeBuySellStockTransactionFee714Solution();
        int N = 50000;
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        for (int i=0; i<N; i++) {
            nums[i] = random.nextInt(49999)+1;
            stringBuilder.append(nums[i]).append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.maxProfit(nums, 2));
    }
}
