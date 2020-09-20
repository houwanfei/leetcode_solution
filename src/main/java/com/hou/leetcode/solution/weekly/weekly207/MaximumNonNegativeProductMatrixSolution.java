package com.hou.leetcode.solution.weekly.weekly207;


public class MaximumNonNegativeProductMatrixSolution {
    public int maxProductPath(int[][] grid) {
        long[] ans = helper(grid, grid.length-1, grid[0].length-1, new long[grid.length][grid[0].length][]);
        long mod = (long) Math.pow(10, 9)+7;
        return ans[0] < 0? -1:(int)(ans[0]%mod);
    }

    private long[] helper(int[][] grid, int i, int j, long[][][] memo) {
        if (i==0 && j==0) {
            return new long[]{grid[i][j], grid[i][j]};
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        if (i>0) {
            long[] res = helper(grid, i-1, j, memo);
            max = Math.max(max, Math.max(grid[i][j]*res[0], grid[i][j]*res[1]));
            min = Math.min(min, Math.min(grid[i][j]*res[0], grid[i][j]*res[1]));
        }
        if (j>0) {
            long[] res = helper(grid, i, j-1, memo);
            max = Math.max(max, Math.max(grid[i][j]*res[0], grid[i][j]*res[1]));
            min = Math.min(min, Math.min(grid[i][j]*res[0], grid[i][j]*res[1]));
        }
        memo[i][j] = new long[]{max, min};
        return memo[i][j];
    }

    public static void main(String[] args) {
        MaximumNonNegativeProductMatrixSolution solution = new MaximumNonNegativeProductMatrixSolution();
        int[][] grid = new int[][]{
                {1,-1,0,-3,4,3,-3,3,-1,3,0,0,-4,2},
                {2,-2,-3,-4,0,-2,-3,3,1,4,1,-3,-1,-4},
                {-4,4,-4,-4,2,-4,3,0,-2,-4,3,4,-1,0},
                {-3,3,-4,-4,3,4,4,1,-1,-1,0,3,4,1},
                {1,3,-4,2,2,-3,1,-3,-4,-4,-1,-4,-4,4},
                {1,1,-1,1,-1,-1,3,-4,-1,2,-2,3,-4,0},
                {1,0,3,3,1,4,1,1,-4,-1,-3,4,-4,4},
                {4,3,2,3,0,-1,2,-4,1,0,0,1,3,4},
                {-4,4,-4,-4,2,-2,2,-1,0,-2,2,4,-2,-1},
                {-2,3,4,-4,3,3,-2,-1,0,-3,4,-2,-1,-4},
                {4,3,3,3,-3,1,2,-4,-1,4,-3,-3,2,0},
                {3,3,0,1,-4,-4,-3,3,-2,-4,2,4,-3,3},
                {-3,0,1,3,0,0,0,-4,-1,4,-1,-3,1,1},
                {-1,4,0,-3,1,-3,-1,2,1,-3,-1,-4,4,1}
        };
        System.out.println(solution.maxProductPath(grid));
    }
}
