package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-16 18:05
 */
public class TwoSumII167Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i< numbers.length; i++){
            int low =i+1,hi=numbers.length-1;
            int target2 = target-numbers[i];
            while (low <= hi) {
                int mid=(low + hi)/2;
                if (numbers[mid] < target2){
                    low = mid+1;
                } else if (numbers[mid] > target2){
                    hi = mid-1;
                } else {
                    return new int[]{i+1, mid+1};
                }
            }
        }
        return new int[]{numbers.length-1, numbers.length};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] nums2 = new int[]{12,83,104,129,140,184,199,300,306,312,321,325,341,344,349,356,370,405,423,444,446,465,471,491,500,506,508,530,539,543,569,591,606,607,612,614,623,627,645,662,670,685,689,726,731,737,744,747,764,773,778,787,802,805,811,819,829,841,879,905,918,918,929,955,997};
        TwoSumII167Solution solution = new TwoSumII167Solution();
        int[] res = solution.twoSum(nums2, 789);
        System.out.println();
    }
}
