package com.hou.leetcode.solution;

public class BestTimeBuySellStock121 {
    public int solution(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                max = (nums[j]-nums[i])>max? (nums[j]-nums[i]) : max;
            }
        }
        return max;
    }

    public int solutionImprove(int[] prices){
        if (prices == null || prices.length<2)
            return 0;
        int minPrice = prices[0];
        int max = 0;
        for (int i=1; i<prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);
            max = Math.max((prices[i] - minPrice), max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        BestTimeBuySellStock121 sellStock121 = new BestTimeBuySellStock121();
        System.out.println(sellStock121.solution(nums));
        System.out.println(sellStock121.solutionImprove(nums));
    }
}
