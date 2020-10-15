package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int top=0, buttom = matrix.length-1, left=0, right=matrix[0].length-1;
        while (top <= buttom && left<=right) {
            //上
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if (right >= left) {
                for (int i = top; i <= buttom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            if (buttom >= top) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[buttom][i]);
                }
                buttom--;
            }

            if (left <= right) {
                for (int i = buttom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        SpiralMatrix54Solution solution = new SpiralMatrix54Solution();
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println();
    }
}
