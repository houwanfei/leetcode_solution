package com.hou.leetcode.solution;

public class ReverseInteger7Solution {

    public int solution(int x){
        long sum = 0 ;
        while (x != 0){
            sum = sum * 10 + x % 10;
            x = x / 10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
                return 0;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        ReverseInteger7Solution solution = new ReverseInteger7Solution();
        System.out.println(solution.solution(320));
    }
}
