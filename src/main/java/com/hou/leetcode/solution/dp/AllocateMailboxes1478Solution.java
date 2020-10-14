package com.hou.leetcode.solution.dp;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-14 12:45
 */
public class AllocateMailboxes1478Solution {
    public int minDistance(int[] houses, int k) {
        int[][] memo = new int[houses.length][k+1];
        for (int i=0; i<houses.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        Arrays.sort(houses);
        return helper(houses, k, houses.length-1, memo);
    }

    private int helper(int[] houses, int k, int i, int[][] memo) {
        if (k==1) {
            return count(houses, 0, i);
        }
        if (memo[i][k] != -1) {
            return memo[i][k];
        }
        int min = Integer.MAX_VALUE;
        for (int j=i-1; j>=0; j--) {
            int res = helper(houses, k-1, j, memo);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(res + count(houses, j+1, i), min);
        }
        return memo[i][k]=min;
    }

    private int count(int[] houses, int i, int j) {
        if (i == j) {
            return 0;
        }
        int mid = (i+j)/2;
        int ans = 0;
        for (int k=i; k<=j; k++) {
            ans += Math.abs(houses[k]-houses[mid]);
        }
        return ans;
    }

    public static void main(String[] args) {
        AllocateMailboxes1478Solution solution = new AllocateMailboxes1478Solution();
        int[] houses = new int[]{2,3};
        System.out.println(solution.minDistance(houses, 1));
    }
}
