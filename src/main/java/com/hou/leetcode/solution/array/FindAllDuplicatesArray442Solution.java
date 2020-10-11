package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesArray442Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        while (i<nums.length) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[i] != i+1) {
                if (nums[nums[i]-1] == nums[i]) {
                    ans.add(nums[i]);
                    nums[i] = 0;
                    i++;
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[tmp-1];
                    nums[tmp-1] = tmp;
                }
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllDuplicatesArray442Solution solution = new FindAllDuplicatesArray442Solution();
        int[] nums = new int[]{2,1};
        List<Integer> res = solution.findDuplicates(nums);
        System.out.println();
    }
}
