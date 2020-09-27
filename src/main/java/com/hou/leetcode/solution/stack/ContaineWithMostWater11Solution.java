package com.hou.leetcode.solution.stack;

import java.util.ArrayList;
import java.util.List;

public class ContaineWithMostWater11Solution {
    public int maxArea(int[] height) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int max = -1;
        for (int i=1; i<height.length; i++) {
            int index = list.get(list.size()-1);
            for (Integer idx : list) {
                max = Math.max(Math.min(height[idx], height[i])*(i-idx), max);
            }
            if (height[index] < height[i]) {
                list.add(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        ContaineWithMostWater11Solution solution = new ContaineWithMostWater11Solution();
        System.out.println(solution.maxArea(nums));
    }
}
