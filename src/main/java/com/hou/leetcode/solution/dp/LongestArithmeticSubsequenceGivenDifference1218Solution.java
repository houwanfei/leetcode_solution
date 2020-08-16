package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LongestArithmeticSubsequenceGivenDifference1218Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            if (!dp.containsKey(arr[i]-difference)) {
                dp.put(arr[i], 1);
            } else {
                dp.put(arr[i], dp.get(arr[i] - difference) + 1);
            }
            ans = Math.max(ans, dp.get(arr[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceGivenDifference1218Solution solution = new LongestArithmeticSubsequenceGivenDifference1218Solution();
        int N = 10000;
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        for (int i=0; i<nums.length; i++) {
            int flag = random.nextInt(3) > 1?-1:1;
            nums[i] = random.nextInt(10000) * flag;
            stringBuilder.append(nums[i]).append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.longestSubsequence(nums, -2));
    }
}
