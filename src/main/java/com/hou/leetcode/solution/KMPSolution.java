package com.hou.leetcode.solution;

public class KMPSolution {
    public void generateNext(String s){
        char[] c = s.toCharArray();
        int[] next =  new int[c.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < c.length-1){
            if (k == -1  || c[k] == c[j]){
                ++k;
                ++j;
                if (c[j] != c[k])
                    next[j] = k;
                else
                    next[j] = next[k];
            } else {
                k = next[k];
            }
        }
        return;
    }

    public static void main(String[] args) {
        KMPSolution solution = new KMPSolution();
        solution.generateNext("abab");
        System.out.println();
    }
}
