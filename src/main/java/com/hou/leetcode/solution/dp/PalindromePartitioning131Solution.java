package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131Solution {
    public List<List<String>> partition(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (int i=1; i<s.length(); i++) {
            dp[i] = 1;
            if (dp[i-1] >0) {
                if (dp[i-1] == 1 && s.charAt(i-1) == s.charAt(i)) {
                    dp[i] = dp[i-1] + 1;
                } else if (s.charAt(i) == s.charAt(i-dp[i-1])){
                    dp[i] = dp[i-1] + 2;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PalindromePartitioning131Solution solution = new PalindromePartitioning131Solution();
        System.out.println(solution.partition("aaab"));
    }
}
