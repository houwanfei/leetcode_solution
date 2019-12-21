package com.hou.leetcode.solution.util;

public class BitMap {
    private byte[] bits = null;

    public BitMap(int num) {
        this.bits = new byte[getIndex(num) + 1];
    }

    private int getIndex(int num) {
        return num >> 3;
    }

    private int getPosition(int num) {
        return num & 0x07;
    }

    public void setNumExist(int num) {
        bits[getIndex(num)] |= (1 << getPosition(num));
    }

    public boolean checkNumExist(int num) {
        return (bits[getIndex(num)] & (1 << getPosition(num))) != 0;
    }
}
