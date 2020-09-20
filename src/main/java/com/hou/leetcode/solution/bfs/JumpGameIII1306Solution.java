package com.hou.leetcode.solution.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-10 9:50
 */
public class JumpGameIII1306Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visits= new boolean[arr.length];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) {
                return true;
            }
            visits[curr] = true;
            if (arr[curr]+curr < arr.length && !visits[arr[curr]+curr]) {
                queue.offer(arr[curr]+curr);
            }
            if (curr-arr[curr] >= 0 && !visits[curr-arr[curr]]) {
                queue.offer(curr-arr[curr]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameIII1306Solution solution = new JumpGameIII1306Solution();
        int[] arr = new int[]{3,0,2,1,2};
        System.out.println(solution.canReach(arr, 2));
    }
}
