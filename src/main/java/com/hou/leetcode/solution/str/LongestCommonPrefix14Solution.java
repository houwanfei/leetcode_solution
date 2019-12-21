package com.hou.leetcode.solution.str;

public class LongestCommonPrefix14Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while (checkValid(strs, n)){
            sb.append(strs[0].charAt(n));
            n++;
        }
        return sb.toString();
    }

    private boolean checkValid(String[] strs, int index) {
        if (strs[0].length() <= index) {
            return false;
        }
        char tmp = strs[0].charAt(index);
        for (int i=1; i< strs.length; i++) {
            if (strs[i].length() <= index) {
                return false;
            }
            if (strs[i].charAt(index) != tmp) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix14Solution solution = new LongestCommonPrefix14Solution();
        String[] strs = new String[]{""};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
