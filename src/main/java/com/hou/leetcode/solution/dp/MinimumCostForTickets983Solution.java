package com.hou.leetcode.solution.dp;

public class MinimumCostForTickets983Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        for (int i=0; i<days.length; i++) {
            int cost1= i>0? costs[0] + dp[i-1]:costs[0];
            int j=i-1;
            while (j>=0) {
                if (days[i]-days[j]>6) {
                    j++;
                    break;
                }
                j--;
            }
            int cost2 = j>0?costs[1]+dp[j-1]:costs[1];
            j=i-1;
            while (j>=0) {
                if (days[i]-days[j]>29) {
                    j++;
                    break;
                }
                j--;
            }
            int cost3 = j>0?costs[2]+dp[j-1]:costs[2];
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        return dp[days.length-1];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1};
        int[] costs = new int[]{7,2,15};
        System.out.println(new MinimumCostForTickets983Solution().mincostTickets(days, costs));
    }
}
