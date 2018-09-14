package com.hou.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther houwanfei
 * @create 2018-09-14 下午1:59
 */
public class ThreeSum15Solution {

    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <3)
            return res;
        //排序
        sort(0, nums.length-1, nums);
        for (int i=0; i<nums.length; i++){
            int newSum = 0 - nums[i];
            int start = i+1;
            int end = nums.length - 1;
            while (start < end){
                if ((nums[start] + nums[end]) > newSum){
                    end--;
                } else if ((nums[start] + nums[end]) < newSum){
                    start++;
                } else {
                    if (!checkContain(nums[i], nums[start], nums[end], res)) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }
                    start++;
                    end--;
                }
            }
        }

        return res;
    }

    private boolean checkContain(int i, int j, int m, List<List<Integer>> res){
        for (List<Integer> list : res){
            if (list.get(0) == i && list.get(1) == j && list.get(2) == m){
                return true;
            }
        }
        return false;
    }

    private void sort(int start, int end, int[] nums){
        if (start >= end)
            return;
        int mark = nums[start];
        int low = start;
        int high = end;
        while (start < end){
            while (end > start && nums[end] >= mark){
                end--;
            }
            if (start < end)
                nums[start++] = nums[end];

            while (start < end && nums[start] <= mark){
                start++;
            }
            if (end > start)
                nums[end--] = nums[start];
        }
        nums[end] = mark;
        sort(low, end, nums);
        sort(end+1, high, nums);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum15Solution solution = new ThreeSum15Solution();
        List<List<Integer>> res = solution.solution(nums);
        System.out.println("");
    }


}
