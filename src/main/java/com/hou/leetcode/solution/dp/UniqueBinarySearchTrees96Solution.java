package com.hou.leetcode.solution.dp;

public class UniqueBinarySearchTrees96Solution {
    public int numTrees(int n) {
        return countNumTrees(1, n);
    }

    private int countNumTrees(int i, int j) {
        if (i >= j) {
            return 1;
        }
        int count=0;
        for (int k=i; k<=j; k++) {
            count += countNumTrees(i, k-1) * countNumTrees(k+1, j);
        }
        return count;
    }

    private int countNumTrees(int n) {
        int[][] dp = new int[n+2][n+2];

        for (int i=0; i<=n+1; i++) {
            for (int j=0; j<=n+1; j++) {
                dp[i][j] = 1;
            }
        }

        for (int l=2; l<=n; l++) {
            for (int i=1; i<=(n-l+1); i++) {
                int j= i+l-1;
                dp[i][j] = 0;
                for (int k=i; k<=j; k++) {
                    dp[i][j] += dp[i][k-1]*dp[k+1][j];
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees96Solution solution = new UniqueBinarySearchTrees96Solution();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.countNumTrees(3));
    }
}
