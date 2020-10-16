package com.hou.leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-16 15:10
 */
public class KDiffPairsArray532Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            if (k == 0) {//第一次计算k==0时相等的数组合
                ans += (map.get(num) == 2?1:0);
            } else if (map.get(num) == 1){//第一次才计算
                if (map.containsKey(num-k)) {
                    ans++;
                }
                if (map.containsKey(num+k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KDiffPairsArray532Solution solution = new KDiffPairsArray532Solution();
        int[] nums = new int[]{1,2,4,4,3,3,0,9,2,3};
        System.out.println(solution.findPairs(nums, 3));
    }
}
