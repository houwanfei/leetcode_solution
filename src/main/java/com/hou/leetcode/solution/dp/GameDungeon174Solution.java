package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-07-27 13:43
 */
public class GameDungeon174Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return dfs(dungeon, 0, 0, new int[dungeon.length][dungeon[0].length]);
    }

    /**
     * 递归求(0,0)的最小初始血量，转化为求(0,1)和(1,0)为最小初始血量，那么(0,0)=min((0,1),(1,0))-dungeon[0][0]，
     * 如果小于0，则说明这个点是魔法球，那么骑士只需要一点血量就够了
     * @param dungeon
     * @param i
     * @param j
     * @param mome
     * @return
     */
    private int dfs(int[][] dungeon, int i, int j, int[][] mome) {
        if (i==dungeon.length-1 && j==dungeon[0].length-1) {
            return Math.max(1-dungeon[i][j], 1);
        }
        if (mome[i][j] > 0) {
            return mome[i][j];
        }
        int res;
        if (i == dungeon.length-1) {
            res= Math.max(dfs(dungeon, i, j+1, mome)-dungeon[i][j], 1);
        }else if (j == dungeon[0].length-1) {
            res = Math.max(dfs(dungeon, i+1, j, mome)-dungeon[i][j], 1);
        } else {
            res = Math.max(Math.min(dfs(dungeon, i, j + 1, mome), dfs(dungeon, i + 1, j, mome)) - dungeon[i][j], 1);
        }
        return mome[i][j]=res;
    }



    public static void main(String[] args) {
//        int[][] nums = new int[][] {
//                {-2, -3, 2},
//                {-5, -1, 1},
//                {10, 30, -5}
//        };
        int[][] nums = new int[][] {
                {1,-3,3},
                {0,-2,0},
                {-3,-3,-3}
        };
        GameDungeon174Solution solution = new GameDungeon174Solution();
        System.out.println(solution.calculateMinimumHP(nums));
    }
}
