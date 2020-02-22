package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i=0; i<=s.length(); i++) {
            for (int j=i; j>=0; j--) {
                String subStr = s.substring(j, i);
                if (wordDict.contains(subStr) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak139Solution solution = new WordBreak139Solution();
        List<String> strs = new ArrayList<>();
        strs.add("leet");
        strs.add("code");
        System.out.println(solution.wordBreak("leetcode", strs));
    }
}
