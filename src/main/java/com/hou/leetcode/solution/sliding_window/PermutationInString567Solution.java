package com.hou.leetcode.solution.sliding_window;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-06 12:28
 */
public class PermutationInString567Solution {
    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharCounts = new int[26];
        int[] charCounts = new int[26];
        int begin = 0;
        for (int i=0; i<s1.length(); i++) {
            s1CharCounts[s1.charAt(i) - 'a']++;
        }
        for (int i=0; i<s2.length(); i++) {
            int index = s2.charAt(i)-'a';
            charCounts[index]++;
            if (charCounts[index] > s1CharCounts[index]) {
                while (charCounts[index] > s1CharCounts[index]) {
                    charCounts[s2.charAt(begin)-'a']--;
                    begin++;
                }
            } else if (charCounts[index] == s1CharCounts[index]) {
                boolean res = Arrays.equals(s1CharCounts, charCounts);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口 以s1字符串长度为滑动窗口大小，窗口内字符计数是否相等来判断s1是否可以通过排列得到窗口的s2子串
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        int[] s1CharCounts = new int[26];
        int[] charCounts = new int[26];
        for (int i=0; i<s1.length(); i++) {
            s1CharCounts[s1.charAt(i) - 'a']++;
            charCounts[s2.charAt(i)-'a']++;
        }
        for (int i=0; i<s2.length()-s1.length(); i++) {
            if (Arrays.equals(s1CharCounts, charCounts)) {
                return true;
            }
            charCounts[s2.charAt(i)-'a']--;
            charCounts[s2.charAt(i+s1.length())-'a']++;
        }
        return Arrays.equals(s1CharCounts, charCounts);
    }


    public static void main(String[] args) throws ParseException {
        PermutationInString567Solution solution = new PermutationInString567Solution();
        System.out.println(solution.checkInclusion2("a", "e"));
    }
}
