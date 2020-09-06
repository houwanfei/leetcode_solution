package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-24 13:59
 */
public class ScrambleString87Solution {
    /**
     * 递归
     * 思想：假设eat eta，只需要比较 (e at)和(e ta)、(e at)和(et a)、(ea t)和(et a)、(ea t)和(e ta)其中一个是否可以满足
     * 递归直到最后len==1时，比较两个字符是否相同
     * 一般化的情况，通过k来作为分隔的字符串的长度，分隔之后有两种状态交换和未交换，分隔处理的s1的子串要么以s2的开头的相同长度的子串，要么是以结尾的相同长度的子串
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return helper(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length(), new Boolean[s1.length()][s2.length()][s1.length()+1]);
    }

    private boolean helper(char[] chars1, char[] chars2, int i, int j, int len, Boolean[][][] memo) {
        if (len == 1 && chars1[i] == chars2[j]) {
            return true;
        }
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }
        boolean res = false;
        for (int k=1; k<len; k++) {
            res |= (helper(chars1, chars2, i, j, k, memo) && helper(chars1, chars2, i+k, j+k,len-k, memo));//未交换
            res |= (helper(chars1, chars2, i, j+len-k,k, memo) && helper(chars1, chars2, i+k, j,len-k, memo));//交换
        }
        return memo[i][j][len]=res;
    }

    public static void main(String[] args) {
        ScrambleString87Solution solution = new ScrambleString87Solution();
        System.out.println(solution.isScramble("agg", "gag"));
    }
}
