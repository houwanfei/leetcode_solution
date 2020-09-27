package com.hou.leetcode.solution.dp;

public class LongestIncreasingPathMatrix329Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, helper(matrix, i, j, memo));
            }
        }
        return ans;
    }

    private int helper(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int max = 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (check(matrix, i, j, x, y)) {
                max = Math.max(max, helper(matrix, x, y, memo) + 1);
            }
        }
        return memo[i][j] = max;
    }

    private boolean check(int[][] matrix, int i, int j, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return false;
        }
        if (matrix[i][j] < matrix[x][y]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix329Solution solution = new LongestIncreasingPathMatrix329Solution();
        int[][] matrix = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 7}
        };
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
