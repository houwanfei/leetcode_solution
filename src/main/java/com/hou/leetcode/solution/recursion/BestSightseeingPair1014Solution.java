package com.hou.leetcode.solution.recursion;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-10 15:57
 */
public class BestSightseeingPair1014Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        int[] maxs = new int[A.length];
        for (int i=0; i<A.length; i++) {
            max = Math.max(max, A[i] + i);
            maxs[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i=A.length-1; i>0; i--) {
            max = Math.max(max, A[i]-i + maxs[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = new int[]{8,1,5,2,6};
        System.out.println(new BestSightseeingPair1014Solution().maxScoreSightseeingPair(A));

    }
}
