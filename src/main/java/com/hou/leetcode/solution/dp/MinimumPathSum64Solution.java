package com.hou.leetcode.solution.dp;

public class MinimumPathSum64Solution {

    public int solution(int[][] grid){
        int[][] sum = new int[grid.length][grid[0].length];
        for (int i =0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (i == 0 && j == 0){
                    sum[i][j] = grid[i][j];
                } else if (j == 0){
                    sum[i][j] = sum[i-1][j] + grid[i][j];
                } else if(i == 0){
                    sum[i][j] = sum[i][j-1] + grid[i][j];
                } else {
                    sum[i][j] = Math.min(sum[i-1][j] + grid[i][j], sum[i][j-1] + grid[i][j]);
                }
            }
        }
        return sum[grid.length-1][grid[0].length-1];
    }

    private int count(int i, int j, int[][] grid){
        System.out.println("count:" + i + " " + j);
        if (i == 0 && j == 0){
            return grid[i][j];
        }

        if (j == 0){
            return count(i-1, j, grid) +grid[i][j];
        }
        if (i == 0){
            return count(i, j-1, grid) + grid[i][j];
        }
        return Math.min(count(i, j-1, grid) + grid[i][j], count(i-1, j, grid) +grid[i][j]);
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,0,4,9,6,0,9,1,8,9,5},
//                {1,2,8,9,2,4,8,1,7,3,2},
//                {5,0,7,9,3,5,1,3,8,2,3},
//                {3,2,2,5,3,3,3,2,0,5,6},
//                {9,6,8,3,6,2,0,1,4,6,1},
//                {1,7,4,8,8,9,7,1,3,2,5},
//                {7,7,8,0,3,0,0,0,8,1,8},
//                {8,7,4,0,9,5,4,7,9,8,5},
//                {5,6,3,5,5,6,0,7,1,7,7},
//                {9,9,2,1,1,2,1,5,0,0,4}};
        int[][] grid = {{5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},
                {3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},
                {6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},
                {4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},
                {7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},
                {8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},
                {8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},
                {5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},
                {0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},
                {4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},
                {5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},
                {0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},
                {1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},
                {1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},
                {8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},
                {9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},
                {3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},
                {1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},
                {3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}};

        MinimumPathSum64Solution sum64Solution = new MinimumPathSum64Solution();
        System.out.println(sum64Solution.solution(grid));
    }
}
