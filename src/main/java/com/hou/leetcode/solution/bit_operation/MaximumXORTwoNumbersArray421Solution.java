package com.hou.leetcode.solution.bit_operation;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORTwoNumbersArray421Solution {

    /**
     * 位运算
     * a^b = max
     * a^b^b = a
     * 所以 b^max = a
     * 要求最大值，可以从高位开始一位一位求到最低位
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i=31; i>=0; i--) {
            Set<Integer> set = new HashSet<>();
            mask |= (1<<i);
            int candidate = (max|(1<<i));
            for (int num : nums) {
                int numMask = num&mask;
                if (set.contains(numMask^candidate)) {
                    max = candidate;
                    break;
                }
                set.add(numMask);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{14,70,53,83,49,91,36,80,92,51,66,70};
        MaximumXORTwoNumbersArray421Solution solution = new MaximumXORTwoNumbersArray421Solution();
        System.out.println(solution.findMaximumXOR(nums));
    }
}
