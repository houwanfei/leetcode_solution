package com.hou.leetcode.solution.stack;

public class RemoveKDigits402Solution {
    /**
     * 单调递增栈
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num == null || k==0) {
            return num;
        }
        char[] chars = num.toCharArray();
        int ansLen = num.length()-k;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            while (k>0 && stringBuilder.length()>0
                    && stringBuilder.charAt(stringBuilder.length()-1) > c) {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                k--;
            }
            stringBuilder.append(c);
        }
        String ans = stringBuilder.substring(0, ansLen);
        StringBuilder ansBuilder = new StringBuilder(ans);
        while (ansBuilder.length() >0 && ansBuilder.charAt(0) == '0') {
            ansBuilder.deleteCharAt(0);
        }
        return ansBuilder.length() == 0?"0":ansBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits402Solution solution = new RemoveKDigits402Solution();
        System.out.println(solution.removeKdigits("10", 2));
    }
}
