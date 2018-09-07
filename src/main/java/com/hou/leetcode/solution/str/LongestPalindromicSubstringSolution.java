package com.hou.leetcode.solution.str;

/**
 * @auther houwanfei
 * @create 2018-09-07 下午2:34
 */
public class LongestPalindromicSubstringSolution {

    public String solution(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        char[] sc = s.toCharArray();
        int max = 0;
        int maxStart = 0;
        for (int i=0; i< sc.length; i++){
            for (int j=i; j<sc.length; j++){
                int value = checkPalindromic(sc, i, j);
                if (max < value){
                    maxStart = i;
                    max = value;
                }
            }
        }

        return String.valueOf(sc, maxStart, max);
    }


    private int checkPalindromic(char[] sc, int start, int end){
        int i = start;
        int j = end;
        while (start < end){
            if (sc[start++] != sc[end--]){
                return 0;
            }
        }
        return (j - i + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();
        System.out.println(solution.solution(""));
    }
}
