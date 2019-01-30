package com.hou.leetcode.solution.dp;

/**
 * @outhor ikan
 * @create 2019-01-30 17:25
 */
public class RangeSumQuery2D304Solution {
    private int[][] sum;

    public RangeSumQuery2D304Solution(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        sum = new int[matrix.length+1][matrix[0].length +1];
        for (int i=1; i<=matrix.length; i++){
            for (int j=1; j<= matrix[0].length; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] -sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
                        };
        RangeSumQuery2D304Solution solution = new RangeSumQuery2D304Solution(matrix);
        System.out.println(solution.sumRegion(2, 1, 4, 3));
        System.out.println(solution.sumRegion(1, 1, 2, 2));
        System.out.println(solution.sumRegion(1, 2, 2, 4));
    }
}