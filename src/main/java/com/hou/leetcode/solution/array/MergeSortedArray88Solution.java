package com.hou.leetcode.solution.array;

public class MergeSortedArray88Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int limit = m+n;
        while (limit > 0) {
            if (n==0 || (m > 0 && nums1[m-1] > nums2[n-1])) {
                nums1[limit-1] = nums1[m-1];
                m--;
            } else if (m==0 || (n > 0 && nums1[m-1] <= nums2[n-1])){
                nums1[limit-1] = nums2[n-1];
                n--;
            }
            limit--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{2};
        MergeSortedArray88Solution solution = new MergeSortedArray88Solution();
        solution.merge(nums1, 0, nums2, 1);
        System.out.println();
    }
}
