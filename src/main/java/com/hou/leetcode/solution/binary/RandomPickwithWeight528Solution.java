package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-17 17:39
 */
public class RandomPickwithWeight528Solution {
    int[] sum = null;
    public RandomPickwithWeight528Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i=1; i<sum.length; i++) {
            sum[i] = sum[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int random = (int) (Math.random()*sum[sum.length-1])+1;
        int left=0,right=sum.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (sum[mid] >= random) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,4};
        RandomPickwithWeight528Solution solution = new RandomPickwithWeight528Solution(nums);
        for (int i=0; i<10; i++) {
            System.out.println(solution.pickIndex());
        }
    }
}
