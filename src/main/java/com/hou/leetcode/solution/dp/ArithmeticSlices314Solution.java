package com.hou.leetcode.solution.dp;


public class ArithmeticSlices314Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int diff = A[1] - A[0];
        int result = 0;
        int preNum = 2;
        for (int i=2; i<A.length; i++) {
            if (A[i] - A[i-1] == diff) {
                preNum += 1;
                result += preNum-2;
            } else {
                diff = A[i] - A[i-1];
                preNum = 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ArithmeticSlices314Solution solution = new ArithmeticSlices314Solution();
        System.out.println(solution.numberOfArithmeticSlices(nums));
    }
}
