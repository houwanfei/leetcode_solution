package com.hou.leetcode.solution.dp;

public class UniquePaths62Solution {
    /**
     * 求起点到终点路的条路 每步只能下或右运动
     *  A  B  C
     *
     *  D  E  F
     *
     *  G  H  I
     * 思路：动态规划问题 最后一个点I由F或H到达，所以path[I] = path[H] + path[F]
     * 得出推论
     * 1. path[0][0] = 1
     * 2. i == 0 path[i][j] = path[i][j-1]
     * 3. j == 0 path[i][j] = path[i-1][j]
     * 4. i>0 & j>0 path[i][j] = path[i][j-1] + path[i-1][j]
     * @param m
     * @param n
     * @return
     */
    public int solution(int m, int n){
        if (m<=0 || n <= 0){
            return 0;
        }
        int[][] path = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i == 0 || j==0){
                    path[i][j] = 1;
                } else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths62Solution solution = new UniquePaths62Solution();
        System.out.println(solution.solution(7, 3));
    }
}
