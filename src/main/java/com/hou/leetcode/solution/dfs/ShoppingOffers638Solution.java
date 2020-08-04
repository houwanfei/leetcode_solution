package com.hou.leetcode.solution.dfs;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-04 14:43
 */
public class ShoppingOffers638Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    private int dfs(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs, int currPrice) {
        if (checkFinish(needs)) {
            return currPrice;
        }
        int minCost = Integer.MAX_VALUE;
        for (List<Integer> special : specials) {
            List<Integer> newNeeds = checkCanAdd(special, needs);
            if (newNeeds == null) {
                continue;
            }
            minCost = Math.min(minCost, dfs(prices, specials, newNeeds, currPrice + special.get(special.size()-1)));
        }
        int sum = 0;
        for (int i=0; i<prices.size(); i++) {
            if (needs.get(i) == 0) {
                continue;
            }
            sum += prices.get(i)*needs.get(i);
        }
        return Math.min(minCost, currPrice+sum);
    }

    private List<Integer> checkCanAdd(List<Integer> special, List<Integer> currNeeds) {
        List<Integer> newNeeds = new ArrayList<>();
        for (int i=0; i<currNeeds.size(); i++) {
            if (special.get(i) > currNeeds.get(i)) {
                return null;
            }
            newNeeds.add(currNeeds.get(i)-special.get(i));
        }
        return newNeeds;
    }

    private boolean checkFinish(List<Integer> currNeeds) {
        for (Integer need: currNeeds) {
            if (need > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * [3,4]
     * [[1,2,3],[1,2,5]]
     * [2,2]
     * @param args
     */
    public static void main(String[] args) {
        ShoppingOffers638Solution solution = new ShoppingOffers638Solution();
        List<Integer> prices = Arrays.asList(4,3,2,9,8,8);
        List<List<Integer>> specials = new ArrayList<>();
        specials.add(Arrays.asList(1,5,5,1,4,0,18));
        specials.add(Arrays.asList(3,3,6,6,4,2,32));
        List<Integer> needs = Arrays.asList(6,5,5,6,4,1);
        System.out.println(solution.shoppingOffers(prices, specials, needs));
    }
}
