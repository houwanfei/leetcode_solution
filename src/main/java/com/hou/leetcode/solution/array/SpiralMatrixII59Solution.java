package com.hou.leetcode.solution.array;

public class SpiralMatrixII59Solution {


    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }
        int top=0,buttom=n-1,left=0, right=n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while (top<=buttom && left<=right) {
            for (int i=left; i<=right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            if (right >= left) {
                for (int i = top; i <= buttom; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }
            if (buttom>=top) {
                for (int i=right; i>=left; i--) {
                    matrix[buttom][i] = num++;
                }
                buttom--;
            }
            if (left<=right) {
                for (int i=buttom; i>=top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ans = new SpiralMatrixII59Solution().generateMatrix(3);
        System.out.println();
    }
}
