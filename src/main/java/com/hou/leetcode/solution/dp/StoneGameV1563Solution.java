package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-08 10:49
 */
public class StoneGameV1563Solution {
    public int stoneGameV(int[] stoneValue) {
        int[] prefix = new int[stoneValue.length+1];
        for (int k=1; k<=stoneValue.length; k++) {
            prefix[k] = prefix[k-1] + stoneValue[k-1];
        }
        int[][] memo = new int[stoneValue.length][stoneValue.length];
        for (int i=0; i<stoneValue.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(stoneValue, prefix, 0, stoneValue.length-1, memo);
    }

    private int helper(int[] stoneValue, int[] prefix, int i, int j, int[][] memo) {
        if (j-i <= 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int sum = prefix[j+1]-prefix[i];
        int pre = 0;
        int max = 0;
        for (int k=i; k<j; k++) {
            pre += stoneValue[k];
            int left = helper(stoneValue, prefix, i, k, memo);
            int right = helper(stoneValue, prefix,k+1, j, memo);
            if (pre == (sum-pre)) {
                max = Math.max(max, Math.max(left, right) + pre);
            } else if (pre > (sum-pre)) {
                max = Math.max(max, right+(sum-pre));
            } else {
                max = Math.max(max, left+(pre));
            }
        }
        return memo[i][j]=max;
    }

    public static void main(String[] args) {
        StoneGameV1563Solution solution = new StoneGameV1563Solution();
//        int[] stones = new int[]{7,7,7,7,7,7,7};
        int N = 500;
        int[] stones = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        stringBuilder.append("[");
        for (int i=0; i<stones.length; i++) {
            stones[i] = random.nextInt(1000000)+1;
            stringBuilder.append(stones[i]);
            if (i<N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.stoneGameV(stones));
    }
}
