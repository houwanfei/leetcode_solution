package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-22 13:56
 */
public class FindValueMysteriousFunctionClosestTarget1521Solution {
    /**
     * 暴力求解 时间复杂度O(n^2)，利用a > a&b 所以 arr[i,j] >= arr[i,j+1]
     * @param arr
     * @param target
     * @return
     */
    public int closestToTarget(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            int mf = arr[i];
            for (int j=i; j<arr.length; j++) {
                mf &= arr[j];
                min = Math.min(Math.abs(mf-target), min);
                if (mf <= target){
                    break;
                }
            }
        }
        return min;
    }


    /**
     * 累加arr数组元素的对应位置的二进制，如果要算arr (i,j)范围的&，
     * 只需要求出arr元素在对应位上的计数==j-i，说明该位在每一个元素中都出现了
     *
     * 所以定义一个bits数组来存放位的累计，要求(i,j)范围的累计 只需要bits[j]-bit[i]，因为arr元素小于10^6
     * 因此20位就可以表示arr的所有可能数字
     *
     * 查找最终可能的下标，因为arr的&是递减的，所以找到第一个小于等于target的值，便是临界点，比较该值和最后一个大于target的值
     * 比较差的绝对值
     * @param arr
     * @param target
     * @return
     */
    public int closestToTarget2(int[] arr, int target) {
        int[][] bits = new int[arr.length+1][20];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<20; j++) {
                bits[i+1][j] = bits[i][j];
            }
            int j=0;
            while (arr[i] > 0) {
                if ((arr[i]&1) == 1) {
                    bits[i+1][j]++;
                }
                j++;
                arr[i]/=2;
            }
        }
        int[] andNums = new int[20];
        andNums[0] = 1;
        for (int i=1; i<20; i++) {
            andNums[i] = andNums[i-1]*2;
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            int left=i,right=arr.length-1;
            while (left <= right) {
                int mid = (left+right)/2;
                int val = 0;
                for (int j=0; j<20; j++) {
                    if (bits[mid+1][j]-bits[i+1][j] == (mid-i)) {
                        val += andNums[j];
                    }
                }
                if (val <= target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            int leftSum = 0;
            for (int j=0; j<20; j++) {
                if (bits[left][j]-bits[i][j] == (left-i)) {
                    leftSum += andNums[j];
                }
            }
            int rightSum = 0;
            for (int j=0; j<20; j++) {
                if (bits[right][j]-bits[i][j] == (right-i)) {
                    rightSum += andNums[j];
                }
            }
            ans = Math.min(Math.min(Math.abs(leftSum-target), Math.abs(rightSum-target)), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        //arr = [9,12,3,7,15], target = 5
        FindValueMysteriousFunctionClosestTarget1521Solution solution = new FindValueMysteriousFunctionClosestTarget1521Solution();
        int[] arr = new int[]{70,15,21,96};
        System.out.println(solution.closestToTarget2(arr, 4));
    }
}
