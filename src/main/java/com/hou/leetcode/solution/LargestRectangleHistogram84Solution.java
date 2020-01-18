package com.hou.leetcode.solution;

import java.util.Stack;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-18 14:39
 */
public class LargestRectangleHistogram84Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int height = 0;
        for (int i=0; i<=heights.length; i++) {
            if (i == heights.length)
                height = 0;
            else
                height = heights[i];
            while (!stack.empty() && heights[stack.peek()] > height) {
                int top = stack.pop();
                if (stack.empty()) {
                    max = Math.max(heights[top] * i, max);
                } else {
                    max = Math.max(heights[top] * (i - stack.peek()-1), max);
                }
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram84Solution solution = new LargestRectangleHistogram84Solution();
        int[] heights = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
