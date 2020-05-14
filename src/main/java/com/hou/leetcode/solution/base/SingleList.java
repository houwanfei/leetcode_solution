package com.hou.leetcode.solution.base;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-13 9:51
 */
public class SingleList<E> {
    private Node<E> head;

    private Node<E> tail;

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head);
        if (isEmpty()) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newLast = new Node<>(e, null);
        if (isEmpty()) {
            head = newLast;
        } else {
            tail.setNext(newLast);
        }
        tail = newLast;
        size++;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getE();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getE();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E res = head.getE();
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return res;
    }

    public int size(){
        return size;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<>();
        singleList.addFirst(5);
        singleList.addLast(2);
        singleList.addFirst(3);
        singleList.addFirst(4);
        System.out.println(singleList.first());
    }
}
