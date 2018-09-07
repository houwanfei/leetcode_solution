package com.hou.leetcode.solution.dp;

/**
 * @auther houwanfei
 * @create 2018-09-07 上午9:30
 */
public class LongestSubstringSolution {

    public int solution(String str){
        int index = -1;
        int[] map = new int[256];
        int len = 0;
        for (int j =0; j<256; j++){
            map[j] = -1;
        }
        char[] strc = str.toCharArray();
        int strLen = str.length();
        for (int j=0; j<strLen; j++){
            int mapCurr = map[strc[j]];
            index = Math.max(mapCurr, index);
            map[strc[j]] = j;
            len = Math.max(len, (j - index));
        }
        return len;
    }

    public static void main(String[] args) {
        String string = "abcaabcd";
        LongestSubstringSolution solution = new LongestSubstringSolution();
        System.out.println(solution.solution(string));
    }
}
