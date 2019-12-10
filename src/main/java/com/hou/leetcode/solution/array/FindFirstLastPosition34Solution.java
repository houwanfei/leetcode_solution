package com.hou.leetcode.solution.array;

public class FindFirstLastPosition34Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1,-1};
        }
        int last = findLast(nums, target);
        return new int[] {first, last};
    }

    private int findFirst(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int s=0, e=nums.length-1;
        while (s < e) {
            int mid = (s + e)/2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid -1;
            } else {
                e = mid;
            }
        }
        return nums[s] == target? s : -1;
    }

    private int findLast(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int s=0, e=nums.length-1;
        while (s < e) {
            int mid = (s + e)/2 + 1;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid -1;
            } else {
                s = mid;
            }
        }
        return nums[e] == target ? e : -1;
    }

    public static void main(String[] args) {
        FindFirstLastPosition34Solution solution = new FindFirstLastPosition34Solution();
        int[] nums = new int[] {5,7,7,8,8,10};
        int[] nums2 = new int[] {1};
        System.out.println(solution.searchRange(nums, 8));
        System.out.println(solution.searchRange(nums2, 1));
    }
}
