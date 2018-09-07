package com.hou.leetcode.solution.array;



/**
 * @auther houwanfei
 * @create 2018-09-07 上午10:17
 */
public class MedianOfTwoSortedArraysSolution {
    public double solution(int[] nums1, int[] nums2){
        int[] nums = merge(nums1, nums2);
        if (nums == null){
            return 0;
        }

        int mid = nums.length/2;
        if (nums.length % 2 == 0){
            return (Double.valueOf(nums[mid]) + Double.valueOf(nums[mid-1]))/2.0;
        } else {
            return nums[mid];
        }

    }

    private int[] merge(int[] nums1, int[] nums2){
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        while (i < nums1.length){
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length){
            nums[k++] = nums2[j++];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        MedianOfTwoSortedArraysSolution sortedArraysSolution = new MedianOfTwoSortedArraysSolution();

        //int[] nums = merge(nums1, nums2);
        System.out.println(sortedArraysSolution.solution(nums1, nums2));

    }
}
