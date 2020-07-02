package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-06-30 12:38
 */
public class MinimumSwapsSequencesIncreasing801Solution {
    public int minSwap(int[] A, int[] B) {
        int[] change = new int[A.length];
        int[] noChange = new int[A.length];
        change[0] = 1;
        for (int i=1; i<A.length; i++) {
            //第一种场景 和前边已经递增，那么nochange[i]=nochange[i-1],change[i] = change[i]+1
            //第二种场景 和前边没有组成递增，那么就需要交换
            noChange[i] = i+1;
            change[i] = i+1;
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                noChange[i] = noChange[i-1];
                change[i] = change[i-1]+1;
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                change[i] = Math.min(change[i], noChange[i-1]+1);
                noChange[i] = Math.min(noChange[i], change[i-1]);
            }
        }
        return Math.min(noChange[A.length-1], change[A.length-1]);
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,4,4,5,9};
        int[] B = new int[]{0,1,6,8,10};
        MinimumSwapsSequencesIncreasing801Solution solution = new MinimumSwapsSequencesIncreasing801Solution();
        System.out.println(solution.minSwap(A, B));
    }
}
