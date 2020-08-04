package com.hou.leetcode.solution.dp;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-04 17:52
 */
public class MinimumFallingPathSumII1289Solution {
    /**
     * 递归+备忘录效率不高
     * @param arr
     * @return
     */
    public int minFallingPathSum(int[][] arr) {
        if (arr.length == 1) {
            return arr[0][0];
        }
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[arr.length][arr.length];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i=0; i<arr.length; i++) {
            min = Math.min(min, helper(arr, 0, i, memo));
        }
        return min;
    }

    private int helper(int[][] A, int i, int j, int[][] memo) {
        if (i==A.length || j==A.length) {
            return 0;
        }
        if (memo[i][j] > Integer.MIN_VALUE) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k=0; k< A.length; k++) {
            if (k == j) {
                continue;
            }
            min = Math.min(min, helper(A, i+1, k, memo));
        }
        return memo[i][j] = min+A[i][j];
    }

    public static void main(String[] args) {
        MinimumFallingPathSumII1289Solution solution = new MinimumFallingPathSumII1289Solution();
        int N = 200;
        int[][] A = new int[N][N];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<N; i++) {
            sb.append("[");
            for (int j=0; j<N; j++) {
                int flag = random.nextInt(2)>1?-1:1;
                A[i][j] = flag * random.nextInt(100);
                if (j == N-1) {
                    sb.append(A[i][j]);
                } else {
                    sb.append(A[i][j]).append(",");
                }
            }
            if (i == N-1) {
                sb.append("]");
            } else {
                sb.append("]").append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
        System.out.println(solution.minFallingPathSum(A));
    }
}
