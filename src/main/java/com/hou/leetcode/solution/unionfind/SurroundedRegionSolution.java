package com.hou.leetcode.solution.unionfind;

import java.util.Random;

/**
 * @auther houwanfei
 * @create 2018-09-04 下午1:55
 */
public class SurroundedRegionSolution {

    /**
     * 判断是否在矩阵的边缘
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    private boolean isEdge(int m, int n, int x, int y){
        return (x == 0 || x == (m-1) || y == 0 || y == (n-1));
    }

    /**
     * 判断是否在矩阵内部
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    private boolean insideBoard(int m, int n, int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public void surroundedRegion(char[][] regions){
        if (regions == null || regions.length == 0 || regions[0].length == 0){
            return;
        }

        int m = regions.length;
        int n = regions[0].length;

        int god = m * n;

        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        UnionFind uf = new UnionFind(m * n+1);

        for (int i=0; i < m; i++){
            for (int j=0; j<n; j++){
                System.out.println(i + " " +j);
                if (regions[i][j] == 'O') {
                    if (isEdge(m, n, i, j)) {
                        uf.union(i * n + j, god);
                    } else {
                        for (int k = 0; k<4; k++){
                            int x = i + dirX[k];
                            int y = j + dirY[k];
                            if (insideBoard(m, n, x, y) && regions[x][y] == 'O'){
                                uf.union(i*n+j, x*n+y);
                            }
                        }
                    }
                }
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j< n; j++){
                if (!uf.connect(i*n+j, god)){
                    regions[i][j] = 'X';
                }
                System.out.print(regions[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        char[][] region = new char[6][4];

        Random random = new Random();
        for (int i=0; i< 6; i++){
            for (int j=0; j<4; j++){
                if (random.nextInt(4) == 1){
                    region[i][j] = 'O';
                } else {
                    region[i][j] = 'X';
                }
                System.out.print(region[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        SurroundedRegionSolution solution = new SurroundedRegionSolution();
        solution.surroundedRegion(region);
        System.out.println("");

    }

}
