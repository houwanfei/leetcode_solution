package com.hou.leetcode.solution.weekly.weekly207;


import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWordsSolution {
    public String reorderSpaces(String text) {
        int spaceNum = 0;
        List<String> words = new ArrayList<>();
        char[] sc = text.toCharArray();
        int i=0;
        while (i<sc.length) {
            if (sc[i] != ' ') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(sc[i]);
                i++;
                while (i<sc.length && sc[i] != ' ') {
                    stringBuilder.append(sc[i]);
                    i++;
                }
                words.add(stringBuilder.toString());
            } else {
                spaceNum++;
                i++;
            }
        }
        int eq = 0;
        if (words.size() > 1) {
            eq = spaceNum/(words.size()-1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int use = 0;
        for (int k=0; k<words.size(); k++) {
            String word = words.get(k);
            stringBuilder.append(word);
            if (k <words.size()-1) {
                for (int j = 0; j < eq; j++) {
                    stringBuilder.append(' ');
                    use++;
                }
            }
        }
        for (int j=0; j<spaceNum-use; j++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RearrangeSpacesBetweenWordsSolution solution = new RearrangeSpacesBetweenWordsSolution();
        System.out.println(solution.reorderSpaces(" practice   makes   perfect"));
    }
}
