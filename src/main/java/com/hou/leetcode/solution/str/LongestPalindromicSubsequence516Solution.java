package com.hou.leetcode.solution.str;

public class LongestPalindromicSubsequence516Solution {
    public int solution(String str){
        if (str == null || str.length()==0)
            return 0;
        int[] count = new int[256];
        char[] strC = str.toCharArray();

        for (int i=0; i<strC.length; i++){
            count[strC[i]]++;
        }

        int max = count[0];
        for (int i=1; i<count.length; i++){
            if (count[i] > max)
                max = count[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence516Solution solution = new LongestPalindromicSubsequence516Solution();
        System.out.println(solution.solution("bbbab"));
    }
}
