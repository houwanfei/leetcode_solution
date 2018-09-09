package com.hou.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

class Node{
    int g;
    int h;
    int x;
    int y;
    Node pre;
    public Node(int x, int y, int g, int h, Node pre){
        this.g = g;
        this.h = h;
        this.x = x;
        this.y = y;
        this.pre = pre;
    }
}

public class AStarSolution {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public int solution(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        List<Node> open = new ArrayList<>();
        List<Node> close = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        open.add(new Node(0, 0, grid[0][0], countH(m, n, 0, 0), null));
        Node min = null;
        while (!open.isEmpty()){
            min = findMin(open);
            if (min.y == m-1 && min.x == n-1){
                break;
            }

            open.remove(min);
            close.add(min);

            List<Node> neighbors = findNeighbor(min, grid);

            for (Node neighbor : neighbors){
                Node found = isContain(open, neighbor);
                if (found != null) {
                    if (found.g > min.g + grid[found.y][found.x]) {
                        found.g = min.g + grid[found.y][found.x];
                        found.pre = min;
                    }
                } else {
                    found = isContain(close, neighbor);
                    if (found == null){
                        open.add(neighbor);
                    }
                }
            }
        }
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (isPath(j, i, min)){
                    System.out.print(ANSI_RED + grid[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }

        return min.g;
    }

    private boolean isPath(int x, int y, Node node){
        Node pre = node;
        while (pre !=null){
            if (pre.x == x && pre.y == y){
                return true;
            }
            pre = pre.pre;
        }
        return false;
    }

    private List<Node> findNeighbor(Node node, int[][] grid){
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        List<Node> neighbors = new ArrayList<>();
        for (int k =0; k<4; k++){
            int x = node.x + dirX[k];
            int y = node.y + dirY[k];
            if (x>=0 && x<grid[0].length && y>=0 && y<grid.length){
                neighbors.add(new Node(x, y, node.g + grid[y][x], countH(grid.length, grid[0].length, x, y), node));
            }
        }

        return neighbors;
    }

    private Node isContain(List<Node> list, Node node){
        for (Node n : list){
            if (n.x == node.x && n.y == node.y)
                return n;
        }
        return null;
    }

    private Node findMin(List<Node> open){
        if (open == null || open.size() == 0){
            return null;
        }
        Node min = open.get(0);
        for (Node node : open){
            if ((min.h + min.g) > (node.g + node.h)){
                min = node;
            }
        }
        return min;
    }

    private int countH(int m, int n, int x, int y){
        return m-y-1 + n-x-1;
    }

    public static void main(String[] args) {
//        int[][] grid = {
//            {1, 3, 1},
//            {1, 2, 1},
//            {1, 2, 1}
//        };
        int[][] grid = {{1,0,4,9,6,0,9,1,8,9,5},
                {1,2,8,9,2,4,8,1,7,3,2},
                {5,0,7,9,3,5,1,3,8,2,3},
                {3,2,2,5,3,3,3,2,0,5,6},
                {9,6,8,3,6,2,0,1,4,6,1},
                {1,7,4,8,8,9,7,1,3,2,5},
                {7,7,8,0,3,0,0,0,8,1,8},
                {8,7,4,0,9,5,4,7,9,8,5},
                {5,6,3,5,5,6,0,7,1,7,7},
                {9,9,2,1,1,2,1,5,0,0,4}};

        AStarSolution solution = new AStarSolution();
        System.out.println(solution.solution(grid));
    }
}
