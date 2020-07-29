package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-07-29 17:07
 */
public class CountSquareSubmatricesAllOnes1277Solution {
    /**
     * 有点蠢
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int count = 0;
        for (int i=1;i<=Math.min(row, col); i++) {
            for (int j=i-1; j<row; j++) {
                for (int k=i-1; k<col; k++) {
                    if (matrix[j][k] == 1) {
                        if (i-1 == 0) {
                            dp[j][k] = i;
                            count++;
                        } else if (dp[j-1][k-1] >= (i-1) && check(matrix, i, j, k)){
                            dp[j][k] = i;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean check(int[][] matrix, int len, int j, int k) {
        for (int i=j; i>j-len; i--) {
            if (matrix[i][k] != 1) {
                return false;
            }
        }
        for (int i=k; i>k-len; i--) {
            if (matrix[j][i] != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过上方、左上角、右方的正方形数来计算当前的，当然要取他们的最小值，然后和当前的i,j组成一个更大的正方形因此+1
     * @param matrix
     * @return
     */
    public int countSquares2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int count = 0;
        for (int i=0;i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }
                int up = i>0?dp[i-1][j]:0;
                int diagonal = i>0&&j>0?dp[i-1][j-1]:0;
                int left = j>0?dp[i][j-1]:0;
                dp[i][j] = 1+Math.min(Math.min(up, diagonal), left);
                count += dp[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSquareSubmatricesAllOnes1277Solution solution = new CountSquareSubmatricesAllOnes1277Solution();
        int[][] matrix = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(solution.countSquares2(matrix));
    }
}
