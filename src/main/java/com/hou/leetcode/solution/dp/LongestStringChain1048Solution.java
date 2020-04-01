package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-31 13:43
 */
public class LongestStringChain1048Solution {

    public int longestStrChain(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        int max = 1;
        dp[0] = 1;
        for (int i=1; i<words.length; i++) {
            dp[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (check(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    private boolean check(String word1, String word2) {
        if (Math.abs(word1.length() - word2.length()) != 1) {
            return false;
        }
        int i=0,j=0;
        int diff = 0;
        while (i<word1.length() && j<word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (word1.length() > word2.length()) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        if (diff == 1 || diff==0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String[] words = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        LongestStringChain1048Solution solution = new LongestStringChain1048Solution();
        System.out.println(solution.longestStrChain(words));
    }
}
