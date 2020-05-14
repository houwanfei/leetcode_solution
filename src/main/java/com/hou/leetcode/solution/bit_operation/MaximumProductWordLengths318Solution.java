package com.hou.leetcode.solution.bit_operation;

public class MaximumProductWordLengths318Solution {
    public int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                bit[i] |= (1 << (words[i].charAt(j)-'a'));
            }
        }
        int max = 0;
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if ((bit[i] & bit[j]) == 0) {
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new MaximumProductWordLengths318Solution().maxProduct(words));
    }
}
