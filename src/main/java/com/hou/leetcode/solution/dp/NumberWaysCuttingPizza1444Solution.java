package com.hou.leetcode.solution.dp;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-11 18:21
 */
public class NumberWaysCuttingPizza1444Solution {
    public int ways(String[] pizza, int k) {
        int[][] apples = new int[pizza.length+1][pizza[0].length()+1];
        for (int i=1; i<=pizza.length; i++) {
            for (int j=1; j<=pizza[0].length(); j++) {
                if (pizza[i-1].charAt(j-1) == 'A') {
                    apples[i][j] = apples[i-1][j] + apples[i][j-1] - apples[i-1][j-1] + 1;
                } else {
                    apples[i][j] = apples[i-1][j] + apples[i][j-1] - apples[i-1][j-1];
                }
            }
        }
        int[][][] memo = new int[apples.length][apples[0].length][k+1];
        for (int i=0; i<apples.length; i++) {
            for (int j=0; j<apples[0].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(apples, 1, 1, k, memo);
    }

    private int helper(int[][] apples, int i, int j, int k, int[][][] memo) {
        if (k == 1) {
            if (check(apples, apples.length-1, apples[0].length-1, i, j)) {
                return 1;
            }
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        int mod = (int) Math.pow(10, 9)+7;
        int sum = 0;
        for (int m=i+1; m<apples.length; m++) {
            if (check(apples, m-1, apples[0].length-1, i, j)) {
                sum = (sum + helper(apples, m, j, k - 1, memo))%mod;
            }
        }
        for (int m=j+1; m<apples[0].length; m++) {
            if (check(apples, apples.length-1, m-1, i, j)) {
                sum = (sum + helper(apples, i, m, k - 1, memo))%mod;
            }
        }
        return memo[i][j][k] = sum;
    }

    private boolean check(int[][] apples, int i, int j, int i1, int j1) {
        return apples[i][j] - apples[i][j1-1] - apples[i1-1][j] + apples[i1-1][j1-1] > 0;
    }

    public static void main(String[] args) {
        NumberWaysCuttingPizza1444Solution solution = new NumberWaysCuttingPizza1444Solution();
        String[] str = new String[]{"A..","AAA","..."};
        System.out.println(System.currentTimeMillis());
        System.out.println(solution.ways(str, 3));
        System.out.println(System.currentTimeMillis());
    }
}
