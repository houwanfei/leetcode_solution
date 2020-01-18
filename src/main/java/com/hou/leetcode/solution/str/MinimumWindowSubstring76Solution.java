package com.hou.leetcode.solution.str;

import java.util.HashMap;

/**
 * @Description 滑动窗口
 * @auther houwf
 * @create 2020-01-17 15:33
 */
public class MinimumWindowSubstring76Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        String minStr = null;
        int num=0;
        int start=-1;
        for (int i=0; i<s.length(); i++) {
            if (tMap.get(s.charAt(i)) != null) {
                if (start == -1) {
                    start = i;
                }
                tMap.put(s.charAt(i), tMap.get(s.charAt(i))-1);
                if (tMap.get(s.charAt(i)) >= 0) {
                    num++;
                }
                if (tMap.get(s.charAt(i)) < 0 && s.charAt(start) == s.charAt(i)) {
                    for (int j=start; j<=i; j++) {
                        if(tMap.get(s.charAt(j)) != null && tMap.get(s.charAt(j)) >= 0) {
                            start = j;
                            break;
                        } else if (tMap.get(s.charAt(j)) != null && tMap.get(s.charAt(j)) < 0) {
                            tMap.put(s.charAt(j), tMap.get(s.charAt(j)) + 1);
                        }
                    }
                }
                if (num == t.length()) {
                    if (minStr == null) {
                        minStr = s.substring(start, i+1);
                    } else {
                        minStr = ((i - start)+1) < minStr.length() ? s.substring(start, i+1) : minStr;
                    }
                }
            }
        }
        return minStr == null? "" :minStr;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring76Solution solution = new MinimumWindowSubstring76Solution();
        System.out.println(solution.minWindow("aaabbaaba", "abbb"));
    }
}
