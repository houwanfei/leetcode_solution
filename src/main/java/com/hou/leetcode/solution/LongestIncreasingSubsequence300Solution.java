package com.hou.leetcode.solution;

public class LongestIncreasingSubsequence300Solution {


    /**
     * o(n^2)解法
     * 思路：动态规划思想，第i个最大递增子序列可以表示为
     * d[i]表示第i位的最长递增子序列
     * d[i] = max(d[k] ... d[k + o])+1 其中num[k] < num[i] 否则d[i] = 1
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int[] p = new int[nums.length];
        p[0] = 1;
        for (int i=1; i< nums.length; i++){
            p[i] = 1;
            for (int j=0; j < i; j++){
                if (nums[j] < nums[i]){
                    p[i] = Math.max(p[j] + 1, p[i]);
                }
            }
        }
        int max = p[0];
        for (int i = 1; i< p.length; i++){
            max = Math.max(max, p[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {4,10,4,3,8,9};
        LongestIncreasingSubsequence300Solution solution = new LongestIncreasingSubsequence300Solution();
        System.out.println(solution.solution(nums));
    }
}
