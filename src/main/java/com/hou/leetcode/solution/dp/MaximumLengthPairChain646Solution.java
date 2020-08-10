package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-07 16:57
 */
public class MaximumLengthPairChain646Solution {

    /**
     * dp思想：减少计算，按pairs先排序
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int max = 0;
        for (int i=1; i<pairs.length; i++) {
            dp[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{
                {-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}
        };
        MaximumLengthPairChain646Solution solution = new MaximumLengthPairChain646Solution();
        System.out.println(solution.findLongestChain(pairs));
    }
}
