package com.hou.leetcode.solution.dp;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-06 14:29
 */
public class BestTimeBuySellStockCooldown309Solution {

    /**
     * dp思路：每个价格i有三种状态，买，卖，冻结
     *
     * 买的值取决于前一个冻结状态的值
     * dp[i][0] = dp[i-1][2]
     * 卖的值取决于前边0-i-1买的值+价格差额
     * dp[i][1] = max(dp[j-1][0]+prices[i]-prices[j]) 0<=j<=i-1
     * 冻结的值取决于前边i-1冻结值和卖值的最大值
     * dp[i][2] = max(dp[i-1][1], dp[i-1][2])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];//0-买 1-卖 2-冻结

        for (int i=1; i<prices.length; i++) {
            dp[i][0] = dp[i-1][2];
            for (int j=i-1; j>=0; j--) {
                dp[i][1] = Math.max(dp[i][1], dp[j][0] + prices[i]-prices[j]);
            }
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][0],Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }

    /**
     * dp 思路：以第i天是否拥有股票来做状态，dp为第i天的利润
     * 状态转移
     * i有一支股票，那么这支股票可能是从i天买的，如果是今天买的那么前一天肯定是冻结的，也可能是从i-1天来的
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])
     * i没有股票，那么可能是i天卖了，也可能是前一天就没有
     * dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];//0-没有股票 1-有股票

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][1]+prices[1], dp[0][0]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i=2; i<prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public static void main(String[] args) {
        BestTimeBuySellStockCooldown309Solution solution = new BestTimeBuySellStockCooldown309Solution();
        int N = 100;
        int[] prices = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<N; i++) {
            prices[i] = random.nextInt(100);
            stringBuilder.append(prices[i]).append(",");
        }
        System.out.println(stringBuilder.toString());
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit2(prices));
    }
}
