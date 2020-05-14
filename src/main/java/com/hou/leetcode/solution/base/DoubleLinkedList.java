package com.hou.leetcode.solution.base;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-13 10:54
 */
public class DoubleLinkedList<E> {
    private Node<E> head;

    private Node<E> tail;

    private int size;

    public DoubleLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getE();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getPrev().getE();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> res = head.getNext();
        remove(res);
        return res.getE();
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> res = tail.getPrev();
        remove(res);
        return res.getE();
    }

    private void addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(e, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    private void remove(Node<E> e) {
        e.getPrev().setNext(e.getNext());
        e.getNext().setPrev(e.getPrev());
        size--;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> prev, Node<E> next) {
            this.e = e;
            this.prev = prev;
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

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
