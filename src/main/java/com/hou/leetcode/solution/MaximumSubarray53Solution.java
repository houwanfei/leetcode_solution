package com.hou.leetcode.solution;

public class MaximumSubarray53Solution {

    /**
     * maxSum ← -∞
     *
     * for i ← 1 to n
     * sum ← 0
     * for j ← i to 1   // decrement j
     * sum += arr[j]
     *
     * maxSum ← max(maxSum, sum)
     *
     * return maxSum
     *
     * for i = 1 ⇒ max( sum(-1) )
     * for i = 2 ⇒ max ( sum(2), sum(2, -1) )
     * for i = 3 ⇒ max ( sum(3), sum(3, 2), sum(3, 2, -1) )
     * for i = 4 ⇒ max ( sum(-4), sum(-4, 3), sum(-4, 3, 2), sum(-4, 3, 2, -1) )
     *
     * Kadane’s Algorithm states that,
     * maxSum[i] = max(nums[i], nums[i] + maxSum[i-1])
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] maxSums = new int[nums.length];
        maxSums[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            maxSums[i] = Math.max(nums[i], nums[i]+maxSums[i-1]);
        }
        int max = maxSums[0];
        for (int i=0; i<nums.length; i++){
            max = Math.max(max, maxSums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-2, -1};
        MaximumSubarray53Solution solution = new MaximumSubarray53Solution();
        System.out.println(solution.solution(nums));
    }
}
