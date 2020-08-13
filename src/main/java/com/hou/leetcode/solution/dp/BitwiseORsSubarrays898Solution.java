package com.hou.leetcode.solution.dp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-13 9:49
 */
public class BitwiseORsSubarrays898Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer>[] dp = new Set[A.length];
        Set<Integer> ans = new HashSet<>();
        for (int i=0; i<A.length; i++) {
            ans.add(A[i]);
            dp[i] = new HashSet<>();
            dp[i].add(A[i]);
        }
        for (int i=1; i<A.length; i++) {
            for (Integer bit : dp[i-1]) {
                dp[i].add(bit | A[i]);
                ans.add(bit | A[i]);
            }
        }
        return ans.size();
    }

    /**
     * 优化空间复杂度
     * @param A
     * @return
     */
    public int subarrayBitwiseORs2(int[] A) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        prev.add(A[0]);
        ans.add(A[0]);
        for (int i=1; i<A.length; i++) {
            Set<Integer> curr = new HashSet<>();
            curr.add(A[i]);
            ans.add(A[i]);
            for (Integer bit : prev) {
                curr.add(bit | A[i]);
                ans.add(bit | A[i]);
            }
            prev = curr;
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int N = 50000;
        int[] num = new int[N];
        Random random = new Random();
        int bound = (int) Math.pow(10, 9);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            num[i] = random.nextInt(bound);
            stringBuilder.append(num[i]).append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        BitwiseORsSubarrays898Solution solution = new BitwiseORsSubarrays898Solution();
        System.out.println(solution.subarrayBitwiseORs(num));
        System.out.println(solution.subarrayBitwiseORs2(num));
    }
}
