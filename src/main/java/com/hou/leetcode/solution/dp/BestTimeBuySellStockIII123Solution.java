package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-18 15:48
 */
public class BestTimeBuySellStockIII123Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i=0; i<prices.length; i++) {
            max = Math.max(max, solutionImprove(prices, 0, i)+solutionImprove(prices, i, prices.length));
        }
        return max;
    }

    public int solutionImprove(int[] prices, int s, int e){
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int i=s; i<e; i++){
            minPrice = Math.min(prices[i], minPrice);
            max = Math.max((prices[i] - minPrice), max);
        }
        return max;
    }

    /**
     * 思路：记录两次交易在i点的买卖利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[] ts1 = new int[2];
        int[] ts2 = new int[2];
        ts1[0] = -prices[0];
        ts2[0] = -prices[0];
        for (int i=1; i<prices.length; i++) {
            ts1[0] = Math.max(-prices[i], ts1[0]);
            ts1[1] = Math.max(ts1[1], ts1[0]+prices[i]);
            ts2[0] = Math.max(ts2[0], ts1[1]-prices[i]);
            ts2[1] = Math.max(ts2[1], ts2[0]+prices[i]);
        }
        return ts2[1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        BestTimeBuySellStockIII123Solution solution = new BestTimeBuySellStockIII123Solution();
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit2(prices));
    }
}
