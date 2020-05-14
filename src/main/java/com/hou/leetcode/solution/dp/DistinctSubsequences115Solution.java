package com.hou.leetcode.solution.dp;

public class DistinctSubsequences115Solution {
    /**
     * 思路：求s中有多少个t子串，可以参考最长子序列，不过这里要做一下变化
     * 我们记录的dp[i][i]是代表在t的前i个字符和s的前j个字符的子序列个数
     * 可以横向看 行为0时，都是1，再看t的第一个b和s的第一个b时，是1，看s的第二个b时，
     * 这时情况不一样了，因为s的第二个b可以和t的第一个b配成一个，s的第一个b也可以配成一个
     * 我们可以很容易看出，当s的字符个t的不相等时，dp[i][j]=dp[i][j-1]，即s的前一个字符
     * 当s的字符个t相等时，此时的i可以选则和j字符配对，那么就应该看其左上方dp[i-1][j-1]
     * 如果i不选择配对，那么就和不相等一样取dp[i][j-1]所以字符相等时是两种的和dp[i][j]=dp[i][j-1]+dp[i-1][j-1]
     *      0   r   a   b   b   b   i   t
     * 0    1   1   1   1   1   1   1   1
     * r        1   1   1   1   1   1   1
     * a            1   1   1   1   1   1
     * b                1   2   3   3   3
     * b                    1   3   3   3
     * i                        0   3   3
     * t                            0   3
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i=0; i<=s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i=1; i<=t.length(); i++) {
            for (int j=i; j <=s.length(); j++) {
                dp[i][j] = dp[i][j-1] + (s.charAt(j-1) == t.charAt(i-1) ? dp[i-1][j-1]:0);
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinct2(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;
        for (int i=1; i<=s.length(); i++) {
            for (int j=t.length(); j > 0; j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[t.length()];
    }

    public int numDistinct3(String s, String t) {
        return helper(s, t, s.length(), t.length());
    }

    private int helper(String s, String t, int index1, int index2){
        if (index2 == 0) {
            return 1;
        }
        if (index1 == 0) {
            return 0;
        }
        if (s.charAt(index1-1) == t.charAt(index2-1)) {
            return helper(s, t, index1-1, index2) + helper(s, t, index1-1, index2-1);
        } else {
            return helper(s, t, index1-1, index2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences115Solution().numDistinct3("babgbag", "bag"));
    }
}
