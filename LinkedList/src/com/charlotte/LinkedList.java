package com.charlotte;

/**
 * @Author:Charlotte Li
 * @Date:2019-06-11 22:06
 * @Description:链表的实现
 * @version:1.0
 */
public class LinkedList<E> {
    /**
     * @Author: Charlotte Li
     * @Description:node节点内部类
     * @Date: 2019-06-11 22:47
     **/
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;

        //head = new Node(e, head);
        size++;
    }
}
