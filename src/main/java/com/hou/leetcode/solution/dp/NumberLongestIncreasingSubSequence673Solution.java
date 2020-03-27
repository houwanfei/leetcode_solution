package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-03-27 10:08
 */
public class NumberLongestIncreasingSubSequence673Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] p = new int[nums.length];
        int[] pre = new int[nums.length];
        p[0] = 1;
        pre[0] = 1;
        int max = p[0];
        for (int i=1; i< nums.length; i++){
            p[i] = 1;
            pre[i] = 1;
            for (int j=0; j < i; j++){
                if (nums[j] < nums[i]){
                    if (p[j]+1>p[i]) {
                        pre[i] = pre[j];
                    } else if (p[j]+1==p[i]){
                        pre[i] += pre[j];
                    }
                    p[i] = Math.max(p[j] + 1, p[i]);
                    max = Math.max(max, p[i]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i< p.length; i++){
            if (max == p[i]) {
                count+=pre[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {8,10,12,11,14,1,3,5,4,7};
        int[] nums2 = {1,2,3,1,2,3,1,2,3};
//        System.out.println(new NumberLongestIncreasingSubSequence673Solution().findNumberOfLIS(nums));
        System.out.println(new NumberLongestIncreasingSubSequence673Solution().findNumberOfLIS(nums2));
    }
}
