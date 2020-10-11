package com.hou.leetcode.solution.design;

import java.util.Random;

public class ImplementRand10_470Solution {
    public int rand10() {
        int x = 49;
        while (x > 40) {
            x = 7*(rand7()-1) + rand7();
        }
        return x%10+1;
    }

    private int rand7() {
        return new Random().nextInt(7)+1;
    }

    public static void main(String[] args) {
        ImplementRand10_470Solution solution = new ImplementRand10_470Solution();
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
    }
}
