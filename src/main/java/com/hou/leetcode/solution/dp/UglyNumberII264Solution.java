package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

public class UglyNumberII264Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        int two = 1, three = 1, five = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            int oneNum = 2*dp[two];
            int twoNum = 3*dp[three];
            int threeNum = 5*dp[five];
            dp[i] = Math.min(oneNum, Math.min(twoNum, threeNum));
            if (dp[i] == oneNum) {
                two++;
            }
            if (dp[i] == twoNum) {
                three++;
            }
            if (dp[i] == threeNum){
                five++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumberII264Solution solution = new UglyNumberII264Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}
