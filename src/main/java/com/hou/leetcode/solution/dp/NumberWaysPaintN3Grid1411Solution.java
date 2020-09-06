package com.hou.leetcode.solution.dp;

public class NumberWaysPaintN3Grid1411Solution {
    public int numOfWays(int n) {
        return helper(n, 0, 0, 0, new int[n+1][4][4][4]);
    }

    private int helper(int n, int i1, int i2, int i3, int[][][][] memo) {
        if (n==0) {
            return 1;
        }
        if (memo[n][i1][i2][i3] > 0) {
            return memo[n][i1][i2][i3];
        }
        int res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 1; i<4; i++) {
            if (i == i1) {
                continue;
            }
            for (int m = 1; m<4; m++) {
                if (m ==i || m==i2) {
                    continue;
                }
                for (int k = 1; k<4; k++) {
                    if (k==m || k==i3) {
                        continue;
                    }
                    res = (res + helper(n-1, i, m, k, memo))%mod;
                }
            }
        }
        return memo[n][i1][i2][i3]=res;
    }

    public static void main(String[] args) {
        NumberWaysPaintN3Grid1411Solution solution = new NumberWaysPaintN3Grid1411Solution();
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.numOfWays(3));
        System.out.println("end:" + System.currentTimeMillis());
    }
}
