package com.hou.leetcode.solution.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-16 16:26
 */
public class FrogJump403Solution {
    public boolean canCross(int[] stones) {
        if (stones.length < 2 || stones[1] != 1) {
            return false;
        }
        return dfs(new HashMap<>(), stones, 1, 1);
    }

    /**
     * dfs
     * @param stones
     * @param index
     * @return
     */
    private boolean dfs(Map<String, Boolean> memo, int[] stones, int index, int k) {
        String key = index + "_" + k;
        if (index >= stones.length-1){
            return true;
        } else if (memo.get(key) != null) {
            return memo.get(key);
        }
        for (int i = index+1; i<stones.length; i++) {
            int len = stones[i] - stones[index];
            if (len >= k-1 && len <= k+1 && dfs(memo, stones, i, len)) {
                memo.putIfAbsent(key, true);
                return true;
            }
        }
        memo.putIfAbsent(key, false);
        return false;
    }

    public boolean canCross2(int[] stones) {
        if (stones.length < 2 || stones[1] != 1) {
            return false;
        }
        int[][] dp = new int[stones.length][stones.length];
        dp[0][1] = 1;
        for (int i=1; i<stones.length; i++) {
            for (int j=i-1; j>0; j--) {
                int k = stones[i]-stones[j];
                for (int m=0;m<j;m++) {
                    if (dp[m][j] > 0 && dp[m][j] >= k-1 && dp[m][j]<=k+1) {
                        dp[j][i] = k;
                    }
                }
            }
        }
        for (int i=0; i<stones.length; i++) {
            if (dp[i][stones.length-1]>0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(new FrogJump403Solution().canCross(stones));
    }
}
