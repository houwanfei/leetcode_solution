package com.hou.leetcode.solution.heap;


import java.util.ArrayList;
import java.util.List;

public class TopKSolution {
    public List<Integer> topK(int[] nums, int K) {
        List<Integer> ans = new ArrayList<>();
        buildMaxHeap(nums);
        for (int i=nums.length-1; i>=nums.length-K; i--) {
            ans.add(nums[0]);
            swap(nums, 0, i);
            sink(nums, 0, i);
        }
        return ans;
    }

    private void buildMaxHeap(int[] nums) {
        for (int i=(nums.length-1)/2; i>=0; i--) {
            sink(nums, i, nums.length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void sink(int[] nums, int i, int len) {
        while (i < len) {
            int son = 2 *(i+1)-1;
            if (son >= len) {
                break;
            }
            if (son+1 < len && nums[son] < nums[son+1]) {
                son++;
            }
            if (nums[i] > nums[son]) {
                break;
            }
            swap(nums, i, son);
            i = son;
        }
    }

    public static void main(String[] args) {
        TopKSolution solution = new TopKSolution();
        int[] nums = new int[]{11,1,2,3,4,5,10,7,8,9};
        List<Integer> ans = solution.topK(nums, 2);
        System.out.println();
    }
}
