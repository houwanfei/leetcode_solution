package com.hou.leetcode.solution.util;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<String> resStrs = grayCode2(n);
        resStrs.forEach(p -> res.add(Integer.parseInt(p, 2)));
        return res;
    }

    private List<String> grayCode2(int n) {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            for (int i=0; i<2; i++) {
                list.add(String.valueOf(i));
            }
            return list;
        }
        List<String> res = grayCode2(n-1);
        List<String> newRes = new ArrayList<>();
        for (int i=0; i<res.size() ;i++) {
            newRes.add(0 + res.get(i));
        }
        for (int i=res.size()-1; i>=0 ;i--) {
            newRes.add(1 + res.get(i));
        }
        return newRes;
    }

    public static void main(String[] args) {
        GrayCode89Solution solution = new GrayCode89Solution();
        List<Integer> res = solution.grayCode(2);
        System.out.println();
    }
}
