package com.hou.leetcode.solution.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther houwanfei
 * @create 2018-09-04 下午1:58
 */
public class UnionFind {
    private int[] ids;

    private int[] sizes;

    public UnionFind(int n){
        ids = new int[n];
        sizes = new int[n];

        for (int i=0; i<n; i++){
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int x, int y){
        int i = find(x);
        int j = find(y);

        if (i == j){
            return;
        }

        if (sizes[i] > sizes[j]){
            ids[j] = i;
            sizes[i] += sizes[j];
        } else {
            ids[i] = j;
            sizes[j] += sizes[i];
        }
    }

    public int find(int x){
        while (x != ids[x]){
            ids[x] = ids[ids[x]];
            x = ids[x];
        }
        return x;
    }

    public boolean connect(int x, int y){
        return find(x) == find(y);
    }
}
