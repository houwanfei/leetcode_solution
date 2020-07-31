package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-31 10:56
 */
public class MinimumASCIIDeleteSumTwoStrings712Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return helper(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1, new int[s1.length()+1][s2.length()+1]);
    }

    /**
     * 思路 递归，比如要求 "eat" 和"sea",可以转换为求删除eat的t或者删除sea的a，因此
     * minimum("eat","sea") = min(minimum("ea","sea"), minimum("eat","se"))
     * 递归过程中如果某一个字符不能删除，那就删除另一个字符
     *
     * 直接递归会有很多重复计算，引入备忘录，实现自顶向下的dp减少重复计算
     * @param s1c
     * @param i
     * @param s2c
     * @param j
     * @param memo
     * @return
     */
    private int helper(char[] s1c, int i, char[] s2c, int j, int[][] memo) {
        if (i<0 && j<0) {
            return 0;
        }
        if (memo[i+1][j+1] > 0) {
            return memo[i+1][j+1];
        }
        if (i < 0) {
            return memo[i+1][j+1]=helper(s1c, i, s2c, j-1, memo) + s2c[j];
        }
        if (j<0){
            return memo[i+1][j+1]=helper(s1c, i-1, s2c, j, memo) + s1c[i];
        }
        if (s1c[i] == s2c[j]) {
            return memo[i+1][j+1]=helper(s1c, i-1, s2c, j-1, memo);
        }
        int s1cv = helper(s1c, i-1, s2c, j, memo) + s1c[i];
        int s2cv = helper(s1c, i, s2c, j-1, memo) + s2c[j];
        return memo[i+1][j+1]=Math.min(s1cv, s2cv);
    }

    /**
     * 自底向上dp
     *                dp[i][j] s1c[i] == s2c[j]
     *              /
     * dp[i+1][j+1]
     *              \
     *               Math.min(dp[i+1][j] + s2c[j], dp[i][j+1]+s1c[i]) s1c[i] != s2c[j]
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum2(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        for (int i=0; i<s1.length(); i++) {
            dp[i+1][0] = dp[i][0] + s1c[i];
        }

        for (int i=0; i<s2.length(); i++) {
            dp[0][i+1] = dp[0][i] + s2c[i];
        }

        for (int i=0; i<s1.length(); i++) {
            for (int j=0; j<s2.length(); j++) {
                if (s1c[i] == s2c[j]) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i+1][j] + s2c[j], dp[i][j+1]+s1c[i]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumTwoStrings712Solution solution = new MinimumASCIIDeleteSumTwoStrings712Solution();
        System.out.println(solution.minimumDeleteSum("insteadwetuasdrneqqadbothsqtriwasngds", "insssdateadwweaeturnedboeeadthsasdatrings"));
        System.out.println(solution.minimumDeleteSum2("insteadwetuasdrneqqadbothsqtriwasngds", "insssdateadwweaeturnedboeeadthsasdatrings"));
    }
}
