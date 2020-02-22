package com.hou.leetcode.solution.util;

public class Heap<K extends Comparable<K>> {
    private K[] arr;
    private int N = 0;

    public Heap(int maxN) {
        arr = (K[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public K max() {
        return arr[1];
    }

    public K delMax() {
        K max = arr[1];
        exch(1, N);
        arr[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void insert(K v) {
        arr[++N] = v;
        swim(N);
    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void exch(int i, int j) {
        K tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
           exch(k/2, k);
           k /= 2;
        }
    }

    private void sink(int k) {
        while (k*2 < N) {
            int j = k*2;
            if (j < N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Heap<Integer> integerHeap = new Heap<>(5);
        integerHeap.insert(1);
        integerHeap.insert(2);
        integerHeap.insert(6);
        integerHeap.insert(3);
        integerHeap.insert(5);
        System.out.println(integerHeap.max());
    }
}
