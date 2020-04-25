package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-22 12:39
 */
public class TopKFrequentElements347Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Object[] mapArr = map.entrySet().toArray();
        buildMaxHeap(mapArr);
        int[] res = new int[k];
        int len = mapArr.length;
        for (int i=len-1; i>= len-k; i--) {
            res[len-1-i] = ((Map.Entry<Integer,Integer>)mapArr[0]).getKey();
            swap(mapArr, 0, i);
            helper(mapArr, 0, i);
        }
        return res;
    }

    private void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void buildMaxHeap(Object[] arr) {
        for (int i = arr.length/2; i>=0; i--) {
            helper(arr, i, arr.length);
        }
    }

    private void helper(Object[] arr, int i, int arrLen) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIndex = i;
        if (left < arrLen && ((Map.Entry<Integer,Integer>)arr[maxIndex]).getValue() < ((Map.Entry<Integer,Integer>)arr[left]).getValue()) {
            maxIndex = left;
        }
        if (right < arrLen && ((Map.Entry<Integer,Integer>)arr[maxIndex]).getValue() < ((Map.Entry<Integer,Integer>)arr[right]).getValue()) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            helper(arr, maxIndex, arrLen);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] res = new TopKFrequentElements347Solution().topKFrequent(nums, 2);
        System.out.println();
    }
}
