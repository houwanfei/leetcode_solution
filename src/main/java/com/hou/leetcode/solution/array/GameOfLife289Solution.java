package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-16 11:10
 */
public class GameOfLife289Solution {
    /**
     * 定义额外状态
     * 1-活细胞转为活细胞
     * 2-死细胞转换活细胞
     * 3-活细胞转为死细胞
     * 4-死系统转为死细胞
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length==0) {
            return;
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int live = 0;
                for (int k=i-1; k<=i+1; k++) {
                    for (int l=j-1;l<=j+1; l++) {
                        if (k<0 || k>board.length-1 || l<0 || l>board[0].length-1 || (k==i && l==j)) {
                            continue;
                        }
                        if (board[k][l] % 2 == 1) {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 1 && live<2) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && live>=2 && live<=3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && live>3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && live==3) {
                    board[i][j] = 2;
                } else {
                    board[i][j] = 4;
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] <3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife289Solution solution = new GameOfLife289Solution();
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        solution.gameOfLife(board);
        System.out.println();
    }
}
