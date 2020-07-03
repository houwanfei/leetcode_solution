package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-03 12:33
 */
public class MaxConsecutiveOnesIII1004Solution {
    /**
     * 滑动窗口解法，记录窗口内0的数量，如果大于k，那么窗口就后移到窗口内第一个0出现的后一个位置
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int begin = 0, max = 0, zoreCount = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] == 0) {
                zoreCount++;
            }
            while (zoreCount > K) {
                if (A[begin] == 0) {
                    zoreCount--;
                }
                begin++;
            }
            max = Math.max(max, i-begin+1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII1004Solution solution = new MaxConsecutiveOnesIII1004Solution();
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(solution.longestOnes(nums, 2));
    }
}
