package com.hou.leetcode.solution.dp;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-04 16:37
 */
public class MinimumFallingPathSum931Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[A.length][A.length];
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A.length; j++) {
                memo[i][j] = -10001;
            }
        }
        for (int i=0; i<A.length; i++) {
            min = Math.min(min, helper(A, 0, i, memo));
        }
        return min;
    }

    private int helper(int[][] A, int i, int j, int[][] memo) {
        if (i==A.length || j==A.length) {
            return 0;
        }
        if (memo[i][j] > -10001) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k=j-1; k<=j+1; k++) {
            if (k >= 0 && k < A.length) {
                min = Math.min(min, helper(A, i+1, k, memo));
            }
        }
        return memo[i][j] = min+A[i][j];
    }

    public static void main(String[] args) {
        MinimumFallingPathSum931Solution solution = new MinimumFallingPathSum931Solution();
        int N = 100;
        int[][] A = new int[N][N];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<N; i++) {
            sb.append("[");
            for (int j=0; j<N; j++) {
                int flag = random.nextInt(2)>0?-1:1;
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
