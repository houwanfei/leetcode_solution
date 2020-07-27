package com.hou.leetcode.solution.binary;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-27 17:34
 */
public class FindKthSmallestPairDistance719Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0, right=nums[nums.length-1]-nums[0];
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(nums, mid) >=k) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private int check(int[] nums, int mid) {
        int count = 0;
        for (int i=nums.length-1; i>0;i--) {
            if (nums[i]-nums[0]<=mid) {
                count += i;
                continue;
            }
            int left=0, right=i-1;
            while (left <= right) {
                int mid2 = (left+right)/2;
                if (nums[i]-nums[mid2]<=mid) {
                    right = mid2-1;
                } else {
                    left = mid2+1;
                }
            }
            count += (i-left);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2};
        System.out.println(new FindKthSmallestPairDistance719Solution().smallestDistancePair(nums, 2));
    }
}
