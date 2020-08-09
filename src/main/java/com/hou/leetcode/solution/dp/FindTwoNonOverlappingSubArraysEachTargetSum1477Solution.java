package com.hou.leetcode.solution.dp;

import java.util.Random;

public class FindTwoNonOverlappingSubArraysEachTargetSum1477Solution {
    /**
     * 思想：用一个前缀数组存放以i结尾之前（不包括i）的最小子数组长度
     * 用一个后缀数组存放以i开始或i之后的后缀最小子数组长度
     * 最终的结果min = min(prefix[i]+suffix[i])
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];

        int sum = 0;
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-1; i++) {
            sum += arr[i];
            while (index <= i && sum > target) {
                sum -= arr[index];
                index++;
            }
            int len = i-index+1;
            prefix[i+1] = minLen;
            if (sum == target) {
                minLen = Math.min(minLen, len);
                prefix[i+1] = minLen;
            }
        }
        sum = 0;
        index = arr.length-1;
        minLen = Integer.MAX_VALUE;
        for (int i=arr.length-1; i>=0; i--) {
            sum += arr[i];
            while (index >= i && sum > target) {
                sum -= arr[index];
                index--;
            }
            int len = index-i+1;
            suffix[i] = minLen;
            if (sum == target) {
                minLen = Math.min(minLen, len);
                suffix[i] = minLen;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=1; i<arr.length-1; i++) {
            if (prefix[i] == Integer.MAX_VALUE || suffix[i] == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(prefix[i]+suffix[i],min);
        }
        return min ==0 || min == Integer.MAX_VALUE?-1:min;
    }

    /**
     * 优化上边的算法，用一个数组来存放
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths2(int[] arr, int target) {
        int[] dp = new int[arr.length];
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            sum += arr[i];
            while (sum > target) {
                sum -= arr[index];
                index++;
            }
            int len = i-index+1;
            if (sum == target) {
                dp[i] = len;
                if (dp[index-1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[i] + dp[index - 1]);
                }
            }
            if (i-1 >=0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
        FindTwoNonOverlappingSubArraysEachTargetSum1477Solution solution = new FindTwoNonOverlappingSubArraysEachTargetSum1477Solution();
//        int[] nums =  new int[]{2,1,3,3,2,3,1};
        int N = 10000;
        int[] nums = new int[N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            nums[i] = random.nextInt(999)+1;
            stringBuilder.append(nums[i]).append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.minSumOfLengths(nums, 423134));
        System.out.println(solution.minSumOfLengths2(nums, 423134));
    }
}
