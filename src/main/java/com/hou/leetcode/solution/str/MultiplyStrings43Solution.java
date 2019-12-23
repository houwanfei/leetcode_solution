package com.hou.leetcode.solution.str;

public class MultiplyStrings43Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] c_num1 = num1.toCharArray();
        char[] c_num2 = num2.toCharArray();
        int[] res = new int[c_num1.length + c_num2.length];

        for (int i=c_num1.length-1; i>= 0; i--) {
            for (int j=c_num2.length-1; j>= 0;j--){
                res[(c_num1.length-1-i) + (c_num2.length-1-j)] += ((int)c_num1[i]-48) * ((int)c_num2[j]-48);
            }
        }

        int up = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<c_num1.length + c_num2.length; i++) {
            res[i] += up;
            sb.insert(0, res[i]%10);
            up = res[i]/10;
        }
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings43Solution solution = new MultiplyStrings43Solution();
        System.out.println(solution.multiply("123", "456"));
    }
}
