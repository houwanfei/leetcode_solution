package com.hou.leetcode.solution.array;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-29 13:45
 */
public class NumberSubarraysBoundedMaximum795Solution {


    /**
     * 用两个指针记录满足条件的开始下标和当前start到i是满足条件的区间大小len
     * 1. 当A[i]满足条件，新增的数量 = i-start+1
     * 2. 当A[i]<L，新增的数量为start到最后一个满足条件的i这段区间的子数组len，因此数量=len
     * 3. 当A[i]>L,此时将start置为下一位,len=0
     * @param A
     * @param L
     * @param R
     * @return
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A.length == 0) {
            return 0;
        }
        int start = 0;
        int len = 0;
        int ans = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i]>= L && A[i] <= R) {
                ans += i-start+1;
                len = i-start+1;
            } else if (A[i] < L){
                ans += len;
            } else {
                start = i+1;
                len = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 1, 4, 3, 2, 1, 2,3,5};
        int M = 50000;
        int[] nums = new int[M];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        int max = (int) Math.pow(10, 9);
        for (int i=0; i<M; i++) {
            nums[i] = random.nextInt(max);
            stringBuilder.append(nums[i]);
            if (i<M-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        NumberSubarraysBoundedMaximum795Solution solution = new NumberSubarraysBoundedMaximum795Solution();
        System.out.println(solution.numSubarrayBoundedMax(nums, 2000, 100000000));
    }
}
