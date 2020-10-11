package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-23 17:23
 */
public class NumberPathsWithMaxScore1301Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        if (board.size() == 0 || board.get(0).length() == 0) {
            return new int[]{0, 0};
        }
        int[] res = helper(board, 0, 0, new int[board.size()][board.get(0).length()][]);
        if (res[1] == 0) {
            res[0] = 0;
        }
        return res;
    }

    private int[] helper(List<String> board, int i, int j, int[][][] memo) {
        if (i>=board.size() || j>=board.get(0).length()) {
            return new int[]{0,0};
        }
        if (i==board.size()-1 && j==board.get(0).length()-1) {
            return new int[]{0,1};
        }
        if (board.get(i).charAt(j) == 'X') {
            return new int[]{0,0};
        }
        if (memo[i][j] != null) {
            System.out.println("dp");
            return memo[i][j];
        }
        int[][] directions = new int[][]{{0, 1},{1, 0}, {1, 1}};
        int[] ans = new int[2];
        int mod = (int) Math.pow(10, 9)+7;
        for (int[] direction : directions) {
            int[] res = helper(board, i+direction[0], j+direction[1], memo);
            int sum = board.get(i).charAt(j) == 'E'?0:board.get(i).charAt(j)-48;
            if (res[0] + sum == ans[0]) {
                ans[1] = (ans[1] + res[1])%mod;
            } else if (res[0] + sum> ans[0]) {
                ans[1] = res[1];
                ans[0] = res[0]+sum;
            }
        }
        return memo[i][j]=ans;
    }

    public static void main(String[] args) {
        List<String> board = new ArrayList<>();
        Random random = new Random();
        int M = 100;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<M; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=0; j<M; j++) {
                if (i==0 && j == 0) {
                    stringBuilder.append('E');
                } else if (i == M-1 && j == M-1){
                    stringBuilder.append('S');
                } else {
                    if (random.nextInt(6) > 4) {
                        stringBuilder.append('X');
                    } else {
                        stringBuilder.append(random.nextInt(9)+1);
                    }

                }
            }
            board.add(stringBuilder.toString());
            sb.append("\"");
            sb.append(stringBuilder.toString());
            sb.append("\"");
            if (i<M-1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
        NumberPathsWithMaxScore1301Solution solution = new NumberPathsWithMaxScore1301Solution();
        int[] res = solution.pathsWithMaxScore(board);
        System.out.println();
    }
}
