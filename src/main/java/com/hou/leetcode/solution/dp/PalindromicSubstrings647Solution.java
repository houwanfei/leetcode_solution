package com.hou.leetcode.solution.dp;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-31 17:12
 */
public class PalindromicSubstrings647Solution {
    public int countSubstrings(String s) {
        return helper(s.toCharArray(), s.length()-1);
    }

    /**
     * 暴力求解
     * @param sc
     * @param i
     * @return
     */
    private int helper(char[] sc, int i) {
        if (i == 0) {
            return 1;
        }
        int count = helper(sc, i-1);
        for (int j=i; j>=0; j--) {
            if (check(sc, j, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(char[] sc, int j, int i) {
        while (j <= i) {
            if (sc[j] != sc[i]) {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }

    /**
     * 思想：上边的暴力求解方法每次都会比较整个字符串判断是否是回文字符串
     * 其实在每次比较时可以利用之前的比较结果，比如 abba，判断a==a,那么只需要bb是不是回文，这里显然是，因此，
     *            true sc[i] == sc[j] && (i==j || (j-i==1) || dp[i+1][j-1]==true)
     *          /
     * dp[i][j]
     *          \
     *           false 其他情况
     * 注意：这里dp时我们用到的是i+1和j+1，因此i需要从后向前算，而j需要从前向后算，dp时要搞清楚计算方向
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        char[] sc = s.toCharArray();
        int ans = 0;
        boolean[][] dp = new boolean[sc.length][sc.length];
        for (int i=sc.length-1; i>=0; i--) {
            for (int j=i; j<sc.length; j++) {
                if (sc[i] == sc[j]) {
                    if (i==j || (j-i==1) || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings647Solution solution = new PalindromicSubstrings647Solution();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<2000; i++) {
            stringBuilder.append((char)('a'+random.nextInt(25)));
        }
//        System.out.println(stringBuilder.toString());
        System.out.println("first begin:" + System.currentTimeMillis());
        System.out.println(solution.countSubstrings(stringBuilder.toString()));
        System.out.println("first end:" + System.currentTimeMillis());
        System.out.println(solution.countSubstrings2(stringBuilder.toString()));
        System.out.println("second end:" + System.currentTimeMillis());
    }
}
