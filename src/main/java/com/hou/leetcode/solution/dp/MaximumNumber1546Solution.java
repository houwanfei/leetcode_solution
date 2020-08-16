package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaximumNumber1546Solution {
    /**
     * dp思想 但是很慢，因为两层循环从尾部查找第一个满足条件的元素很慢
     * @param nums
     * @param target
     * @return
     */
    public int maxNonOverlapping(int[] nums, int target) {
        int[] pre = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            pre[i+1] = pre[i]+nums[i];
        }
        int[] dp = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++) {
            dp[i] = dp[i-1];
            for (int j=i-1; j>=0; j--) {
                if (pre[i] - pre[j] == target) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    break;
                }
            }
        }
        return dp[nums.length];
    }

    public int maxNonOverlapping2(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        int sum = 0;
        int ans = 0;
        dp.put(0, 0);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (dp.containsKey(sum-target)) {
                ans = Math.max(ans, dp.get(sum-target)+1);
            }
            dp.put(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumber1546Solution solution = new MaximumNumber1546Solution();
        int N = 100000;
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        for (int i=0; i<N; i++) {
            int flag = random.nextInt(3) > 1?-1:1;
            nums[i] = random.nextInt(10000) * flag;
            stringBuilder.append(nums[i]).append(",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.maxNonOverlapping(nums, 40000));
        System.out.println("begin2:" + System.currentTimeMillis());
        System.out.println(solution.maxNonOverlapping2(nums, 40000));
        System.out.println("end:" + System.currentTimeMillis());
    }
}
