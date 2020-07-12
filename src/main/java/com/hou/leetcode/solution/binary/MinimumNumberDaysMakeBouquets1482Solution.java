package com.hou.leetcode.solution.binary;

public class MinimumNumberDaysMakeBouquets1482Solution {
    /**
     * 以开花的天数为二分
     * 时间复杂度：O(nlogn) 二分时间复杂度logn，遍历求花束数 O(n)
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k > bloomDay.length) {
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i=0; i<bloomDay.length; i++) {
            if (right < bloomDay[i]) {
                right = bloomDay[i];
            }
        }
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(bloomDay,k,mid) >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int check(int[] bloomDay, int k, int day) {
        int m = 0;
        int len = 0;
        for (int i=0; i<bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                len++;
            } else {
                len = 0;
            }
            if (len == k) {
                m++;
                len = 0;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] bloomDay = new int[]{1,10,2,9,3,8,4,7,5,6};
        MinimumNumberDaysMakeBouquets1482Solution solution = new MinimumNumberDaysMakeBouquets1482Solution();
        System.out.println(solution.minDays(bloomDay, 4, 2));

    }
}
