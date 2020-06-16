package com.hou.leetcode.solution.backtracking;

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
        return backtracking(stones, 1, 1);
    }

    /**
     * 回溯法，超时
     * @param stones
     * @param index
     * @param k
     * @return
     */
    private boolean backtracking(int[] stones, int index, int k) {
        if (index == stones.length-1){
            return true;
        } else if (index > stones.length-1) {
            return false;
        }

        boolean result = false;
        for (int i=k-1; i<=k+1; i++) {
            int j=index+1;
            while (j<stones.length-1 && (stones[index] + i) > stones[j]) {
                j++;
            }
            if (stones[index]+i == stones[j]) {
                System.out.println("index :" + index + " k:" + i + " j:" + j);
                result = result || backtracking(stones, j, i);
            }
        }
        return result;
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
        int[] stones = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(new FrogJump403Solution().canCross2(stones));
    }
}
