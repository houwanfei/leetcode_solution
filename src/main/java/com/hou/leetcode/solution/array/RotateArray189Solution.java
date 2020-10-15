package com.hou.leetcode.solution.array;

public class RotateArray189Solution {

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k = k%(nums.length);
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    private void reverse(int[] num, int i, int j) {
        while (i<j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        RotateArray189Solution solution = new RotateArray189Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        System.out.println();
    }
}
