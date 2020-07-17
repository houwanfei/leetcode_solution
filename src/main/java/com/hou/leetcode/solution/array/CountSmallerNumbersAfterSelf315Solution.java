package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        List<Integer> res = new CountSmallerNumbersAfterSelf315Solution().countSmaller(nums);
        System.out.println();
    }
}
