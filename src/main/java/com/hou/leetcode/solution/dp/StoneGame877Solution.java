package com.hou.leetcode.solution.dp;

public class StoneGame877Solution {
    /**
     * 递归方式超时
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return helper(piles, 0, piles.length-1, 0, 0, 0);
    }

    private boolean helper(int[] piles, int start, int end, int a, int l, int who) {
        if (start > end) return a > l;
        if (who == 0) {
            return helper(piles, start+1, end, a+piles[start], l, 1)
                    || helper(piles, start, end-1, a+piles[end], l, 1);
        } else {
            return helper(piles, start+1, end, a, l+piles[start], 0)
                    || helper(piles, start, end-1, a, l+piles[end], 0);
        }
    }

    /**
     * dp[i][j]代表在i-j段比对手多的分
     * 如果取i，则dp[i][j] = piles[i]-dp[i+1][j]
     * 如果取j，则dp[i][j] = piles[j]-dp[i][j-1]
     * @param piles
     * @return
     */
    public boolean stoneGame2(int[] piles) {
        int[][] dp = new int[piles.length+1][piles.length+1];
        for (int i=piles.length-1; i>=0; i--) {
            for (int j = i+1; j<piles.length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][piles.length-1]>0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,7,1,10,6,3,5};
        System.out.println(new StoneGame877Solution().stoneGame2(nums));
    }
}
