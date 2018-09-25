package com.hou.leetcode.solution;

public class LCSSolution {
    public int solution(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] lcs = new int[c1.length+1][c2.length+1];

        for (int i=0; i<=c1.length; i++){
            for (int j=0; j<=c2.length; j++){
                if (i == 0 || j == 0){
                    lcs[i][j] = 0;
                }else if (c1[i-1] == c2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        for (int i=0; i<=c1.length; i++){
            for (int j=0; j<=c2.length; j++){
                System.out.print(lcs[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return lcs[c1.length][c2.length];
    }

    public static void main(String[] args) {
        LCSSolution lcsSolution = new LCSSolution();
        System.out.println(lcsSolution.solution("abcbdab", "bdcaba"));
    }
}
