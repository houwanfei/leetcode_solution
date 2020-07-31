package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-31 12:26
 */
public class DeleteOperationTwoStrings583Solution {
    /**
     * 思想 递归和712类似 计算量很大 超时
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return helper(word1.toCharArray(), word1.length()-1, word2.toCharArray(), word2.length()-1);
    }


    public int helper(char[] s1c, int i, char[] s2c, int j) {
        if (i<0 && j<0) {
            return 0;
        }
        if (i<0) {
            return j+1;
        }
        if (j<0) {
            return i+1;
        }
        if (s1c[i] == s2c[j]) {
            return helper(s1c, i-1, s2c, j-1);
        } else {
            return Math.min(helper(s1c, i-1, s2c, j), helper(s1c,i, s2c, j-1)) + 1;
        }
    }

    /**
     * 递归+备忘录 自顶向下dp 剪枝减少计算量
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        return helperWithMemo(word1.toCharArray(), word1.length()-1, word2.toCharArray(), word2.length()-1, new int[word1.length()+1][word2.length()+1]);
    }

    public int helperWithMemo(char[] s1c, int i, char[] s2c, int j, int[][] memo) {
        if (i<0 && j<0) {
            return 0;
        }
        if (memo[i+1][j+1] > 0) {
            return memo[i+1][j+1];
        }
        if (i<0) {
            return memo[i+1][j+1] = j+1;
        }
        if (j<0) {
            return memo[i+1][j+1] = i+1;
        }
        if (s1c[i] == s2c[j]) {
            return memo[i+1][j+1] = helperWithMemo(s1c, i-1, s2c, j-1, memo);
        } else {
            return memo[i+1][j+1] = Math.min(helperWithMemo(s1c, i-1, s2c, j, memo), helperWithMemo(s1c,i, s2c, j-1, memo)) + 1;
        }
    }

    /**
     * 自底向上dp
     *                 dp[i][j] s1c[i] == s2c[j]
     *               /
     *  dp[i+1][j+1]
     *               \
     *                Math.min(dp[i+1][j], dp[i][j+1])+1 s1c[i] != s2c[j]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance3(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word1.length(); i++) {
            dp[i+1][0] = dp[i][0]+1;
        }
        for (int i=0; i<word2.length(); i++) {
            dp[0][i+1] = dp[0][i]+1;
        }
        char[] word1c = word1.toCharArray();
        char[] word2c = word2.toCharArray();
        for (int i=0; i<word1.length(); i++) {
            for (int j=0; j<word2.length(); j++) {
                if (word1c[i] == word2c[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationTwoStrings583Solution solution = new DeleteOperationTwoStrings583Solution();
        System.out.println(solution.minDistance3("sea", "ate"));
    }
}
