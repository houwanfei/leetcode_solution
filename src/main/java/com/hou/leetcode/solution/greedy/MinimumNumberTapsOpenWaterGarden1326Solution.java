package com.hou.leetcode.solution.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-03 17:23
 */
public class MinimumNumberTapsOpenWaterGarden1326Solution {
    public int minTaps(int n, int[] ranges) {
        List<Integer[]> list = new ArrayList<>();
        for (int i=0; i<ranges.length; i++) {
            Integer[] item = new Integer[2];
            item[0] = i-ranges[i];
            item[1] = i+ranges[i];
            list.add(item);
        }
        list.sort((o1, o2) -> {
            if (o2[1]-o1[1] == 0) {
                return o1[0]-o2[0];
            }
            return o2[1]-o1[1];
        });
        int ans = 1;
        Integer[] last = list.get(list.size()-1);
        Integer[] curr = null;
        for (Integer[] item : list) {
            if (last[0] <= 0) {
                return ans;
            }
            curr = item;
            if (curr[1] < last[0]) {
                return -1;
            }
            if (curr[0] < last[0]) {

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberTapsOpenWaterGarden1326Solution solution = new MinimumNumberTapsOpenWaterGarden1326Solution();
        int[] ranges = new int[]{3,4,1,1,0,0};
        System.out.println(solution.minTaps(5, ranges));
    }
}
