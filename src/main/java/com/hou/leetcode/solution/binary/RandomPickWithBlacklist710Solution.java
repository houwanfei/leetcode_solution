package com.hou.leetcode.solution.binary;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-16 13:54
 */
public class RandomPickWithBlacklist710Solution {
    int N = 0;
    int[] blacklist = null;
    public RandomPickWithBlacklist710Solution(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        Arrays.sort(blacklist);
    }

    public int pick() {
        int random = (int) (Math.random()*(N-blacklist.length));
        if (blacklist.length == 0) {
            return random;
        }
        if (random < blacklist[0]) {
            return random;
        }
        if (random >= blacklist[blacklist.length-1]) {
            return random + blacklist.length;
        }
        int left=0, right = blacklist.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (blacklist[mid]-mid > random) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right+random+1;
    }

    public static void main(String[] args) {
        int[] blacklist = new int[]{0, 2};
        RandomPickWithBlacklist710Solution solution = new RandomPickWithBlacklist710Solution(4, blacklist);
        for (int i=0; i<20; i++) {
            System.out.println(solution.pick());
        }
    }
}
