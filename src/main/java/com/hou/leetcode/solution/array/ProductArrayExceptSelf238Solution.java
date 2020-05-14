package com.hou.leetcode.solution.array;

public class ProductArrayExceptSelf238Solution {
    /**
     * 时间复杂度和空间复杂度都是O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] pres = new int[nums.length];
        int[] sufs = new int[nums.length];
        int pre = 1;
        int suf = 1;
        for (int i=0; i<nums.length; i++) {
            pre *= nums[i];
            suf *= nums[nums.length-1-i];
            pres[i] = pre;
            sufs[nums.length-1-i] = suf;
        }
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i-1<0) {
                res[i] = sufs[i+1];
            } else if (i+1 > nums.length-1) {
                res[i] = pres[i-1];
            } else {
                res[i] = pres[i-1] * sufs[i+1];
            }
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int suf = 1;
        for (int i=0; i<nums.length; i++) {
            suf *= nums[nums.length-1-i];
            res[nums.length-1-i] = suf;
        }
        int pre = 1;
        for (int i=0; i<nums.length; i++) {
            if (i-1<0) {
                res[i] = res[i+1];
            } else if (i+1 > nums.length-1) {
                res[i] = pre;
            } else {
                res[i] = pre * res[i+1];
            }
            pre *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] res = new ProductArrayExceptSelf238Solution().productExceptSelf2(nums);
        System.out.println();
    }
}
