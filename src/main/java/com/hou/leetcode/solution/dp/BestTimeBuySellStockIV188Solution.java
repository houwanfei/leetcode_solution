package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-18 16:56
 */
public class BestTimeBuySellStockIV188Solution {
    /**
     * 和BestTimeBuySellStockIII123一样的处理方式，只是交易次数从2变成k，
     * 注意题目没有标明k的范围可能很大，远大于prices，因此加个限制取min(k,prices.length)
     *
     * 一个小优化：如果k > prices.length/2+1,则可以随意买卖，
     * 只需要将数组prices[i] - prices[i-1]的和累加，当然要满足prices[i] > prices[i-1]
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }

        if (k > prices.length/2+1) {
            int sum = 0;
            for (int i=1; i<prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    sum += (prices[i] - prices[i-1]);
                }
            }
            return sum;
        }

        int[][] dp = new int[k+1][2];
        for (int i=1; i<=k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i=0; i<prices.length; i++) {
            for (int j=1; j<=k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]-prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0]+prices[i]);
            }
        }
        return dp[k][1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        BestTimeBuySellStockIV188Solution solution = new BestTimeBuySellStockIV188Solution();
        System.out.println(solution.maxProfit(1, prices));
    }
}
