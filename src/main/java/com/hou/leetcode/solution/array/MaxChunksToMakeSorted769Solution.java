package com.hou.leetcode.solution.array;

public class MaxChunksToMakeSorted769Solution {
    /**
     * 第一个块的元素个数为k，肯定包括[0,..,k]，循环直到结束
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int flag = 0;
        int sum = 0;
        int ans=0;
        for (int i=0; i<arr.length; i++) {
            flag |= (1<<arr[i]);
            sum |= (1 << i);
            if (flag == sum) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted769Solution solution = new MaxChunksToMakeSorted769Solution();
        int[] nums = new int[]{0};
        System.out.println(solution.maxChunksToSorted(nums));
    }
}
