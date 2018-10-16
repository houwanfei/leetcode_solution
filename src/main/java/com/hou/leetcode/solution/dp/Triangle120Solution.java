package com.hou.leetcode.solution.dp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Triangle120Solution {

    public int solution(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];


        for (int i=0; i<triangle.get(triangle.size()-1).size(); i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int i= triangle.size()-2; i>=0; i--){
            for (int j=0; j< triangle.get(i).size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Triangle120Solution solution = new Triangle120Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> subTriangle1 = new ArrayList<>();
        subTriangle1.add(2);
        triangle.add(subTriangle1);

        List<Integer> subTriangle2 = new ArrayList<>();
        subTriangle2.add(3);
        subTriangle2.add(4);
        triangle.add(subTriangle2);

        List<Integer> subTriangle3 = new ArrayList<>();
        subTriangle3.add(6);
        subTriangle3.add(5);
        subTriangle3.add(7);
        triangle.add(subTriangle3);

        List<Integer> subTriangle4 = new ArrayList<>();
        subTriangle4.add(4);
        subTriangle4.add(1);
        subTriangle4.add(8);
        subTriangle4.add(3);
        triangle.add(subTriangle4);
        System.out.println(solution.solution(triangle));
    }
}
