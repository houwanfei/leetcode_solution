package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII140Solution {
    /**
     * 在139题思路下，记录前驱，然后通过前驱构建结果
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<Integer>[] dp = new List[s.length()+1];
        dp[0] = new ArrayList<>();
        for (int i=0; i<=s.length(); i++) {
            for (int j=i; j>=0; j--) {
                String subStr = s.substring(j, i);
                if (wordDict.contains(subStr) && dp[j] != null){
                    if (dp[i] == null) {
                        dp[i] = new ArrayList<>();
                    }
                    dp[i].add(j);
                }
            }
        }
        if (dp[s.length()] == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        helper(s, res, new ArrayList<>(), dp, s.length());
        return res;
    }

    private void helper(String s, List<String> res, List<String> tmp, List<Integer>[] dp, int j) {
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=tmp.size()-1; i>=0; i--) {
                sb.append(tmp.get(i));
                if (i > 0) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
        }
        for (Integer index : dp[j]) {
            tmp.add(s.substring(index, j));
            helper(s, res, tmp, dp, index);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        WordBreakII140Solution solution = new WordBreakII140Solution();
        List<String> res = solution.wordBreak("pineapplepenapple", strs);
        System.out.println();
    }
}
