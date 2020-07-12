package com.hou.leetcode.solution.binary;



public class SumMutatedArrayClosestTarget1300Solution {
    public int findBestValue(int[] arr, int target) {
        int left=0, right;
        right = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (right < arr[i]) {
                right = arr[i];
            }
        }
        while (left <= right) {
            int mid = left + (right-left)/2;
            int diff = sumDiff(arr, target, mid);
            if (diff > 0) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        if (Math.abs(sumDiff(arr, target, left)) < Math.abs(sumDiff(arr, target, right))) {
            return left;
        } else {
            return right;
        }
    }

    private int sumDiff(int[] arr, int target, int mid) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            if (mid < arr[i]) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }
        return target - sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5};
        System.out.println(new SumMutatedArrayClosestTarget1300Solution().findBestValue(nums, 11));
    }
}
