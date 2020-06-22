package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-22 10:01
 */
public class TwoKeysKeyboard650Solution {
    /**
     * 思路 先写出来
     * A 0
     * AA 2 拆成 A A
     * AAA 3 拆成 A A A
     * AAAA 4 拆成 AA AA
     * AAAAA 5 拆成 A A A A A
     * AAAAAA 5 拆成 AAA AAA
     * AAAAAAA 7 拆成 A A A A A A A
     * AAAAAAAA 6 拆成 AAAA AAAA
     * AAAAAAAAA 6 拆成 AAA AAA AAA
     * 有时多写几组就可以看出规律 可以容易写出状态转移方程
     *            0 i=1
     *          /
     * dp[i] =
     *          \
     *           dp[最大整除数] + 1(复制) + 倍数-1(粘贴)
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=i-1; j>=1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i/j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard650Solution solution = new TwoKeysKeyboard650Solution();
        System.out.println(solution.minSteps(8));
    }
}
