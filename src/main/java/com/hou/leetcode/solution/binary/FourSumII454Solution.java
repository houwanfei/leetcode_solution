package com.hou.leetcode.solution.binary;

import java.util.HashMap;
import java.util.Map;

public class FourSumII454Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A.length; j++) {
                Integer num = map.getOrDefault(A[i]+B[j], 0);
                map.put(A[i]+B[j], num+1);
            }
        }
        int ans = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A.length; j++) {
                if (map.get(0-C[i]-D[j]) != null) {
                    ans += map.get(0-C[i]-D[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSumII454Solution solution = new FourSumII454Solution();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(solution.fourSumCount(A,B,C,D));
    }
}
