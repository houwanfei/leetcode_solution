package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-13 17:39
 */
public class OutBoundaryPaths576Solution {
    /**
     * 思路 dfs+备忘录
     * 要求(i,j)位置最多N步的路径数,只需要将上下左右四个方向的N-1步的路径数，很容易写出递归式
     * @param m
     * @param n
     * @param N
     * @param i
     * @param j
     * @return
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        return helper(m ,n, N, i, j, new HashMap<>());
    }

    private int helper(int m, int n, int N, int i, int j, Map<String, Integer> memo) {
        if (i == -1 || i==m || j==-1 || j==n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        String key = i +":" + j + ":" + N;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int mod = (int)Math.pow(10, 9) + 7;
        int top = helper(m, n, N-1, i-1, j, memo) % mod;
        int left = helper(m, n, N-1, i, j-1, memo) % mod;
        int right = helper(m,n,N-1, i, j+1, memo) % mod;
        int bottom = helper(m,n, N-1, i+1,j, memo) % mod;
        int res = (((top + left)% mod + right)% mod + bottom)% mod;
        memo.put(key, res);
        return res;
    }

    public int findPaths2(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        int mod = (int)Math.pow(10, 9) + 7;
        int[][][] dp = new int[m][n][N];

        for (int k=0; k<m; k++) {
            dp[k][0][0] = 1;
            dp[k][n-1][0] = dp[k][n-1][0]+1;
        }
        for (int l=0; l<n; l++) {
            dp[0][l][0] = dp[0][l][0]+1;
            dp[m-1][l][0] = dp[m-1][l][0]+1;
        }
        for (int o=1; o<N; o++) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    dp[k][l][o] = dp[k][l][0];
                    if (k != 0) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k - 1][l][o - 1]) % mod;
                    }
                    if (l != 0) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k][l - 1][o - 1]) % mod;
                    }
                    if (l != n - 1) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k][l + 1][o - 1]) % mod;
                    }
                    if (k != m - 1) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k + 1][l][o - 1]) % mod;
                    }
                }
            }
        }
        return dp[i][j][N-1];
    }

    public static void main(String[] args) {
        OutBoundaryPaths576Solution solution = new OutBoundaryPaths576Solution();
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.findPaths(1, 2, 50, 0, 0));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.findPaths2(1, 2, 50, 0, 0));
        System.out.println("end2:" + System.currentTimeMillis());
    }
}
