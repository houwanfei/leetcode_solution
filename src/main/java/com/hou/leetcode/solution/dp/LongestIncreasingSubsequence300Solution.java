package com.hou.leetcode.solution.dp;

public class LongestIncreasingSubsequence300Solution {


    /**
     * o(n^2)解法
     * 思路：动态规划思想，第i个最大递增子序列可以表示为
     * d[i]表示第i位的最长递增子序列
     * d[i] = max(d[k]...)+1 其中num[k] < num[i] 否则d[i] = 1
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

    /**
     * 时间复杂度 O(N*lgN)
     * @param nums
     * @return
     */
    public int solution2(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int[] p = new int[nums.length];
        int len = 1;
        p[0] = nums[0];
        for (int i=1;i<nums.length; i++) {
            if (nums[i] > p[len-1]) {
                p[len] = nums[i];
                len++;
            } else {
                int pos = bsFind(p, len, nums[i]);
                p[pos] = nums[i];
            }
        }
        return len;
    }

    private int bsFind(int[] p,int len, int num) {
        int s = 0, e = len;
        while (s <= e) {
            int mid = s+(e-s)/2;
            if (p[mid] < num) {
                s = mid+1;
            } else if (p[mid] > num) {
                e = mid-1;
            } else {
                return mid;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        //int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {4,10,4,3,8,9};
        LongestIncreasingSubsequence300Solution solution = new LongestIncreasingSubsequence300Solution();
        System.out.println(solution.solution(nums));
        System.out.println(solution.solution2(nums));
    }
}
