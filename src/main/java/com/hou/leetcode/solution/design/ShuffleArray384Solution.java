package com.hou.leetcode.solution.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray384Solution {
    private int[] origin = null;

    /**
     * 随机算法-每一位时，随机生成一个0-len范围的下标和当前i下标交换
     * @param nums
     */
    public ShuffleArray384Solution(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(origin, origin.length);
        Random random = new Random();
        for (int i=0; i<shuffle.length; i++) {
            int rand = random.nextInt(shuffle.length);
            int tmp = shuffle[i];
            shuffle[i] = shuffle[rand];
            shuffle[rand] = tmp;
        }
        return shuffle;
    }
}
