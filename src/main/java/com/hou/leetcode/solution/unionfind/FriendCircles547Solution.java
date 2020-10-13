package com.hou.leetcode.solution.unionfind;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles547Solution {
    public int findCircleNum(int[][] M) {
        int[] uf = new int[M.length];
        init(uf);
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M.length; j++) {
                if (M[i][j] == 1 ) {
                    connect(uf, i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<M.length; i++) {
            set.add(find(uf, i));
        }
        return set.size();
    }

    private void init(int[] uf) {
        for (int i=0; i<uf.length; i++) {
            uf[i] = i;
        }
    }

    private void connect(int[] uf, int x, int y) {
        int i = find(uf, x);
        int j = find(uf, y);
        if (i == j) {
            return;
        }
        uf[i] = j;
    }

    private int find(int[] uf, int x) {
        while (uf[x] != x) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

    public static void main(String[] args) {
        FriendCircles547Solution solution = new FriendCircles547Solution();
        int[][] M = new int[][] {
                {0}
        };
        System.out.println(solution.findCircleNum(M));
    }
}
