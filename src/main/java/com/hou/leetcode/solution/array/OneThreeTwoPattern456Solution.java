package com.hou.leetcode.solution.array;

import java.util.Stack;

public class OneThreeTwoPattern456Solution {
    /**
     * 利用栈来从数组尾部查找满足的第二位和第三位，尽可能找大的值，栈中存的是候选的第三位
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i=nums.length-1;
        int third = Integer.MIN_VALUE;
        while (i>=0) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[i--]);
        }
        return false;
    }

    public static void main(String[] args) {
        OneThreeTwoPattern456Solution solution = new OneThreeTwoPattern456Solution();
        int[] nums = new int[]{-1,3,2,0};
        System.out.println(solution.find132pattern(nums));
    }
}
