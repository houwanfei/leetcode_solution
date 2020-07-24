package com.hou.leetcode.solution.array;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-15 17:22
 */
public class CountSmallerNumbersAfterSelf315Solution {
    /**
     * 超时
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        for (int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    /**
     * 还是超时 最坏时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int[][] segmentTree = new int[4*nums.length][2];
        initTree(segmentTree, 0, nums.length-1, 1, nums);
        for (int i=0; i<nums.length; i++) {
            int count = rangeQuery(segmentTree, 0, nums.length-1, nums[i], 1, i+1, nums.length-1);
            res.add(count);
        }
        return res;
    }

    private void initTree(int[][] segTree, int left, int right, int index, int[] nums) {
        if (left == right) {
            segTree[index][0] = nums[left];
            segTree[index][1] = nums[left];
            return;
        }
        int mid = (left+right)/2;
        initTree(segTree, left, mid, index*2, nums);
        initTree(segTree, mid+1, right, index*2+1, nums);
        segTree[index][0] = Math.max(segTree[2*index][0], segTree[2*index+1][0]);
        segTree[index][1] = Math.min(segTree[2*index][1], segTree[2*index+1][1]);
    }

    private int rangeQuery(int[][] segTree, int left, int right, int target, int index, int i, int j) {
        if (right<i || j<left || segTree[index][1] >= target) {
            return 0;
        }
        if (i<=left && j>=right && segTree[index][0]<target) {
            System.out.println("(" + left + "," + right + ") index:" + index);
            return right - left + 1;
        }
        if (left == right) {
            return 0;
        }
        int mid = (left+right)/2;
        return rangeQuery(segTree, left, mid, target, 2*index, i, j)
                +rangeQuery(segTree, mid+1, right, target,2*index+1, i, j);
    }

    public List<Integer> countSmaller3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int[] idxs = new int[nums.length];
        for (int i=0;i<nums.length; i++) {
            idxs[i] = i;
        }
        int[] counts = new int[nums.length];
        mergeSort(nums, counts, idxs, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
            res.add(counts[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] counts, int[] idx, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSort(nums, counts, idx, left, mid);
        mergeSort(nums, counts, idx, mid+1, right);
        int j=mid+1;
        for (int i=left; i<=mid; i++) {
            while (j <=right && nums[i] > nums[j]) {
                j++;
            }
            counts[idx[i]] += j-(mid+1);
        }
        merge(nums, idx, left, right);
    }

    private void merge(int[] nums,int[] idx, int left, int right) {
        int mid = (left+right)/2;
        int i=left,j=mid+1;
        int[] tmp = new int[right-left+1];
        int[] tmpIdx = new int[right-left+1];
        int k =0;
        while (i <=mid && j<=right) {
            if (nums[i] > nums[j]) {
                tmp[k] = nums[j];
                tmpIdx[k] = idx[j];
                j++;
            } else {
                tmp[k] = nums[i];
                tmpIdx[k] = idx[i];
                i++;
            }
            k++;
        }
        while (i<=mid) {
            tmp[k] = nums[i];
            tmpIdx[k] = idx[i];
            i++;
            k++;
        }
        while (j<=right) {
            tmp[k] = nums[j];
            tmpIdx[k] = idx[j];
            j++;
            k++;
        }
        for (int m=0; m<k;m++) {
            nums[left+m] = tmp[m];
            idx[left+m] = tmpIdx[m];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5183,2271,3067,539,8939,2999,9264,737,3974,5846};
        CountSmallerNumbersAfterSelf315Solution solution = new CountSmallerNumbersAfterSelf315Solution();
        List<Integer> res = solution.countSmaller3(nums);
        System.out.println();
    }
}
