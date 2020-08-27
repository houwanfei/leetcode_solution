package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-26 11:54
 */
public class DeleteColumnsMakeSortedIII960Solution {

    public int minDeletionSize(String[] A) {
        int[][] memo = new int[A[0].length()+1][A[0].length()];
        for (int i=0;i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(A, A[0].length(), A[0].length()-1, memo);
    }

    private int helper(String[] A, int last, int curr, int[][] memo) {
        if (curr == -1) {
            return 0;
        }
        if (memo[last][curr] != -1) {
            System.out.println("dp");
            return memo[last][curr];
        }
        boolean flag = true;
        if (last != A[0].length()) {
            for (int i = 0; i < A.length; i++) {
                if (A[i].charAt(last) < A[i].charAt(curr)) {
                    flag = false;
                    break;
                }
            }
        }
        int res = helper(A, last, curr-1, memo)+1;
        if (flag) {
            res = Math.min(res, helper(A, curr, curr-1, memo));
        }
        return memo[last][curr]=res;
    }

    public static void main(String[] args) {
        DeleteColumnsMakeSortedIII960Solution solution = new DeleteColumnsMakeSortedIII960Solution();
        int N = 100;
        String[] A = new String[]{"abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba","acccbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba"};
//        String[] A = new String[N];
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        Random random = new Random();
//        for (int i=0; i<N;i++) {
//            stringBuilder.append("\"");
//            StringBuilder sb = new StringBuilder();
//            for (int j=0; j<N; j++) {
//                sb.append((char)(random.nextInt(26)+97));
//            }
//            A[i] = sb.toString();
//            stringBuilder.append(A[i]);
//            stringBuilder.append("\"");
//            if (i != N-1) {
//                stringBuilder.append(",");
//            }
//        }
//        stringBuilder.append("]");
//        System.out.println(stringBuilder.toString());
        System.out.println(solution.minDeletionSize(A));
    }
}
