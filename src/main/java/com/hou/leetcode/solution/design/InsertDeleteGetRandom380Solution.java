package com.hou.leetcode.solution.design;

import java.util.*;

public class InsertDeleteGetRandom380Solution {
    private Map<Integer, Integer> map;

    private List<Integer> list;

    private Random random;

    /**
     * 思想：用map来存储插入和删除操作，key为val，map的value为list的下标
     *
     * list的插入操作只在尾部插入，删除操作则将删除的位和尾部交换，并更新尾部元素在map中记录的下标
     *
     */
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom380Solution() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        }
        list.add(val);
        int index = list.size()-1;
        map.put(val, index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }
        int delIdx = map.get(val);
        int last = list.get(list.size()-1);
        list.set(delIdx, last);
        list.remove(list.size()-1);
        map.put(last, delIdx);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
