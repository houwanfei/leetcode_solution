package com.hou.leetcode.solution.stack;

import java.util.Stack;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-19 10:14
 */
public class MaximalRectangle85Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(largestRectangleArea(heights), max);
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
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
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        MaximalRectangle85Solution solution = new MaximalRectangle85Solution();
        System.out.println(solution.maximalRectangle(matrix));
    }
}
