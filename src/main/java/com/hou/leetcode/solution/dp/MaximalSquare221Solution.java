package com.hou.leetcode.solution.dp;

public class MaximalSquare221Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (dp[i-1][j-1] > 0 && matrix[i][j] == '1') {
                    int size = (int) Math.sqrt(dp[i - 1][j - 1]);
                    int nSize = checkSquare(matrix, size, i, j);
                    if (nSize > 0) {
                        dp[i][j] = (nSize+1)*(nSize+1);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }

    private int checkSquare(char[][] matrix, int size, int i, int j) {
        int jSize = 0;
        for (int m=i-1; m>=(i-size); m--) {
            if (matrix[m][j] == '1'){
                jSize++;
            } else {
                break;
            }
        }
        int iSize = 0;
        for (int m=j-1; m>=(j-size); m--) {
            if (matrix[i][m] == '1'){
                iSize++;
            } else {
                break;
            }
        }
        return Math.min(Math.min(size, iSize), jSize);
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        MaximalSquare221Solution solution = new MaximalSquare221Solution();
        System.out.println(solution.maximalSquare(matrix));
    }
}
