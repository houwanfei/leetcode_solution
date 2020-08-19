package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-19 16:41
 */
public class PredictWinner486Solution {
    /**
     * 递归
     * 计算在(i,j)比对手多得的分
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i=0; i<nums.length; i++) {
            Arrays.fill(memo[i], -10000000);
        }
        int res = helper(nums, 0, nums.length-1, memo);
        if (res >= 0) {
            return true;
        }
        return false;
    }

    private int helper(int[] nums, int i, int j, int[][] memo) {
        if (i==j) {
            return nums[i];
        }
        if (memo[i][j] > -10000000) {
            System.out.println("dp");
            return memo[i][j];
        }
        int res = Math.max(nums[i] - helper(nums, i+1, j, memo), nums[j] - helper(nums, i, j-1, memo));
        return memo[i][j] = res;
    }

    public static void main(String[] args) {
        PredictWinner486Solution solution = new PredictWinner486Solution();
        int N = 20;
//        int[] nums = new int[]{1, 5, 233, 7};
        int[] nums = new int[N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            nums[i] = random.nextInt(10000000);
            stringBuilder.append(nums[i]);
            if (i<N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.PredictTheWinner(nums));
    }
}
