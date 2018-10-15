package com.hou.leetcode.solution.dp;

public class EditDistance72Solution {

    /**
     * 思路：动态规划问题
     * 题目中提到有三种变换方式，其实是迷惑，这里只需要考虑，求dp[i][j]时
     * 1.word2[i-1] == word1[j-1] 这时在前边变化的基础上是不需要变化的所以 dp[i][j] = d[i-1][j-1]
     * 2.word2[i-1] != word1[j-1] 这时是需要变化的，无论如何变化都只是在前边处理的基础上变化一次，
     * 如果从左上角对角线过来就是变换这两个字母，如果从左边过来那就是删除word1，如果从上边下来那就是插入一个字符
     * 所以在第二种情况下，我们需要取上、左上、左三个方向的最小值，所以得出递推公式
     *             dp[i-1][j-1]  word2[i-1] == word1[j-1]
     *          /
     * dp[i][j]
     *          \
     *            min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j])) + 1  word2[i-1] != word1[j-1]
     *
     *
     * 如 word1 = horse word2 = ros
     *
     * dp:
     *    '' h o r s e
     * '' 0  1 2 3 4 5
     * r  1  1 2 2 3 4
     * o  2  2 1 2 3 4
     * s  3  3 2 2 2 3
     *
     * @param word1
     * @param word2
     * @return
     */
    public int solution(String word1, String word2){
        char[] word1c = word1.toCharArray();
        char[] word2c = word2.toCharArray();
        int[][] dp = new int[word2c.length+1][word1c.length+1];

        dp[0][0] = 0;
        for (int i=1; i<= word2c.length; i++){
            dp[i][0] = i;
        }
        for (int j=1; j<=word1c.length; j++){
            dp[0][j] = j;
        }

        for (int i=1; i<=word2c.length; i++){
            for (int j=1; j<=word1c.length; j++){
                if (word2c[i-1] == word1c[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }

        return dp[word2c.length][word1c.length];
    }

    public static void main(String[] args) {
        EditDistance72Solution solution = new EditDistance72Solution();
        System.out.println(solution.solution("horse", "ros"));
    }
}
