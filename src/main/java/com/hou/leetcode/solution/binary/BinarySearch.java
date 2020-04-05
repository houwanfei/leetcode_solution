package com.hou.leetcode.solution.binary;

public class BinarySearch {
    /**
     * 搜索第一个小于key的下标
     * @param nums
     * @return
     */
    public int soultion1(int[] nums, int key) {
        int left = 0;
        int rigit = nums.length-1;
        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (nums[mid] >= key) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }
        return rigit;
    }

    /**
     * 搜索第一个大于等于key的下标
     * @param nums
     * @param key
     * @return
     */
    public int soultion2(int[] nums, int key) {
        int left = 0;
        int rigit = nums.length-1;
        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (nums[mid] >= key) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    /**
     * 搜索第一个大于key的下标
     * @param nums
     * @param key
     * @return
     */
    public int soultion3(int[] nums, int key) {
        int left = 0;
        int rigit = nums.length-1;
        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (nums[mid] > key) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    /**
     * 搜索第一个小于等于key的下标
     * @param nums
     * @return
     */
    public int soultion4(int[] nums, int key) {
        int left = 0;
        int rigit = nums.length-1;
        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (nums[mid] > key) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }
        return rigit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(new BinarySearch().soultion1(nums, 8));
        System.out.println(new BinarySearch().soultion2(nums, 9));
        System.out.println(new BinarySearch().soultion3(nums, 7));
        System.out.println(new BinarySearch().soultion4(nums, 7));
    }
}
