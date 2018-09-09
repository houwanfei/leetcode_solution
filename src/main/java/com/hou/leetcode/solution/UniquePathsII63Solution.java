package com.hou.leetcode.solution;

public class UniquePathsII63Solution {
    /**
     * 求起点到终点路的条路 每步只能下或右运动(有障碍物)
     *  A  B  C
     *
     *  D  E  F
     *
     *  G  H  I
     * 思路：动态规划问题 最后一个点I由F或H到达，所以path[I] = path[H] + path[F],
     * 但是有障碍物,一旦遇到障碍物该路劲被封死，即path[i][j]=0
     * 得出推论
     * 0. grid[i][j] == 1 path[i][j] = 0
     * 1. path[0][0] = 1
     * 2. i == 0 path[i][j] = path[i][j-1]
     * 3. j == 0 path[i][j] = path[i-1][j]
     * 4. i>0 & j>0 path[i][j] = path[i][j-1] + path[i-1][j]
     * @return
     */
    public int solution(int[][] grid){
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    path[i][j] = 0;
                } else {
                    if (i == 0 && j == 0){
                        path[i][j] = 1;
                    } else if (i == 0){
                        path[i][j] = path[i][j-1];
                    }else if (j == 0){
                        path[i][j] = path[i-1][j];
                    } else {
                        path[i][j] = path[i][j-1] + path[i-1][j];
                    }
                }
            }
        }

        return path[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
        int[][] grid = {{1, 0}};
        UniquePathsII63Solution solution = new UniquePathsII63Solution();
        System.out.println(solution.solution(grid));
    }
}
