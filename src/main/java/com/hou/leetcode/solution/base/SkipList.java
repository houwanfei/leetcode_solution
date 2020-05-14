package com.hou.leetcode.solution.base;

import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-13 9:35
 */
public class SkipList<E> {
    private Node<Integer, E> head;

    private Node<Integer, E> tail;

    private int size = 0;

    private int levels = 0;

    private Random random;

    public SkipList() {
        random = new Random();
        init();
    }

    private void init() {
        head = new Node<>(Integer.MIN_VALUE, null);
        tail = new Node<>(Integer.MAX_VALUE, null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int size() {
        return size;
    }

    private Node<Integer, E> searchIndex(Integer key) {
        Node<Integer, E> node = head;
        while (node.getBelow() != null) {
            node = node.getBelow();
            while (node.getNext().getKey() <= key) {
                node = node.getNext();
            }
        }
        return node;
    }

    private Node<Integer, E> insertAfterAbove(Node<Integer, E> prev, Node<Integer, E> below, Node<Integer, E> newNode) {
        if (prev != null) {
            hLink(newNode, prev.getNext());
            hLink(prev, newNode);
        }
        if (below != null) {
            vLink(newNode, below);
        }
        return newNode;
    }

    public void insert(Integer key, E e) {
        //找到插入位置
        Node<Integer, E> node = searchIndex(key);
        if (node.getKey().compareTo(key) == 0) {
            node.setE(e);
            return;
        }

        //1/2概率
        int currLevel = 0;
        Node<Integer, E> q = null;
        do {
            if (currLevel >= levels) {//加层
                levels++;
                head = insertAfterAbove(null, head, new Node<>(Integer.MIN_VALUE, null));
                tail = insertAfterAbove(head, tail, new Node<>(Integer.MAX_VALUE, null));
            }
            q = insertAfterAbove(node, q, new Node<>(key, e));
            //查找该层的前驱
            while (node.getAbove() == null) {
                node = node.getPrev();
            }
            node = node.getAbove();
            currLevel++;
        } while (random.nextDouble() > 0.5);
        size++;
    }

    private void hLink(Node<Integer, E> prev, Node<Integer, E> next) {
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
    }

    private void vLink(Node<Integer, E> above, Node<Integer, E> below) {
        if (above != null) {
            above.setBelow(below);
        }
        if (below != null) {
            below.setAbove(above);
        }
    }


    private static class Node<K, E> {
        K key;
        E e;
        private Node<K, E> above, below, prev, next;

        public Node(K key, E e) {
            this.key = key;
            this.e = e;
        }

        public K getKey() {
            return key;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node<K, E> getAbove() {
            return above;
        }

        public void setAbove(Node<K, E> above) {
            this.above = above;
        }

        public Node<K, E> getBelow() {
            return below;
        }

        public void setBelow(Node<K, E> below) {
            this.below = below;
        }

        public Node<K, E> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, E> prev) {
            this.prev = prev;
        }

        public Node<K, E> getNext() {
            return next;
        }

        public void setNext(Node<K, E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int sum = 0;
        for (int j=0; j<100; j++) {
            SkipList<String> skipList = new SkipList<>();
            for (int i = 10000; i > 0; i--) {
                skipList.insert(i, "hi" + i);
            }
            sum += skipList.levels;
        }

        System.out.println(sum/100);
    }
}
