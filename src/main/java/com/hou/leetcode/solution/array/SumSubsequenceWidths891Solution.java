package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-08 18:16
 */
public class SumSubsequenceWidths891Solution {
    private int sum = 0;
    public int sumSubseqWidths(int[] A) {
        helper(A, A[0], A[0], 0);
        return sum;
    }

    private void helper(int[] A, int min, int max, int index) {
        sum += max-min;
        for (int i=index; i<A.length; i++) {
            helper(A, Math.min(min, A[i]), Math.max(max, A[i]), i+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3};
        SumSubsequenceWidths891Solution solution = new SumSubsequenceWidths891Solution();
        System.out.println(solution.sumSubseqWidths(nums));
    }
}
