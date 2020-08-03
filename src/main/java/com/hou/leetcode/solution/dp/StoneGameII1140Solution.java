package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-03 10:35
 */
public class StoneGameII1140Solution {
    public int stoneGameII(int[] piles) {
        int[] sum = new int[piles.length+1];
        for (int i=1; i<=piles.length; i++) {
            sum[i] = sum[i-1] + piles[i-1];
        }
        return helper(sum, 1, 1, new HashMap<>());
    }

    /**
     * 思路：递归思想，返回值是当前选手的最大得分，因此当前选手的得分就为再本轮下标为i，M的取法中，取出每一种取法的最大值
     * 假设x为1，那么这一取法的得分为piles[i] + (sum(i+1,piles.length-1)-helper(max(M, x), i+x))
     * @param sum
     * @param M
     * @param i
     * @param memo
     * @return
     */
    private int helper(int[] sum, int M, int i, Map<String, Integer> memo) {
        if (sum.length-i <= 2*M) {
            return sum[sum.length-1] - sum[i-1];
        }
        if (memo.getOrDefault(i+":"+M, 0) > 0) {
            return memo.get(i+":"+M);
        }
        int up = Math.min(sum.length-1, i+2*M);
        int max = Integer.MIN_VALUE;
        for (int j=i; j<up; j++) {
            max = Math.max(max, sum[sum.length-1] - sum[i-1] - helper(sum, Math.max(M, (j-i+1)), j+1, memo));
        }
        memo.put(i+":"+M, max);
        return max;
    }

    public static void main(String[] args) {
        StoneGameII1140Solution solution = new StoneGameII1140Solution();
        int n= 100;
        int[] nums = new int[n];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<n; i++) {
            nums[i] = random.nextInt(10000);
            stringBuilder.append(nums[i] + ",");
        }
        System.out.println(stringBuilder.toString());
        System.out.println(solution.stoneGameII(nums));
    }
}
