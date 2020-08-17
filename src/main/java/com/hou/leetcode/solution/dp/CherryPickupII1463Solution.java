package com.hou.leetcode.solution.dp;


import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-17 10:07
 */
public class CherryPickupII1463Solution {
    /**
     * 思路 递归+备忘录
     * 要求机器人在 row行i位置和j位置的最大值，
     * 转换为求row+1行(i-1,j-1)、(i-1,j)、(i-1,j+1)、(i,j-1)、(i,j)、(i,j+1)、(i+1,j-1)、(i+1,j)、(i+1,j+1) + grid[row][i]+grid[row][j]
     * 注意如果i和j相同，只有一次可以计数
     * 因为memo是列的组合，所以memo是三维数组
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        return helper(grid, 0, grid[0].length-1, 0, new int[grid.length][grid[0].length][grid[0].length]);
    }

    private int helper(int[][] grid, int i, int j, int row, int[][][] memo) {
        if (row == grid.length) {
            return 0;
        }
        if (memo[row][i][j] > 0) {
            return memo[row][i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int m=i-1; m<=i+1; m++) {
            if (m == -1 || m==grid[0].length) {
                continue;
            }
            for (int n=j-1; n<=j+1; n++) {
                if (n == -1 || n==grid[0].length) {
                    continue;
                }
                int res = helper(grid, m, n, row+1,memo);
                if (i == j) {
                    res += grid[row][i];
                } else {
                    res += grid[row][i] + grid[row][j];
                }
                max = Math.max(max, res);
            }
        }
        return memo[row][i][j] = max;
    }

    public static void main(String[] args) {
        CherryPickupII1463Solution solution = new CherryPickupII1463Solution();
//        int[][] grid = new int[][]{
//                {3,1,1},{2,5,1},{1,5,5},{2,1,1}
//        };
        int M=40,N=50;
        int[][] grid = new int[M][N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<M; i++) {
            stringBuilder.append("[");
            for (int j=0; j<N; j++) {
                grid[i][j] = random.nextInt(100);
                stringBuilder.append(grid[i][j]);
                if (j != N-1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != M-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.cherryPickup(grid));
    }
}
