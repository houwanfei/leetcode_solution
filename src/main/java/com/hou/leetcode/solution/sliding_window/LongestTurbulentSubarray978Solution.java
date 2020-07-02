package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-02 11:57
 */
public class LongestTurbulentSubarray978Solution {
    /**
     * 滑动窗口解法
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int max = 1;
        int flag = 0;//0-开始，1-大于，2-小于
        int len = 1;
        for (int i=1; i<A.length; i++) {
            if (A[i] == A[i-1]) {
                max = Math.max(max, len);
                len = 1;
                flag = 0;
            } else {
                if (flag == 0) {
                    len++;
                    if (A[i] > A[i-1]) {
                        flag = 1;
                    } else {
                        flag = 2;
                    }
                    max = Math.max(max, len);
                } else if (flag == 1) {
                    if (A[i] < A[i-1]) {
                        len++;
                        flag = 2;
                    } else {
                        max = Math.max(max, len);
                        len = 2;
                        flag = 1;
                    }
                } else {
                    if (A[i] > A[i-1]) {
                        len++;
                        flag = 1;
                    } else {
                        max = Math.max(max, len);
                        len = 2;
                        flag = 2;
                    }
                }
            }
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray978Solution solution = new LongestTurbulentSubarray978Solution();
        int[] A = new int[]{9,19};
        System.out.println(solution.maxTurbulenceSize(A));
    }
}
