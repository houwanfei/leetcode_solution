package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

public class PaintHouseIII1473Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] memo = new int[m][n+1][target+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<=n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        int res = helper(houses, cost, m-1, n, target, 0, 0, memo);
        return res == Integer.MAX_VALUE?-1: res;
    }

    private int helper(int[] houses, int[][] cost, int m, int n, int target, int last, int group, int[][][] memo) {
        if (m == -1) {
            if (group == target) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (group > target) {
            return Integer.MAX_VALUE;
        }
        if (memo[m][last][group] != -1) {
            return memo[m][last][group];
        }
        int[] h_cost = cost[m];
        int min = Integer.MAX_VALUE;
        if (houses[m] != 0) {
            if (houses[m] != last) {
                min = Math.min(min, helper(houses, cost, m-1, n, target, houses[m], group+1, memo));
            } else {
                min = Math.min(min, helper(houses, cost, m-1, n, target, houses[m], group, memo));
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == last) {
                    int res = helper(houses, cost, m - 1, n, target, last, group, memo);
                    if (res == Integer.MAX_VALUE) {
                        continue;
                    }
                    min = Math.min(min, res + h_cost[i - 1]);
                } else {
                    int res = helper(houses, cost, m - 1, n, target, i, group + 1, memo);
                    if (res == Integer.MAX_VALUE) {
                        continue;
                    }
                    min = Math.min(min, res + h_cost[i - 1]);
                }
            }
        }
        return memo[m][last][group] = min;
    }

    public static void main(String[] args) {
//        int[] houses = new int[]{0,0,0,0,0};
//        int[][] cost = new int[][]{{1,10},{10,1},{1,10},{10,1},{1,10}};
        int N = 100;
        int M = 10;
        int[] houses = new int[N];
        int[][] cost = new int[N][M];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<N; i++) {
            stringBuilder.append("[");
            for (int m=0; m<M; m++) {
                cost[i][m] = random.nextInt(10000);
                stringBuilder.append(cost[i][m]);
                if (m < M-1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            houses[i] = random.nextInt(10);
            sb.append(houses[i]);
            if (i < N-1) {
                stringBuilder.append(",");
                sb.append(",");
            }
        }
        sb.append("]");
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(sb.toString());
        PaintHouseIII1473Solution solution = new PaintHouseIII1473Solution();
        System.out.println(solution.minCost(houses, cost, 100, 10, 100));
    }
}
