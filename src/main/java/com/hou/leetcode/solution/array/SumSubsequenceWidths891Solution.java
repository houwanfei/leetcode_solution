package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-08 18:16
 */
public class SumSubsequenceWidths891Solution {
    private int sum = 0;
    public int sumSubseqWidths(int[] A) {
        int m = (int) Math.pow(10, 9) + 7;
        helper(A, A[0], A[0], 0, new ArrayList<>());
        return sum % m;
    }

    private void helper(int[] A, int min, int max, int index, List<Integer> tmp) {
        if (tmp.size() != 0) {
            sum += max - min;
        } else {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        for (int i=index; i<A.length; i++) {
            tmp.add(i);
            helper(A, Math.min(min, A[i]), Math.max(max, A[i]), i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public int sumSubseqWidths2(int[] A) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3};
        SumSubsequenceWidths891Solution solution = new SumSubsequenceWidths891Solution();
        System.out.println(solution.sumSubseqWidths(nums));
    }
}
