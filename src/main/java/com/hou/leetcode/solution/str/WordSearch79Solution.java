package com.hou.leetcode.solution.str;

/**
 * @Description 把二维数组理解为图，就是寻找一条路径能满足这个字符串的路，所以想到用图的DFS
 * @auther houwf
 * @create 2020-01-03 15:17
 */
public class WordSearch79Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null || "".equals(word)) {
            return false;
        }
        char[] wordc = word.toCharArray();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                boolean[][] isvisted = new boolean[board.length][board[0].length];
                if (backtracking(board, isvisted, i, j, wordc, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, boolean[][] isvisted, int i, int j, char[] wordc, int count) {
        if (wordc[count] != board[i][j]) {
            return false;
        }

        if ((count +1 ) == wordc.length) {
            return true;
        }

        int[][] nexts = new int[][]{{-1, 0},{0, 1}, {1, 0}, {0,-1}};

        isvisted[i][j] = true;
        for (int[] next : nexts) {
            int ni = i + next[0], nj = j+next[1];
            if (ni < board.length && ni >=0 && nj<board[0].length && nj>=0 && !isvisted[ni][nj]) {
                if (backtracking(board, isvisted, ni, nj, wordc, count+1)) {
                    return true;
                }
            }
        }
        isvisted[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'A','B','C','E'},
                 {'S','F','E','S'},
                 {'A','D','E','E'}};

        WordSearch79Solution solution = new WordSearch79Solution();
        System.out.println(solution.exist(board, "ABCEFSADEESE"));
    }

}
