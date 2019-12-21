package com.hou.leetcode.solution;

public class HanNuoSolution {
    public void hanNuo(int n, char ori, char mid, char res) {
        if (n == 1) {
            System.out.println(String.format("把盘子%s从%s -----> %s", n, ori, res));
            return;
        }

        hanNuo(n-1, ori, res, mid);
        System.out.println(String.format("把盘子%s从%s -----> %s", n, ori, res));
        hanNuo(n-1, mid, ori, res);
    }

    public static void main(String[] args) {
        HanNuoSolution solution = new HanNuoSolution();
        solution.hanNuo(4, 'a', 'b', 'c');
    }
}
