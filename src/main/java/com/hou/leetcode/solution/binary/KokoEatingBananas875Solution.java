package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-13 16:53
 */
public class KokoEatingBananas875Solution {
    /**
     * 思路：二分查找，要找到一个每小时吃的数目，我们知道吃的速度越快，消耗的时间越短，但是速度也是有极限的，当超过最大堆的数量时
     * 就没用了，因此同一小时内最多只能吃一堆
     * 这里我们知道满足条件的值有多个，我们要找到最左边的那个，那么二分查找的结果使用left作为答案，
     * 再来看判断条件选择，因为要求最小，所以当mid的sum小于等于H时，right还应该左移，我们知道最终left肯定是满足条件且是最小的
     * 时间复杂度：O(n*logn)
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int sum = 0;
        int right = 0;
        for (int i=0; i<piles.length; i++) {
            if (right < piles[i]) {
                right = piles[i];
            }
            sum += piles[i];
        }
//        int left = 1;
        int left = (int) Math.ceil((sum * 1.0)/H); //优化，缩短left区间
        while (left <= right) {
            int mid = (left +right)/2;
            if (check(piles, mid) <= H) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int check(int[] piles, int mid) {
        int sum = 0;
        for (int i=0; i<piles.length; i++) {
            sum += Math.ceil(piles[i]*1.0/mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,7,11};
        System.out.println(new KokoEatingBananas875Solution().minEatingSpeed(nums, 8));
    }
}
