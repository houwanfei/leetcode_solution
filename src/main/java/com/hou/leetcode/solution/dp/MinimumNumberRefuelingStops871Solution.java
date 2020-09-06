package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-27 13:58
 */
public class MinimumNumberRefuelingStops871Solution {

    /**
     * 递归复杂度太高，想做备忘录，空间复杂度不允许
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (startFuel >= target) {
                return 0;
            } else {
                return -1;
            }
        }
        int fuel = startFuel;
        for (int i = 0; i < stations.length; i++) {
            if (fuel < stations[i][0]) {
                return -1;
            }
            fuel += stations[i][1];
        }
        if (fuel < target) {
            return -1;
        }
        int res = helper(startFuel, stations, stations.length - 1, 0, target);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private int helper(int startFuel, int[][] stations, int i, int count, int need) {
        if (i==-1) {
            if (startFuel > need) {
                return count;
            }
            return Integer.MAX_VALUE;
        }
        System.out.println("i:"+i+"need:"+need);
        //加油
        int res1 = helper(startFuel, stations, i-1, count+1, need-stations[i][1]);
        //不加油
        int res2 = helper(startFuel, stations, i-1, count, need);
        return Math.min(res1, res2);
    }

    /**
     * dp思想：dp状态转移定义很难想到
     * 思路：用dp存放加油i次可以达到的最大距离
     *
     * 遍历dp数组，找到第一个距离大于等于target的i
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        long[] dp = new long[stations.length+1];
        dp[0] = startFuel;
        for (int i=1; i<=stations.length; i++) {
            for (int j=i; j>0&&dp[j-1] >= stations[i-1][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j-1]+stations[i-1][1]);
            }
        }
        for (int i=0; i<=stations.length; i++) {
            if (dp[i]>=target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumNumberRefuelingStops871Solution solution = new MinimumNumberRefuelingStops871Solution();
        int[][] stations = new int[][]{
                {14,123},{145,203},{344,26},{357,68},{390,35},{478,135},{685,108},{823,186},{934,217},{959,80}
        };
        System.out.println(solution.minRefuelStops2(1000, 299, stations));
    }
}
