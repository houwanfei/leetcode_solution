package com.hou.leetcode.solution.array;

public class SortColors75Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0||nums.length ==1){
            return;
        }
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num] ++;
        }

        int index = 0;
        for (int i=0; i< 3; i++) {
            int end = index + colors[i];
            while (index < end) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        SortColors75Solution sortColors75Solution = new SortColors75Solution();
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors75Solution.sortColors(nums);
        System.out.println();
    }
}
