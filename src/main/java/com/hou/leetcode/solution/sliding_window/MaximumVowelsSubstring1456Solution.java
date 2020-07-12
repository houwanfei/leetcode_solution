package com.hou.leetcode.solution.sliding_window;

public class MaximumVowelsSubstring1456Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int sum = 0;
        for (int i=0; i<k; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                sum++;
            }
        }
        max = Math.max(sum, max);
        for (int i=k; i<s.length();i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                sum++;
            }
            if (s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e'
                    || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o'
                    || s.charAt(i-k) == 'u') {
                sum--;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumVowelsSubstring1456Solution solution = new MaximumVowelsSubstring1456Solution();
        System.out.println(solution.maxVowels("abciiidef", 3));
    }
}
