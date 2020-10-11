package com.hou.leetcode.solution.design;

import java.util.*;

public class RandomPickIndex398Solution {
    Map<Integer, List<Integer>> map;
    Random random;
    /**
     * map key存放target， value存放target的下标用ArrayList存放，方便随机取值
     * @param nums
     */
    public RandomPickIndex398Solution(int[] nums) {
        map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            List list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list.size() == 1) {
            return list.get(0);
        }
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,3,3,3};
        RandomPickIndex398Solution solution = new RandomPickIndex398Solution(nums);
        System.out.println(solution.pick(4));
    }
}
