package com.hou.leetcode.solution;

import com.hou.leetcode.solution.base.QuickSortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther houwanfei
 * @create 2018-09-14 下午3:57
 */
public class FourSum18Solution {
    public List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <4)
            return res;
        //排序
        QuickSortUtil.sort(0, nums.length-1, nums);
        for (int i=0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int newSum = target - (nums[i] + nums[j]);
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if ((nums[start] + nums[end]) > newSum) {
                        end--;
                    } else if ((nums[start] + nums[end]) < newSum) {
                        start++;
                    } else {
                        if (!checkContain(nums[i], nums[j], nums[start], nums[end], res)) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        }
                        start++;
                        end--;
                    }
                }
            }
        }

        return res;
    }

    private boolean checkContain(int i, int j, int m, int k, List<List<Integer>> res){
        for (List<Integer> list : res){
            if (list.get(0) == i && list.get(1) == j && list.get(2) == m && list.get(3) == k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        FourSum18Solution solution = new FourSum18Solution();
        List<List<Integer>> res = solution.solution(nums, 1);
        System.out.println("");
    }
}
