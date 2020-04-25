package com.hou.leetcode.solution.str;

import java.util.*;

public class RepeatedDNASequences187Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> find = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        for (int i=0; i<s.length()-9; i++) {
            String sub = s.substring(i, i+10);
            if (!find.add(sub)) {
                repeat.add(sub);
            }
        }
        return new ArrayList<>(repeat);
    }

    public static void main(String[] args) {
        RepeatedDNASequences187Solution solution = new RepeatedDNASequences187Solution();
        List<String> res = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println();
    }
}
