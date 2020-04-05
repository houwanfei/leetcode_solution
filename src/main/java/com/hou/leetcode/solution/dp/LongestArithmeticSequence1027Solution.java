package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticSequence1027Solution {
    int res = 0;
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        backtracking(A, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(int[] A, List<Integer> tmp, int start) {
        if (tmp.size() >= 2) {
            int diff = tmp.get(1) - tmp.get(0);
            boolean yes = true;
            for (int i = 2; i < tmp.size(); i++) {
                if (diff != (tmp.get(i) - tmp.get(i-1))) {
                    yes = false;
                    break;
                }
            }
            if (yes) {
                res = Math.max(res, tmp.size());
            }
        }
        if (tmp.size() == A.length) {
            return;
        }
        for (int i=start; i<A.length; i++) {
            tmp.add(A[i]);
            backtracking(A, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public int longestArithSeqLength2(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 2;
        for (int i=0; i<A.length; i++) {
            Map<Integer, Integer> subMap = new HashMap<>();
            for (int j=0; j<i; j++) {
                int diff = A[i] - A[j];
                int max = Math.max(map.get(j).get(diff) == null?2:map.get(j).get(diff)+1,
                        subMap.get(diff) == null?2:subMap.get(diff));
                subMap.put(diff, max);
                result = Math.max(result, max);
            }
            map.put(i, subMap);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,6,9,12};
        LongestArithmeticSequence1027Solution solution = new LongestArithmeticSequence1027Solution();
        System.out.println(solution.longestArithSeqLength2(A));
    }
}
