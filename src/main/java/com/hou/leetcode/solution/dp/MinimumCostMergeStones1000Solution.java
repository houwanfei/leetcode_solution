package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-09-23 15:58
 */
public class MinimumCostMergeStones1000Solution {
    public int mergeStones(int[] stones, int K) {
        if ((stones.length-1) % (K-1) != 0) {
            return -1;
        }
        int[] sums = new int[stones.length+1];
        for (int i=1; i<sums.length; i++) {
            sums[i] = sums[i-1]+stones[i-1];
        }
        return helper(sums, K, 0, stones.length-1);
    }

    private int helper(int[] sums, int K, int i, int j) {
        if ((j-i) < K-1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int m=i; m<j; m+=K-1) {
            min = Math.min(min, helper(sums, K, i, m)+helper(sums, K, m+1, j));
        }
        if ((j-i) % (K-1) == 0) {
            min = min + sums[j+1]-sums[i];
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumCostMergeStones1000Solution solution = new MinimumCostMergeStones1000Solution();
        int[] stones = new int[]{3,2,4,1,2};
        System.out.println(solution.mergeStones(stones, 2));
    }
}
