package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-30 10:17
 */
public class LargestDivisibleSubset368Solution {
    private List<Integer> res;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(), 0, nums);
        return res;
    }

    private void helper(List<Integer> tmp, int start, int[] nums) {
        if (res == null || res.size() < tmp.size()) {
            res = new ArrayList<>(tmp);
        }
        for (int i=start; i<nums.length; i++) {
            if (tmp.size() == 0 || nums[i] % tmp.get(tmp.size()-1) == 0) {
                tmp.add(nums[i]);
                helper(tmp, i+1, nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        //
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;//最大值
        dp[0][1] = 0;//前驱
        int maxIndex = 0;
        int max = 0;
        for (int i=1; i<nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            for (int j=i-1; j>=0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j][0]+1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] +1;
                    dp[i][1] = j;
                    if (max <dp[i][0]) {
                        max = dp[i][0];
                        maxIndex = i;
                    }
                }
            }
        }
        int index = maxIndex;
        while (dp[index][1] != index) {
            result.add(nums[index]);
            index = dp[index][1];
        }
        if (dp[index][1] == index) {
            result.add(nums[index]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
        System.out.println(new LargestDivisibleSubset368Solution().largestDivisibleSubset2(nums));
    }
}
