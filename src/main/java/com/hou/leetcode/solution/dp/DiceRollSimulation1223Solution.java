package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-14 16:18
 */
public class DiceRollSimulation1223Solution {
    /**
     * 思路：深度优先搜索+备忘录
     * 注意备忘录不能只记录n，还要记录是当前值和其已经出现的次数
     * @param n
     * @param rollMax
     * @return
     */
    public int dieSimulator(int n, int[] rollMax) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<rollMax.length; i++) {
            max = Math.max(max, rollMax[i]);
        }
        return helper(n, rollMax, 0, 0, new int[n][6][max+1]);
    }

    private int helper(int n, int[] rollMax, int currNum, int currCount, int[][][] memo) {
        if (n==0) {
            if (currCount <= rollMax[currNum]) {
                return 1;
            }
            return 0;
        }
        if (currCount > rollMax[currNum]) {
            return 0;
        }
        if (memo[n-1][currNum][currCount] > 0) {
            return memo[n-1][currNum][currCount];
        }
        int sum = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i<6; i++) {
            if (i == currNum) {
                sum += helper(n-1, rollMax, i, currCount+1, memo);
                sum %= mod;
            } else {
                sum += helper(n-1, rollMax, i, 1, memo);
                sum %= mod;
            }
        }
        return memo[n-1][currNum][currCount] = sum;
    }

    public int dieSimulator2(int n, int[] rollMax) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<rollMax.length; i++) {
            max = Math.max(max, rollMax[i]);
        }
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] dp = new int[n][6];
        for (int i=0; i<6; i++) {
            dp[0][i] = 1;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<6; j++) {
                dp[i][j] = 0;
                for (int k=1; k<=rollMax[j]; k++) {
                    if (i-k==-1) {
                        dp[i][j] = (dp[i][j] + 1)%mod;
                        break;
                    }
                    for (int m=0; m<6; m++) {
                        if (m == j) {
                            continue;
                        }
                        dp[i][j] = (dp[i][j] + dp[i-k][m])%mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0; i<6; i++) {
            ans = (ans + dp[n-1][i])%mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        DiceRollSimulation1223Solution solution = new DiceRollSimulation1223Solution();
        int[] rollMax = new int[]{15,15,15,15,15,13};
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.dieSimulator(5000, rollMax));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.dieSimulator2(5000, rollMax));
        System.out.println("end2:" + System.currentTimeMillis());
    }
}
