package com.hou.leetcode.solution.binary;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-23 12:29
 */
public class OnlineMajorityElementSubarray1157Solution {
    int[] arr = null;
    Map<Integer, List<Integer>> map;
    Random random;

    /**
     * 随机化算法 首先构造一个map记录 每个数字出现的下标，存于一个List中，
     * 两个位置(left,right)在List中的下标差值则为在(left,right)区间内出现的次数
     * 可以用二分查找这两个位置
     *
     * 用随机算法猜众数 然后验证
     * @param arr
     */
    public OnlineMajorityElementSubarray1157Solution(int[] arr) {
        map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        this.random = new Random();
        this.arr = arr;
    }


    public int query(int left, int right, int threshold) {
        int len = right-left+1;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<30; i++) {
            int rand = random.nextInt(len)+left;
            if (set.contains(rand)) {
                continue;
            }
            set.add(rand);
            int leftIdx = binaryLeftSearch(map.get(arr[rand]), left);
            int rightIdx = binaryRightSearch(map.get(arr[rand]), right);
            if (rightIdx-leftIdx+1 >= threshold) {
                return arr[rand];
            }
        }
        return -1;
    }

    private int binaryLeftSearch(List<Integer> list, int target) {
        int left=0, right = list.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (list.get(mid) >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private int binaryRightSearch(List<Integer> list, int target) {
        int left=0, right = list.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (list.get(mid) > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,2,1,3,1,1,1,2,3,3,3,1,1,1,2,2,3,3,2,2,1,1,1,2,1,3,1,1,2,3,1,3,3,1,3,2,2,2,3,2,3,1,2,1,3,3,3,2,2,1,1,2,2,3,2,3,3,3,2,1,2,3,1,3,2,3,1,2,3,3,2,2,2,2,2,2,3,2,3,2,3,3,1,2,3,3,3,3,3,3,3,2,1,1,2,1,2,2};
        System.out.println(arr.length);
        int count = 0;
        for (int i=31; i<=97; i++) {
            if (arr[i] == 3) {
                count++;
            }
        }
        System.out.println(count);
        OnlineMajorityElementSubarray1157Solution subarray1157Solution = new OnlineMajorityElementSubarray1157Solution(arr);
        System.out.println(subarray1157Solution.query(31,97,34));
    }
}
