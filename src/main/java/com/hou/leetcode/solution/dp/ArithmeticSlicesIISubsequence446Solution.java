package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-01 10:09
 */
public class ArithmeticSlicesIISubsequence446Solution {
    /**
     * dp
     * 思路：想到用dp，那么就要定义dp什么，因为这里是子序列，
     * 很容易想到dp[i][diff]表示以i结尾，差值为diff的，
     * 但是A数组值范围很大，导致如果用数组来存放diff非常耗费空间，因此我们很容易想到用对于稀疏数组可以采用map存储
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length<3) {
            return 0;
        }
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        int ans = 0;
        for (int i=0; i<A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j=i-1; j>=0; j--) {
                long diff = (long)A[i]-(long)A[j];
                if (diff > Integer.MAX_VALUE || diff<Integer.MIN_VALUE) {
                    continue;
                }
                dp[i].put((int)diff, dp[i].getOrDefault((int)diff, 0)+1);
                if (dp[j].get((int)diff) != null) {
                    ans += dp[j].get((int)diff);
                    dp[i].put((int)diff, dp[j].get((int)diff)+dp[i].get((int)diff));
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] A = new int[]{1,2,2,3,4,5};
        int[] A = new int[1000];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        for (int i=0; i<1000; i++) {
            A[i] = random.nextInt(100000);
            stringBuilder.append(A[i]);
            if (i<999) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        ArithmeticSlicesIISubsequence446Solution solution = new ArithmeticSlicesIISubsequence446Solution();
        System.out.println("begin"+System.currentTimeMillis());
        System.out.println(solution.numberOfArithmeticSlices(A));
        System.out.println("end"+System.currentTimeMillis());
    }
}
