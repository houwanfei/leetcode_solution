package com.hou.leetcode.solution.str;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence60Solution {
    private Integer finish;
    public String getPermutation(int n, int k) {
        this.finish = 0;
        return backtracking(n, 0, new ArrayList<>(), new StringBuffer(), k);
    }

    private String backtracking(int n, int index,List<Integer> used, StringBuffer res, int k) {
        if (index == n) {
            finish++;
            if (finish == k) {
                return res.toString();
            } else {
                return null;
            }
        }
        for (int i=1; i<=n; i++) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            res.append(i);
            String result = backtracking(n, index+1, used, res, k);
            if (result != null) {
                return result;
            }
            res.deleteCharAt(res.length()-1);
            used.remove(used.size()-1);
        }
        return null;
    }

    public static void main(String[] args) {
        PermutationSequence60Solution solution = new PermutationSequence60Solution();
        System.out.println(solution.getPermutation(4, 9));
    }
}
