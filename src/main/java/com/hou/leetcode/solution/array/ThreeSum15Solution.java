package com.hou.leetcode.solution.array;

import com.hou.leetcode.solution.base.QuickSortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther houwanfei
 * @create 2018-09-14 下午1:59
 */
public class ThreeSum15Solution {

    /**
     * 时间复杂的：O(n^2)
     * 思路：从2sum中可以得知2sum经过排序后可以做到O(n)
     * 所以3sum可以先固定一位之后将3sum问题转换为2sum问题
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <3)
            return res;
        //排序
        QuickSortUtil.sort(0, nums.length-1, nums);
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


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum15Solution solution = new ThreeSum15Solution();
        List<List<Integer>> res = solution.solution(nums);
        System.out.println("");
    }


}
