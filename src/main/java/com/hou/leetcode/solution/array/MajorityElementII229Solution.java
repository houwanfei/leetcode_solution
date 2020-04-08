package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidated1=0,voted1=0,candidated2=0,voted2=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == candidated1) {
                voted1++;
            } else if (nums[i] == candidated2) {
                voted2++;
            } else if (voted1 == 0) {
                candidated1= nums[i];
                voted1=1;
            } else if (voted2 == 0) {
                candidated2 = nums[i];
                voted2 = 1;
            } else {
                voted1--;
                voted2--;
            }
        }
        voted1=0;
        voted2=0;
        for (int i=0; i<nums.length; i++) {
            if (candidated1 == nums[i]) {
                voted1++;
            } else if (candidated2 == nums[i]) {
                voted2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (voted1 > nums.length/3) {
            res.add(candidated1);
        }
        if (voted2 > nums.length/3) {
            res.add(candidated2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(new MajorityElementII229Solution().majorityElement(nums));
    }
}
