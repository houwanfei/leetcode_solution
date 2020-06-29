package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-29 12:35
 */
public class MaximumSubarraySumOneDeletion1186Solution {
    /**
     * 运行超时
     * 改版后没有超时，但是依然很慢，改动主要是每次计算当前元素连续子数组最大和时利用了前一个元素计算结果
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = Integer.MIN_VALUE;
        int leftCurr = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        rightMax(arr, dp);
        for (int i=0; i<arr.length; i++) {
            if (i-1 < 0) {
                int rightSum = dp[i+1];
                max = Math.max(max, Math.max(rightSum, rightSum+arr[i]));
            } else if (i+1 >= arr.length) {
                int leftSum = leftMax(arr, i - 1, leftCurr);
                leftCurr = leftSum;
                max = Math.max(max, Math.max(leftSum, leftSum+arr[i]));
            } else {
                int leftSum = leftMax(arr, i - 1, leftCurr);
                leftCurr = leftSum;
                int rightSum = dp[i+1];
                if (leftSum > 0 && rightSum > 0) {
                    max = Math.max(max, Math.max(leftSum + rightSum, leftSum + rightSum + arr[i]));
                } else {
                    max = Math.max(max, Math.max(Math.max(leftSum, rightSum), Math.max(leftSum, rightSum) + arr[i]));
                }
            }
        }
        return max;
    }

    private int leftMax(int[] arr, int end, Integer curr) {
        if (end < 0) {
            return Integer.MIN_VALUE;
        }
        if (end == 0) {
            curr=arr[end];
        } else {
            curr = Math.max(arr[end], curr+arr[end]);
        }
        return curr;
    }

    private void rightMax(int[] arr, int[] dp) {
        int curr = Integer.MIN_VALUE;
        for (int i=arr.length-1; i>=0; i--) {
            if (curr == Integer.MIN_VALUE) {
                curr = arr[i];
            } else {
                curr = Math.max(arr[i], curr + arr[i]);
            }
            dp[i] = curr;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2};
        System.out.println(new MaximumSubarraySumOneDeletion1186Solution().maximumSum(nums));
    }
}
