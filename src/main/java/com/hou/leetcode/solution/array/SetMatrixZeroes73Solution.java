package com.hou.leetcode.solution.array;

/**
 * @Description 常数空间算法 思想：将需要变为0的行列保存在第一行和第一列中
 * @auther houwf
 * @create 2020-01-03 16:38
 */
public class SetMatrixZeroes73Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i=0; i<rows.length; i++) {
            for (int j=0; j< cols.length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i=0; i<rows.length; i++) {
            if (rows[i]) {
                for (int j=0; j<cols.length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i=0; i<cols.length; i++) {
            if (cols[i]) {
                for (int j=0; j<rows.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        SetMatrixZeroes73Solution solution = new SetMatrixZeroes73Solution();
        solution.setZeroes(matrix);
        System.out.println();
    }
}
