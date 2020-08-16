package com.hou.leetcode.solution.ali;


public class FormatStrSolution {
    public String reformatString(String str, int[] sublen) {
        char[] ans = new char[str.length()];
        char[] tmp = str.toCharArray();
        int len = sublen.length;
        if (sublen.length % 2 != 0) {
            len = sublen.length-1;
        }
        int index = 0;
        for (int i=0; i<len; i=i+2) {
            int begin = index;
            for (int j=0; j<sublen[i+1];j++) {
                ans[index++] = tmp[begin+sublen[i]+j];
            }
            for (int j=0; j<sublen[i];j++) {
                ans[index++] = tmp[begin+j];
            }
        }
        if (len < sublen.length) {
            for (int j=0; j<sublen[len]; j++) {
                ans[ans.length-1-j] = tmp[tmp.length-1-j];
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        FormatStrSolution solution = new FormatStrSolution();
        System.out.println(solution.reformatString("abcdefghi", new int[]{3, 2, 2, 2}));
    }
}
