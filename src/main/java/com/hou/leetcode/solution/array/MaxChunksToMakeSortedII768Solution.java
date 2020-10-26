package com.hou.leetcode.solution.array;


public class MaxChunksToMakeSortedII768Solution {
    /**
     * 思路，MaxChunksToMakeSorted题目是规定了数字是arr[i]范围是[0,arr.length-1]，因此可以用max和i比较
     * 这道题arr[i]范围不是，因此需要有一个顺序参照，先将arr复制一个数组排序，
     * 因此arr[0:k]的元素肯定和sortArr[0:k]一样,利用累加和方式来计算前k个元素是否相同
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int[] sortArr = new int[arr.length];
        System.arraycopy(arr, 0, sortArr, 0, arr.length);
        sort(sortArr, 0, arr.length-1);
        long sum1 = 0;
        long sum2 = 0;
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            sum1 += arr[i];
            sum2 += sortArr[i];
            if (sum1 == sum2) {
                ans++;
            }
        }
        return ans;
    }

    private void sort(int[] arr, int i, int j) {
        if (i>= j) {
            return;
        }
        int start=i, end=j;
        int mark = arr[i];
        while (i < j) {
            while(i < j && arr[j] >= mark) {
                j--;
            }
            if (i<j) {
                arr[i++] = arr[j];
            }
            while (i<j && arr[i] <= mark) {
                i++;
            }
            if (i<j) {
                arr[j--] = arr[i];
            }
        }
        arr[j] = mark;
        sort(arr, start, j);
        sort(arr, j+1, end);
    }

    /**
     * 思想：假设arr(i,j)可以满足条件，那么j之后的值的最小值都大于arr(i,j)，
     * 所以维护两个数组，一个是从前向后最大值，一个从后向前记录最小值，
     * 判断i时，如果max[i]<=min[i+1]，说明i这里是可以满足切割
     * @param arr
     * @return
     */
    public int maxChunksToSorted2(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        max[0] = arr[0];
        min[arr.length-1] = arr[arr.length-1];
        for (int i=1; i<arr.length; i++) {
            max[i] = Math.max(arr[i], max[i-1]);
        }
        for (int i=arr.length-2; i>=0; i--) {
            min[i] = Math.min(arr[i], min[i+1]);
        }
        int ans = 1;
        for (int i=0; i<arr.length-1; i++) {
            if (max[i] <= min[i+1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII768Solution solution = new MaxChunksToMakeSortedII768Solution();
        int[] arr = new int[]{1,1,0,0,1};
        System.out.println(solution.maxChunksToSorted2(arr));
    }
}
