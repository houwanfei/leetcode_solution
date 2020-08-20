package com.hou.leetcode.solution.dp;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-20 9:54
 */
public class RemoveBoxes546Solution {
    public int removeBoxes(int[] boxes) {
        return helper(boxes, new ArrayList<>());
    }

    private int helper(int[] boxes, List<Integer> used) {
        if (used.size() == boxes.length) {
            return 0;
        }
        int i=0;
        int max = Integer.MIN_VALUE;
        while (i<boxes.length) {
            if (used.contains(i)) {
                i++;
                continue;
            }
            int k = i;
            int point = 0;
            while (k < boxes.length && (boxes[i] == boxes[k] || used.contains(k))) {
                if (boxes[i] == boxes[k]) {
                    point++;
                    used.add(k);
                }
                k++;
            }
            max = Math.max(max, point*point  + helper(boxes, used));
            i = k;
            while (point > 0) {
                used.remove(used.size()-1);
                point--;
            }
        }
        return max;
    }

    /**
     * 思路：要求(i,j)范围内的最大值
     * 1. i在i+1后边没有出现，那么(1*1) + helper(i+1, j)
     * 2. 如果在后边有出现，那就以出现的位置m分组，分为左右区间(i+1, m-1)和(m,j)，左边可以保证是没有boxes[i]的值
     * 右边可能有，所以应该将boxse[i]出现的次数带到右边继续计算，最终求不同m位置分割的最大值，包含第1中场景的
     * @param boxes
     * @return
     */
    public int removeBoxes2(int[] boxes) {
        return helper(boxes, 0, boxes.length-1, 0, new int[boxes.length][boxes.length][boxes.length]);
    }

    private int helper(int[] boxes, int i, int j, int k, int[][][] memo) {
        if (j<i) {
            return 0;
        }
        if (memo[i][j][k] > 0) {
            return memo[i][j][k];
        }
        int max = (k+1)*(k+1) + helper(boxes, i+1, j, 0, memo);
        for (int m=i+1; m<=j; m++) {
            if (boxes[i] == boxes[m]) {
                max = Math.max(max, helper(boxes, i+1, m-1, 0, memo)+helper(boxes, m, j, k+1, memo));
            }
        }
        return memo[i][j][k]=max;
    }

    public static void main(String[] args) {
        RemoveBoxes546Solution solution = new RemoveBoxes546Solution();
        int[] boxes = new int[]{2,1,3,2,2,2,3};
//        int N = 100;
//        int[] boxes = new int[N];
//        Set<Integer> set = new HashSet<>();
//        Random random = new Random();
//        for (int i=0; i<50; i++) {
//            set.add(random.nextInt(N));
//        }
//        List<Integer> list = new ArrayList<>(set);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        for (int i=0; i<N; i++) {
//            boxes[i] = list.get(random.nextInt(list.size()));
//            stringBuilder.append(boxes[i]);
//            if (i != N-1) {
//                stringBuilder.append(",");
//            }
//        }
//        stringBuilder.append("]");
//        System.out.println(stringBuilder.toString());
        System.out.println(solution.removeBoxes2(boxes));
    }
}
