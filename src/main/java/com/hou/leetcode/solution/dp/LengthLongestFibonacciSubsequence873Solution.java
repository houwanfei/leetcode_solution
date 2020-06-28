package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-23 12:35
 */
public class LengthLongestFibonacciSubsequence873Solution {
    /**
     * 时间复杂度O(n^2),空间复杂度O(n^2)
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        //用于快速查找能否组成序列
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[A.length][A.length];
        for (int i=0 ; i<A.length; i++) {
            map.put(A[i], i);
        }
        int max = 0;
        for (int i=1; i<A.length;i++) {
            for (int j=i-1; j>0; j--) {
                int diff = A[i] - A[j];
                Integer first = map.get(diff);
                if (first != null && first < j) {
                    dp[i][j] = Math.max(dp[i][j], dp[j][first] == 0?3:dp[j][first]+1);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(new LengthLongestFibonacciSubsequence873Solution().lenLongestFibSubseq(nums));
    }
}
