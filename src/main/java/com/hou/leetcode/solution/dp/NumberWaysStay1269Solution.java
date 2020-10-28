package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-27 14:34
 */
public class NumberWaysStay1269Solution {

    /**
     * 注意：虽然arrLen很大，但是其实是误导，要想从0出发回到0，其实最远能到达的地方是steps/2
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        int[][] memo = new int[steps+1][steps];
        for (int i=0; i<=steps; i++) {
            for (int j=0; j<steps; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(steps, arrLen, 0, 0, memo);
    }

    private int helper(int steps, int arrLen, int pos, int step, int[][] memo) {
        if (step == steps) {
            return pos == 0?1:0;
        }
        if (memo[step][pos] != -1) {
            return memo[step][pos];
        }
        int mod = (int)(Math.pow(10, 9))+7;
        int ans = helper(steps, arrLen, pos, step+1, memo);
        if (pos > 0) {
            ans = (ans +helper(steps, arrLen, pos-1, step+1, memo))%mod;
        }
        if (pos < arrLen-1) {
            ans = (ans +helper(steps, arrLen, pos+1, step+1, memo))%mod;
        }
        return memo[step][pos]=ans;
    }

    public static void main(String[] args) {
        NumberWaysStay1269Solution solution = new NumberWaysStay1269Solution();
        System.out.println(solution.numWays(500, 148488));
    }
}
