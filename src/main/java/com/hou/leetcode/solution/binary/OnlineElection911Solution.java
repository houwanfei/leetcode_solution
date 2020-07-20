package com.hou.leetcode.solution.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-20 17:35
 */
public class OnlineElection911Solution {
    int[] win;
    int[] times;
    public OnlineElection911Solution(int[] persons, int[] times) {
        this.times = times;
        this.win = new int[times.length];
        Map<Integer, Integer> map = new HashMap<>();
        int curWin = persons[0];
        map.put(persons[0], 1);
        win[0] = persons[0];
        for (int i=1; i<times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0)+1);
            if (map.get(persons[i]) >= map.get(curWin)) {
                curWin = persons[i];
            }
            win[i] = curWin;
        }
    }

    public int q(int t) {
        int left =0, right = times.length-1;

        while (left <= right){
            int mid = (left+right)/2;
            if (times[mid] > t) {
                right = mid-1;
            } else {
                left = left+1;
            }
        }
        return win[right];
    }

    public static void main(String[] args) {
        int[] persons = new int[]{0};
        int[] times = new int[]{0};
        int[] test = new int[]{3,12,25,15,24,8};
        OnlineElection911Solution solution = new OnlineElection911Solution(persons, times);
        for (int i=0; i<test.length; i++) {
            System.out.println(solution.q(test[i]));
        }
    }
}
