package com.hou.leetcode.solution.str;

public class LengthLastWord58Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = 0;
        boolean wordFind = false;
        for (int i=chars.length-1; i>=0; i--) {
            if (chars[i] == ' ') {
                if (wordFind) {
                    return len;
                }
            } else {
                wordFind = true;
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthLastWord58Solution solution = new LengthLastWord58Solution();
        System.out.println(solution.lengthOfLastWord(" "));
    }
}
