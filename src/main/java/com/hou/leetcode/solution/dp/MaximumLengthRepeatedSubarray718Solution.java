package com.hou.leetcode.solution.dp;

public class MaximumLengthRepeatedSubarray718Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int max = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                if (A[i] != B[j]) {
                    continue;
                }
                if (i==0||j==0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        System.out.println(new MaximumLengthRepeatedSubarray718Solution().findLength(A, B));
    }
}
