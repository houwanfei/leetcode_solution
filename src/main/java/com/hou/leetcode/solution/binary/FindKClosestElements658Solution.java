package com.hou.leetcode.solution.binary;

import java.util.*;

public class FindKClosestElements658Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        List<Integer> res = new ArrayList<>();
        int idx1 = right;
        int idx2 = right+1;
        while (res.size() < k) {
            if (idx1>=0 && idx2 <= arr.length-1) {
                if (Math.abs(arr[idx1]-x) <= Math.abs(arr[idx2]-x)) {
                    res.add(arr[idx1--]);
                } else {
                    res.add(arr[idx2++]);
                }
            } else {
                if (idx1 < 0) {
                    res.add(arr[idx2++]);
                } else {
                    res.add(arr[idx1--]);
                }
            }
        }
        res.sort(Comparator.comparingInt(o -> o));
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,0,1,2,3,3,4,7,7,8};
        int[] nums = new int[]{1,2,3,3,4,7,7,10};
        System.out.println(new FindKClosestElements658Solution().findClosestElements(nums, 3, 6));
    }
}
