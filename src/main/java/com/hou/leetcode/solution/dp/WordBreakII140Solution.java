package com.hou.leetcode.solution.dp;

import java.util.*;

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

    public List<String> wordBreak2(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0)
            return new ArrayList<>();
        List<String>[] dp = new ArrayList[s.length() + 1];
        Set<String> ws = new HashSet<>(wordDict);
        dp[s.length()] = new ArrayList<>();
        dp[s.length()].add("");
        return dfs(ws, dp, 0, s);
    }

    private List<String> dfs(Set<String> ws, List<String>[] dp, int idx, String s) {
        if (idx == s.length() || dp[idx] != null) return dp[idx];
        List<String> res = new ArrayList<>();
        for (int j = idx + 1; j <= s.length(); j++) {
            if (ws.contains(s.substring(idx, j))) {
                List<String> tmp = dfs(ws, dp, j, s);
                for (String str : tmp) res.add(s.substring(idx, j) + (str.length() == 0 ? "" : " ") + str);
            }
        }
        dp[idx] = res;
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        WordBreakII140Solution solution = new WordBreakII140Solution();
        List<String> res = solution.wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", strs);
        System.out.println();
    }
}
