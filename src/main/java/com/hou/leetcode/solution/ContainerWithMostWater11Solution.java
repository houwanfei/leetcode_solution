package com.hou.leetcode.solution;

public class ContainerWithMostWater11Solution {


    /**
     * 暴力求解 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int max = 0;
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j <nums.length; j++){
                max = Math.max((j-i) * Math.min(nums[i], nums[j]), max);
            }
        }
        return max;
    }

    /**
     * 时间复杂度 O(n)
     * @param nums
     * @return
     */
    public int solutionImprove(int[] nums){
        int max = 0;
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            max = Math.max((end-start) * Math.min(nums[start], nums[end]), max);
            if (nums[start] < nums[end]){
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater11Solution solution = new ContainerWithMostWater11Solution();
        System.out.println(solution.solutionImprove(nums));
    }
}
