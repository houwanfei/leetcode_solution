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

    public String solutionImprove(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        char[] s;
        int[] p;

        char[] strc = str.toCharArray();
        p = new int[strc.length * 2 +1];
        s = new char[strc.length * 2 +1];
        int j = 0;
        for (int i = 0 ; i<strc.length; i++){
            s[j++] = '#';
            s[j++] = strc[i];
        }
        s[j] = '#';

        int right = 0;
        int pos = 0;
        for (int i=1; i<s.length; i++){
            p[i] = i < right ? Math.min(p[2*pos -i],(right-i)) : 1;

            int low = i-p[i];
            int high = i+p[i];
            while (low >=0 && high < s.length) {
                if (s[high] == s[low]) {
                    right = high;
                    pos = i;
                    p[i] += 1;
                } else {
                    break;
                }
                high++;
                low--;
            }
            if (i+p[i] > right) {
                right = i + p[i];
                pos = i;
            }
        }
        int max = p[0];
        int index = 0;
        for (int i =1; i<s.length; i++){
            if (p[i] > max){
                max = p[i];
                index = i;
            }
        }
        return String.valueOf(s, index-(max-1), 2*max-1).replaceAll("#", "");
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
        String re = solution.solutionImprove("aba");
        System.out.println(solution.solution(""));
    }
}
