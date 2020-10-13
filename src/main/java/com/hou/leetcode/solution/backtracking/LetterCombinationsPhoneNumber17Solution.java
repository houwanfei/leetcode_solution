package com.hou.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber17Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String> letters = init();
        backtracking(res, 0, digits, new StringBuilder(), letters);
        return res;
    }

    private void backtracking(List<String> res, int i, String digits, StringBuilder tmp, List<String> letters) {
        if (i == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String letter = letters.get(digits.charAt(i)-'2');
        for (int j=0; j<letter.length(); j++) {
            tmp.append(letter.charAt(j));
            backtracking(res, i+1, digits, tmp, letters);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    private List<String> init() {
        List<String> letters = new ArrayList<>();
        letters.add("abc");
        letters.add("def");
        letters.add("ghi");
        letters.add("jkl");
        letters.add("mno");
        letters.add("pqrs");
        letters.add("tuv");
        letters.add("wxyz");
        return letters;
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber17Solution solution = new LetterCombinationsPhoneNumber17Solution();
        List<String> res = solution.letterCombinations("23");
        System.out.println();
    }
}
