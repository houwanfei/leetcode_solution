package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-13 15:02
 */
public class GreatestSumDivisibleThree1262Solution {
    private int maxRes;

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        if (nums.length == 1) {
            if (nums[0]%3 == 0) {
                return nums[0];
            } else {
                return 0;
            }
        }
        backtracking(nums, 0, new ArrayList<>());
        return maxRes;
    }

    private void backtracking(int[] nums, int start, List<Integer> tmp) {
        int res = 0;
        for (Integer num : tmp) {
            res += num;
        }
        if (res % 3 == 0) {
            maxRes = Math.max(maxRes, res);
        }
        if (start >= nums.length) {
            return;
        }
        for (int i=start; i<nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    /**
     * 思路：求数组的和，如果和刚好整除3那就满足，
     * 如果余数为1，需要减去一个余数为1的数或者余数为2的两个最小和
     * 如果余数为2，需要减去一个余数为2的最小数或者两个余数为1的最小和
     * @param nums
     * @return
     */
    public int maxSumDivThree2(int[] nums) {
        if (nums.length == 1) {
            if (nums[0]%3 == 0) {
                return nums[0];
            } else {
                return 0;
            }
        }
        long dp1=Integer.MAX_VALUE, dp2 = Integer.MAX_VALUE, sum=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 3 == 1) {
                dp2 = Math.min(dp2, dp1+nums[i]);
                dp1 = Math.min(dp1, nums[i]);
            } else if (nums[i] % 3 == 2) {
                dp1 = Math.min(dp1, dp2 + nums[i]);
                dp2 = Math.min(dp2, nums[i]);
            }
            sum += nums[i];
        }
        if (sum % 3 == 0) {
            return (int)sum;
        }
        if (sum % 3 == 1) {
            return (int)(sum - dp1);
        }
        return (int)(sum - dp2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,2,2,7};
        System.out.println(new GreatestSumDivisibleThree1262Solution().maxSumDivThree2(nums));
    }
}
