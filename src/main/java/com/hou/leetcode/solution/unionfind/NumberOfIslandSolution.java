package com.hou.leetcode.solution.unionfind;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @auther houwanfei
 * @create 2018-09-05 下午1:34
 */
public class NumberOfIslandSolution {

    private boolean insideBoard(int m, int n, int x, int y){
        return (x>=0 && x<m && y>=0 && y<n);
    }

    public int solution(char[][] lands){
        if (lands == null || lands.length == 0 || lands[0].length==0){
            return 0;
        }
        int m = lands.length;
        int n = lands[0].length;

        UnionFind uf = new UnionFind(m * n);

        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (lands[i][j] == '1'){
                    for (int k=0; k<4; k++){
                        int x = i + dirX[k];
                        int y = j + dirY[k];
                        if (insideBoard(m, n, x, y) && lands[x][y] == '1'){
                            uf.union(i*n+j, x*n+y);
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (lands[i][j] == '1'){
                    set.add(uf.find(i*n+j));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
//        char[][] lands = new char[4][5];
//        Random random = new Random();
//        for (int i=0; i< 4; i++){
//            for (int j=0; j<5; j++){
//                if (random.nextInt(4) == 1){
//                    lands[i][j] = '1';
//                } else {
//                    lands[i][j] = '0';
//                }
//                System.out.print(lands[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

//        char[][] lands = {{'1','1','1','1','0'},{'1','1','0','1','0'},
//                {'1','1','0','0','0'},{'0','0','0','0','0'}};

        char[][] lands = {{'1','0','1','1','1'},{'1','0','1','0','1'},
                {'1','1','1','0','1'}};

        for (int i=0; i<lands.length; i++){
            for (int j=0; j<lands[0].length; j++){
                System.out.print(lands[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("----------------");
        NumberOfIslandSolution solution = new NumberOfIslandSolution();
        System.out.println(solution.solution(lands));
    }
}
