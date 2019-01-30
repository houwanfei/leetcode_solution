package com.hou.leetcode.solution.dp;

/**
 * @outhor ikan
 * @create 2019-01-30 16:32
 */
public class RangeSumQuery303Solution {
//    private int[][] dp;
//    public RangeSumQuery303Solution(int[] nums){
//        dp = new int[nums.length][];
//
//        for (int i=0; i<nums.length; i++){
//            dp[i] = new int[i+1];
//            dp[i][i] = nums[i];
//        }
//
//        for (int i=1; i<nums.length; i++){
//            for (int j=0; j<i; j++){
//                dp[i][j] = dp[i-1][j] + nums[i];
//            }
//        }
//
//    }

    private int[] sum;
    public RangeSumQuery303Solution(int[] nums){
        sum = new int[nums.length + 1];
        for (int i=1;i<=nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j){
        //return dp[j][i];
        return sum[j+1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        RangeSumQuery303Solution solution = new RangeSumQuery303Solution(nums);
        System.out.println(solution.sumRange(0,2));
        System.out.println(solution.sumRange(2,5));
        System.out.println(solution.sumRange(0,5));
    }
}