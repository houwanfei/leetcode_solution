package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-03 12:50
 */
public class GrumpyBookstoreOwner1052Solution {
    /**
     * 滑动窗口，找到窗口内各个1对应的customer数最大，
     * 这里要注意，如果选择窗口内customer数最大，可能会出现0对应的最大，因此要选择窗口内1对应的customer数最大
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0, maxBegin = 0, maxEnd=0;
        int begin = 0;
        int oneCount = 0;
        for (int i=0; i<customers.length; i++) {
            if (grumpy[i] == 1) {
                oneCount += customers[i];
            }
            if (i-begin+1 > X) {
                if (grumpy[begin] == 1) {
                    oneCount -= customers[begin];
                }
                begin++;
            }
            if (oneCount > max) {
                maxBegin = begin;
                maxEnd = i;
                max = oneCount;
            }
        }
        int cusCount = 0;
        for (int i=0; i<customers.length; i++) {
            if (grumpy[i] != 1 || (i>=maxBegin && i<=maxEnd)) {
                cusCount += customers[i];
            }
        }
        return cusCount;
    }
    public static void main(String[] args) {
        GrumpyBookstoreOwner1052Solution solution = new GrumpyBookstoreOwner1052Solution();
        int[] customers = new int[]{4,10,10};
        int[] grumpy = new int[]{1,1,0};
        System.out.println(solution.maxSatisfied(customers, grumpy, 2));
    }
}
