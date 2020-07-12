package com.hou.leetcode.solution.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubarraysKDifferentIntegers992Solution {
    /**
     * 暴力求解
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int ans = 0;
        for (int i=0; i<A.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=i; j<A.length; j++) {
                map.put(A[j], map.getOrDefault(A[j], 0)+1);
                if (map.size() == K) {
                    ans++;
                } else if (map.size() > K) {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 优化暴力求解，上边的答案，我们每次移动i，j都要重新退到i，
     * 可以用两个指针记录前一次计算结果，用一个指针记录匹配的满足条件的最小下标，一个指针记录匹配的最大下标，
     * 它们的差值就是i-j内满足条件的子数组数，每次i移动时，只需要移动两个指针找到新的下标位置
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct2(int[] A, int K) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        int left=0,right=0;
        for (int i=0; i<A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            map1.put(A[i], map1.getOrDefault(A[i], 0)+1);
            while (left <= i && map.size() > K) {
                int count = map.get(A[left]);
                if (count == 1) {
                    map.remove(A[left]);
                } else {
                    map.put(A[left], count-1);
                }
                left++;
            }
            while (right <= i && map1.size() >= K) {
                int count = map1.get(A[right]);
                if (count == 1) {
                    map1.remove(A[right]);
                } else {
                    map1.put(A[right], count-1);
                }
                right++;
            }
            ans += (right-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraysKDifferentIntegers992Solution solution = new SubarraysKDifferentIntegers992Solution();
        int[] nums = new int[]{1,2,1,2,3};
        System.out.println(solution.subarraysWithKDistinct2(nums, 2));
    }
}
