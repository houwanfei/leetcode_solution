package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-21 17:24
 */
public class ProfitableSchemes879Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        return helper(G, P, group, profit, 0, 0, 0);
    }

    private int helper(int G, int P, int[] group, int[] profit, int i, int currG, int currP) {
        if (currG > G) {
            return 0;
        }
        if (i > profit.length) {
            if (currP>= P) {
                return 1;
            }
            return 0;
        }
        int res = helper(G, P, group, profit,i+1, currG, currP);
        res += helper(G, P, group, profit,i+1, currG+group[i-1], currP+profit[i-1]);
        return res;
    }

    public static void main(String[] args) {
        ProfitableSchemes879Solution solution = new ProfitableSchemes879Solution();
        int[] group = new int[]{};
        int[] profit = new int[]{};
        System.out.println(solution.profitableSchemes());
    }
}
