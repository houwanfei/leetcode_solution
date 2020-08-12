package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-12 16:08
 */
public class LastStoneWeightII1049Solution {
    /**
     * 思路：根据题目，要求两个石头撞击，小的粉碎，大的重量还剩下减去小的
     * 抽象一下其实就是一个在数组元素前加正负号求和的问题，要求的和是大于等于0的最小值
     * 所以 主要问题是如何加正负号，这里用的是dfs搜索+备忘录
     *
     * 同理 可以转换为0/1背包问题，以sum/2为背包容量，找到它能容纳的最大一个子数组
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        return dfs(stones, stones.length-1, 0, new HashMap<>());
    }

    private int dfs(int[] stones, int i, int curr, Map<String, Integer> memo) {
        if (i<0) {
            return curr<0?Integer.MAX_VALUE:curr;
        }
        String key = i+":" +curr;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int res1= dfs(stones, i-1,curr+stones[i], memo);
        int res2 =dfs(stones, i-1,curr-stones[i], memo);
        memo.put(key, Math.min(res1, res2));
        return Math.min(res1, res2);
    }

    /**
     * 时间复杂度
     * @param stones
     * @return
     */
    public int lastStoneWeightII2(int[] stones) {
        int sum =0;
        for (int i=0; i<stones.length; i++) {
            sum += stones[i];
        }
        int target = sum >> 1;
        int[] dp = new int[target+1];
        for (int i=0; i<stones.length; i++) {
            //这里为什么要从j=target开始，因为如果从0开始，那么算到后边的时候前边的dp[]结果可能已经包含了stones[i]
            //但是这里是0/1背包，不能多次包含
            for (int j=target; j>=stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - target - dp[target];
    }


    public static void main(String[] args) {
        LastStoneWeightII1049Solution solution = new LastStoneWeightII1049Solution();
        int[] stones = new int[]{2,7,4,1,8,2,12,45,6,9,23,34,56,76,33,29,87,98,66,45,24,56,34,25,67,99,76,83,84,81};
//        int[] stones = new int[]{2,7,4};
        System.out.println("dfs begin:"+ System.currentTimeMillis());
        System.out.println(solution.lastStoneWeightII(stones));
        System.out.println("dfs end:"+ System.currentTimeMillis());
        System.out.println(solution.lastStoneWeightII2(stones));
        System.out.println("dp begin:"+ System.currentTimeMillis());
    }
}
