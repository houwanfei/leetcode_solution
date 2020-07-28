package com.hou.leetcode.solution.str;

public class KMPSolution {

    public int match(String s, String p) {
        int[] next = generateNext(p);
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int i=0;
        int j=0;
        while (i<s.length()) {
            if (j==-1 || sc[i] == pc[j]) {
                i++;
                j++;
                if (j == p.length()) {
                    return i-p.length();
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private int[] generateNext(String s){
        char[] c = s.toCharArray();
        int[] next =  new int[c.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < c.length-1){
            if (k == -1  || c[k] == c[j]){
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMPSolution solution = new KMPSolution();
        System.out.println(solution.match("adweasdababacd", "abab"));
    }
}
