package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-20 15:58
 */
public class SingleNumberIII260Solution {
    /**
     * 位操作，根据相同的两个数异或操作结果为零，以异或操作对数组进行处理结果为x，但是这里有两个结果
     * 因此可以考虑分组处理，用x的倒数第一个1来划分，
     * 这里结果的两个数不可能同时为1，这样划分，相同的数也会被分到同一组然后再异或操作
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        if (nums.length == 0) {
            return new int[]{0, 0};
        }
        if (nums.length == 1) {
            return new int[]{nums[0], 0};
        }
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        //求倒数第一位用来分组
        int mark = x&(x-1)^x;
        int res1=0, res2=0;
        for (int num : nums) {
            if ((num&mark) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 2, 5};
        System.out.println(new SingleNumberIII260Solution().singleNumber(nums));
    }
}
