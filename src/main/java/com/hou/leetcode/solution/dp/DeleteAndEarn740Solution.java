package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-03 15:02
 */
public class DeleteAndEarn740Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归超时
     *
     * @param nums
     * @param i
     * @param j
     * @return
     */
    private int helper(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        int max = 0;
        for (int k = i; k <= j; k++) {
            int point = nums[k];
            int m = k - 1;
            int n = k + 1;
            while (m >= i && nums[m] >= nums[k] - 1) {
                if (nums[m] == nums[k]) {
                    point += nums[m];
                }
                m--;
            }
            while (n <= j && nums[n] <= nums[k] + 1) {
                if (nums[n] == nums[k]) {
                    point += nums[n];
                }
                n++;
            }
            point += helper(nums, i, m);
            point += helper(nums, n, j);
            max = Math.max(max, point);
        }
        return max;
    }

    public int deleteAndEarn2(int[] nums) {
        Arrays.sort(nums);
        return helperWithMemo(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
    }

    /**
     * 递归-备忘录
     * 核心思想：先排序，这样 pick-1肯定在pick的左边，pick+1肯定在pick的右边，pick肯定被选出，因为pick+1、pick-1都被删除，pick不可能被删除
     * 因此通过pick将余下的数分为左右区间，分别求最大值
     * @param nums
     * @param i
     * @param j
     * @param memo
     * @return
     */
    private int helperWithMemo(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = i; k <= j; k++) {
            int point = nums[k];
            int m = k - 1;
            int n = k + 1;
            while (m >= i && nums[m] >= nums[k] - 1) {
                if (nums[m] == nums[k]) {
                    point += nums[m];
                }
                m--;
            }
            while (n <= j && nums[n] <= nums[k] + 1) {
                if (nums[n] == nums[k]) {
                    point += nums[n];
                }
                n++;
            }
            point += helperWithMemo(nums, i, m, memo);
            point += helperWithMemo(nums, n, j, memo);
            max = Math.max(max, point);
        }
        return memo[i][j] = max;
    }

    public static void main(String[] args) {
        DeleteAndEarn740Solution solution = new DeleteAndEarn740Solution();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int n = 100;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(10000);
            stringBuilder.append(nums[i] + ",");
        }
        System.out.println(stringBuilder.toString());
        System.out.println(solution.deleteAndEarn2(nums));
    }
}
