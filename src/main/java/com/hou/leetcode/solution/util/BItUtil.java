package com.hou.leetcode.solution.util;

public class BItUtil {
    private static String getNumBIt(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            if ((num & 1) == 1) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
            num = (num >> 1);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getNumBIt(10));
    }
}
