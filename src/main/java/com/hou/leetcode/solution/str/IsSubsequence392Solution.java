package com.hou.leetcode.solution.str;

public class IsSubsequence392Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for (int i=0; i<t.length() && j<s.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence392Solution().isSubsequence("axc", "ahbgdc"));
    }
}
