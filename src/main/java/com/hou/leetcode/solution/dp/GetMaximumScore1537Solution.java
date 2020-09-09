package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

public class GetMaximumScore1537Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer, Long> dp1 = new HashMap<>();
        Map<Integer, Long> dp2 = new HashMap<>();
        int i=0;
        int j=0;
        int mod = (int)Math.pow(10, 9)+7;
        while (i<nums1.length || j<nums2.length) {
            if (i<nums1.length && j<nums2.length && nums1[i] == nums2[j]) {
                long sum = 0;
                if (i > 0) {
                    sum = Math.max(dp1.getOrDefault(nums1[i-1], 0L), sum);
                }
                if (j > 0) {
                    sum = Math.max(sum, dp2.getOrDefault(nums2[j-1], 0L));
                }
                sum = (sum+nums1[i]);
                dp1.put(nums1[i], sum);
                dp2.put(nums2[j], sum);
                i++;
                j++;
            } else if (i<nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                long sum = 0;
                if (i>0) {
                    sum = dp1.getOrDefault(nums1[i-1], 0L);
                }
                sum = (sum + nums1[i]);
                dp1.put(nums1[i], sum);
                i++;
            } else {
                long sum = 0;
                if (j > 0) {
                    sum = dp2.getOrDefault(nums2[j-1], 0L);
                }
                sum = (sum + nums2[j]);
                dp2.put(nums2[j], sum);
                j++;
            }
        }
        return (int)(Math.max(dp1.get(nums1[nums1.length-1]), dp2.get(nums2[nums2.length-1]))%mod);
    }

    /**
     * 这里不需要缓存前边的结果，因为计算当前值，只和前一个状态有关系
     *              sum1 + num1[i] nums1[i] != nums2[j]
     *          /
     * sum1 =
     *          \
     *              Math(sum1, sum2) + num[i] nums1[i] == nums2[j]
     *
     * sum2同理
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxSum2(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        long sum1 = 0;
        long sum2 = 0;
        while (i<nums1.length || j<nums2.length) {
            if (i<nums1.length && j<nums2.length && nums1[i] == nums2[j]) {
                sum1 = Math.max(sum1, sum2) + nums1[i];
                sum2 = sum1;
                i++;
                j++;
            } else if (i<nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else {
                sum2 += nums2[j++];
            }
        }
        int mod = (int)Math.pow(10, 9)+7;
        return (int)(Math.max(sum1, sum2)%mod);
    }

    public static void main(String[] args) {
        GetMaximumScore1537Solution solution = new GetMaximumScore1537Solution();
        int[] nums1 = new int[]{1,2,6,10};
        int[] nums2 = new int[]{2,6};
        System.out.println(solution.maxSum(nums1, nums2));
        System.out.println(solution.maxSum2(nums1, nums2));
    }
}
