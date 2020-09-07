package com.hou.leetcode.solution.weekly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductTwoNumbersSolution {
    //超时
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            List<Integer> idx = map1.getOrDefault(nums1[i], new ArrayList<>());
            idx.add(i);
            map1.put(nums1[i], idx);
        }
        for (int i=0; i<nums2.length; i++) {
            List<Integer> idx = map2.getOrDefault(nums2[i], new ArrayList<>());
            idx.add(i);
            map2.put(nums2[i], idx);
        }
        int ans = 0;
        ans +=check(nums1, nums2, map2);
        ans +=check(nums2, nums1, map1);
        return ans;
    }

    private int check(int[] nums1, int[] nums2, Map<Integer, List<Integer>> map) {
        int ans = 0;
        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {
                long prod = (long)nums1[i]*(long)nums1[i];
                if (prod % nums2[j] != 0) {
                    continue;
                }
                int res = (int) (prod/nums2[j]);
                List<Integer> idx = map.get(res);
                if (idx == null) {
                    continue;
                }
                int num = 0;
                if (((num = checkIdx(idx, j)) == 0) || (res == nums2[j] && idx.size() == 1)) {
                    continue;
                }
                ans += num;
            }
        }
        return ans;
    }

    private int checkIdx(List<Integer> idx, int j) {
        for (int i=0; i<idx.size(); i++) {
            if (idx.get(i)>j) {
                return idx.size()-i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1};
        int[] nums2 = new int[]{1,1,1};
        ProductTwoNumbersSolution solution = new ProductTwoNumbersSolution();
        System.out.println((int)Math.pow(10, 10));
        System.out.println(solution.numTriplets(nums1, nums2));
    }
}
