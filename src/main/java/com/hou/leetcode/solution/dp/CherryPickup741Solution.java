package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-18 13:47
 */
public class CherryPickup741Solution {

    /**
     * 递归+备忘录
     * 思路：来回可以抽象成两个任务同时进行，从左上角出发，如果两个任务在某一格子相遇，那么他们只计数一次
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int res = helper(grid, 0, 0, 0, 0, new HashMap<>());
        return res==-1?0:res;
    }

    private int helper(int[][] grid, int i, int j, int i1, int j1, Map<String, Integer> memo) {
        if (i == grid.length || j == grid.length
                || i1 == grid.length || j1 == grid.length
                || grid[i][j] == -1 || grid[i1][j1] == -1) {
            return -1;
        }
        if (i == grid.length-1 && j == grid.length-1
                && i1 == grid.length-1 && j1 == grid.length-1) {
            return grid[i][j];
        }
        String key = i + ":" + j + ":" + i1 + ":" + j1;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int[][] shifts = new int[][]{{1, 0}, {0, 1}};
        int res = 0;
        if (i == i1 && j == j1) {
            res += grid[i][j];
        } else {
            res += grid[i][j] + grid[i1][j1];
        }
        int max = -1;
        for (int[] shift : shifts) {
            for (int[] shift2 : shifts) {
                int num = helper(grid, i + shift[0], j + shift[1], i1 + shift2[0], j1 + shift2[1], memo);
                if (num == -1) {
                    continue;
                }
                max = Math.max(max, res+num);
            }
        }
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        int N = 50;
//        int[][] grid = new int[][]{
//                {1, -1, 1, 1, 1, 1, 1, 1, -1, 1},
//                {1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
//                {-1, 1, 1, -1, 1, 1, 1, 1, 1, 1},
//                {1, 1, -1, 1, -1, 1, 1, 1, 1, 1},
//                {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {-1, -1, 1, 1, 1, -1, 1, 1, -1, 1},
//                {1, 1, 1, 1, 1, 1, 1, -1, 1, 1},
//                {1, 1, 1, 1, -1, 1, -1, -1, 1, 1},
//                {1, -1, 1, -1, -1, 1, 1, -1, 1, -1},
//                {-1, 1, -1, 1, -1, 1, 1, 1, 1, 1}
//        };
        int[][] grid = new int[N][N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            stringBuilder.append("[");
            for (int j=0; j<N; j++) {
                int flag = random.nextInt(3)>1?-1:1;
                grid[i][j] = random.nextInt(2)*flag;
                stringBuilder.append(grid[i][j]);
                if (j != N-1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        CherryPickup741Solution solution = new CherryPickup741Solution();
        System.out.println(solution.cherryPickup(grid));
    }
}
