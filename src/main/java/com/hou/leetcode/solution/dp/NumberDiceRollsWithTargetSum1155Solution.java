package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-03 15:15
 */
public class NumberDiceRollsWithTargetSum1155Solution {

    /**
     * dp解法，至顶向下，假设d=2,f=6,target=7，想象第二颗骰子可以扔1-6，
     * 当扔1时，第一颗要7-1=6；
     * 2时，第一颗7-2=5；
     * ...
     * 6时，第一颗7-6=1
     * 因为只需要求出分别扔1-6时，前一次对应的点数就可以求出总的
     * @param d
     * @param f
     * @param target
     * @return
     */
    public int numRollsToTarget(int d, int f, int target) {
        Integer[][] memo = new Integer[d+1][target+1];
        return helper(d, f, target, memo);
    }

    private int helper(int d, int f, int target, Integer[][] memo) {
        if (target < 0 || d < 0) {
            return 0;
        }
        if (target == 0) {
            return d==0? 1:0;
        }
        if (d == 0) {
            return 0;
        }
        if (memo[d][target] != null) {
            return memo[d][target];
        }
        memo[d][target] = 0;
        for (int i=1; i<=f; i++) {
            memo[d][target] += helper(d-1, f, target-i, memo);
            memo[d][target] %= 1000000007;
        }
        return memo[d][target];
    }

    public static void main(String[] args) {
        NumberDiceRollsWithTargetSum1155Solution solution = new NumberDiceRollsWithTargetSum1155Solution();
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }
}
