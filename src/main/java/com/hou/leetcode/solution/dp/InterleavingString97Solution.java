package com.hou.leetcode.solution.dp;

public class InterleavingString97Solution {
    public boolean solution(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        char[] s1c = s1.toCharArray();
        char[] s3c = s3.toCharArray();

        int[][] lcs = new int[s1c.length+1][s3c.length+1];

        for (int i=0; i<=s1c.length; i++){
            for (int j=0; j<=s3c.length; j++){
                if (i==0 || j==0)
                    lcs[i][j] = 0;
                else if (s1c[i-1] == s3c[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }

        if (lcs[s1c.length][s3c.length] != s1c.length){
            return false;
        }
        char[] s2c = s2.toCharArray();
        int k = s2c.length-1;
        int i = s1c.length;
        int j = s3c.length;
        while (i>0 && j>0){
            if (s1c[i-1] == s3c[j-1]){
                i--;
                j--;
            } else {
                if (lcs[i][j-1] > lcs[i-1][j]){
                    if (s2c[k] != s3c[j-1]){
                        return false;
                    }
                    k--;
                    j--;
                } else {
                    i--;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        InterleavingString97Solution solution = new InterleavingString97Solution();
        System.out.println(solution.solution("aabcc", "dbbca", "aadbbbaccc"));
    }
}
