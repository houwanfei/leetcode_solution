package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK560Solution {

    /**
     * BF解法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j>=0; j--) {
                sum += nums[i];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * sum(i,j) = sum(0,j)-sum(0,i)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,2};
        SubarraySumEqualsK560Solution solution = new SubarraySumEqualsK560Solution();
        System.out.println(solution.subarraySum2(nums, 2));
    }
}
