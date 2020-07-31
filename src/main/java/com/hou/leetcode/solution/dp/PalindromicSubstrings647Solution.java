package com.hou.leetcode.solution.dp;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-31 17:12
 */
public class PalindromicSubstrings647Solution {
    public int countSubstrings(String s) {
        return helper(s.toCharArray(), s.length()-1);
    }

    /**
     * 暴力求解
     * @param sc
     * @param i
     * @return
     */
    private int helper(char[] sc, int i) {
        if (i == 0) {
            return 1;
        }
        int count = helper(sc, i-1);
        for (int j=i; j>=0; j--) {
            if (check(sc, j, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(char[] sc, int j, int i) {
        while (j <= i) {
            if (sc[j] != sc[i]) {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromicSubstrings647Solution solution = new PalindromicSubstrings647Solution();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<10; i++) {
            stringBuilder.append((char)('a'+random.nextInt(25)));
        }
        System.out.println(stringBuilder.toString());
        System.out.println(solution.countSubstrings(stringBuilder.toString()));
    }
}
