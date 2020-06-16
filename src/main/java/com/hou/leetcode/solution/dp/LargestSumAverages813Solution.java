package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-05 17:47
 */
public class LargestSumAverages813Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] memo = new double[K][A.length];
        return helper(A,K-1,A.length-1, memo);
    }

    /**
     * 递归思想，要想求出长度为len的K个分组的最大平均数，只需要考虑从len-1下标开始，所以此时的平均数为 A[len-1] + maxAvg[K-1][len-2],
     * 但是要求的是最大的，所以要分别求出到下标K-1时，最后取最大的和
     * @param A
     * @param K
     * @param last
     * @param memo
     * @return
     */
    private double helper(int[] A, int K, int last, double[][] memo) {
        if (K == 0) {
            if (last < 0)
             return 0;
            else {
                int sum = 0;
                for (int i=0; i<=last; i++) {
                    sum += A[i];
                }
                return sum*1.0/(last+1);
            }
        }
        if (memo[K][last] != 0) {
            return memo[K][last];
        }
        int lastSum=0;
        double max = Integer.MIN_VALUE;
        for (int i=last; i>=K; i--) {
            lastSum += A[i];
            max = Math.max(max, helper(A, K-1, i-1, memo)+(lastSum*1.0/(last-i+1)));
        }
        memo[K][last] = max;
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{9,1,2,3,9};
        LargestSumAverages813Solution solution = new LargestSumAverages813Solution();
        System.out.println(solution.largestSumOfAverages(nums, 3));
    }
}
