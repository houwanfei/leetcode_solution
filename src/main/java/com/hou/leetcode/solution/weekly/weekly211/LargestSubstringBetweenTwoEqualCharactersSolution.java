package com.hou.leetcode.solution.weekly.weekly211;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharactersSolution {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() <= 1) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = -1;
        for (int i=0; i<chars.length; i++) {
            if (map.containsKey((int)chars[i])) {
                ans = Math.max(ans, i-map.get((int)chars[i])-1);
                continue;
            }
            map.put((int)chars[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharactersSolution solution = new LargestSubstringBetweenTwoEqualCharactersSolution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("cabbacaac"));
    }
}
