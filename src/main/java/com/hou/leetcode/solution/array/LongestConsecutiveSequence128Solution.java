package com.hou.leetcode.solution.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128Solution {

    /**
     * O(nlogn)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int ans = 0;
        while (i<nums.length) {
            int len =1;
            while (i+1<nums.length) {
                if (nums[i]+1==nums[i+1]){
                    len++;
                } else if(nums[i]!=nums[i+1]) {
                    break;
                }
                i++;
            }
            ans = Math.max(len, ans);
            i++;
        }
        return ans;
    }

    /**
     * 事先将数组存入Set中，然后前后连续搜索，搜索到的数字删除避免重复计算
     *
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            int count = 1;
            int next = num+1;
            while (next<Integer.MAX_VALUE && set.contains(next)) {
                count++;
                set.remove(next);
                next++;
            }
            int pre = num-1;
            while (pre>Integer.MIN_VALUE && set.contains(pre)) {
                count++;
                set.remove(pre);
                pre--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2,2};
        LongestConsecutiveSequence128Solution solution = new LongestConsecutiveSequence128Solution();
        System.out.println(solution.longestConsecutive2(nums));
    }
}
