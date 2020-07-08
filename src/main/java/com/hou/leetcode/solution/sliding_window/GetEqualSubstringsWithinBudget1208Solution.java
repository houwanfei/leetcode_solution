package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-08 12:33
 */
public class GetEqualSubstringsWithinBudget1208Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int begin = 0;
        int cost = 0;
        for (int i=0; i<s.length(); i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(begin) - t.charAt(begin));
                begin++;
            }
            maxLen = Math.max(maxLen, i-begin+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget1208Solution solution = new GetEqualSubstringsWithinBudget1208Solution();
        System.out.println(solution.equalSubstring("abcd", "cdef", 3));
    }
}
