package com.hou.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-03-30 16:24
 */
public class CountNumbersUniqueDigits357Solution {
    private Integer res = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        backtracking(n, new ArrayList<>(), 1);
        return res;
    }

    /**
     * 时间复杂度太高
     * @param n
     * @param tmp
     * @param start
     */
    private void backtracking(int n, List<Integer> tmp, int start) {
        if (tmp.size() != 0 && tmp.size() <= n) {
            res++;
            if (tmp.size() == n || (tmp.size()==1 && tmp.get(0) == 0)) {
                return;
            }
        }
        for (int j=0; j<10; j++)
            if (!tmp.contains(j)) {
                tmp.add(j);
                backtracking(n, tmp, start+1);
                tmp.remove(tmp.size()-1);
            }
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int pre = 10;
        for (int i=2; i<=n; i++) {
            int sum = 9;
            int index = 2;
            while (index <= i) {
                sum = sum * (9-index+2);
                index++;
            }
            pre = sum + pre;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersUniqueDigits357Solution().countNumbersWithUniqueDigits(3));
        System.out.println(new CountNumbersUniqueDigits357Solution().countNumbersWithUniqueDigits2(3));
    }
}
