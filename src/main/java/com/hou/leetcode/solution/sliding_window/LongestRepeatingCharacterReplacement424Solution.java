package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-02 18:03
 */
public class LongestRepeatingCharacterReplacement424Solution {
    /**
     * 滑动窗口解法
     * 思路要转变一下，求在 窗口大小 - 窗口内最多的字母 > k时，窗口的开始后移
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int begin = 0, i = 0, max = 0;
        int[] charCount = new int[26];
        int maxCount = 0;
        char[] chars = s.toCharArray();
        while (i <= s.length()-1) {
            charCount[chars[i]-'A']++;
            maxCount = Math.max(maxCount, charCount[chars[i]-'A']);
            while (i-begin +1 - maxCount > k) {
                charCount[chars[begin]-'A']--;
                begin++;
            }
            max = Math.max(max, i-begin +1);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424Solution solution = new LongestRepeatingCharacterReplacement424Solution();
        System.out.println(solution.characterReplacement("ABAB", 2));
    }
}
