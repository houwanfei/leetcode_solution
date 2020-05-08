package com.hou.leetcode.solution.bit_operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLengthUniqueCharacters1239Solution {
    private int res = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        int[] bits = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            String str = arr.get(i);
            for (int j=0; j<str.length(); j++) {
                bits[i] |= (1 << (str.charAt(j)-'a'));
            }
        }
        backtracking(0, arr, new ArrayList<>(), 0);
        return res;
    }

    private void backtracking(int start, List<String> arr, List<Integer> tmp, int cur) {
        if (start > arr.size()) {
            return;
        }
        int len = 0;
        for (Integer index : tmp) {
            len += arr.get(index).length();
        }
        res = Math.max(len, res);
        for (int i = start; i<arr.size(); i++) {
            String str = arr.get(i);
            int bit = 0;
            boolean check = true;
            for (int j=0; j<str.length(); j++) {
                if ((bit & (1 << (str.charAt(j)-'a'))) == 0) {
                    bit |= (1 << (str.charAt(j)-'a'));
                } else {
                    check = false;
                    break;
                }
            }
            if (!check || (cur & bit) != 0) {
                continue;
            }
            tmp.add(i);
            backtracking(i+1, arr, tmp, cur|bit);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("yy","bkhwmpbiisbldzknpm"));
        System.out.println(new MaxLengthUniqueCharacters1239Solution().maxLength(arr));
    }
}
