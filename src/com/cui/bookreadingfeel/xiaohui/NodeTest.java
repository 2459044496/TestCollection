package com.cui.bookreadingfeel.xiaohui;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/30 11:26
 */
public class NodeTest {

    public static void main(String[] args) {
        NodeTest nodeTest = new NodeTest();
        nodeTest.insert(1,0);
        nodeTest.insert(2,1);
        nodeTest.insert(3,2);
        nodeTest.deleteNode(1);
        nodeTest.output();
        System.out.println("链表长度：" + nodeTest.size);
    }

    private Node head;
    private Node last;
    private int size;

    public void insert(int date, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围！");
        }
        Node insertNode = new Node(date);

        if (size == 0) {
            // 链表没有节点
            // 1,将新节点置为head
            // 2,将新节点置为last
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 插入链表头部
            // 1,将新节点的next指向原先的头结点
            // 2,将新节点置为头结点
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            // 插入链表尾部
            // 1,将last节点的next指向新节点
            // 2,将新节点置为last节点
            last.next = insertNode;
            last = insertNode;
        } else {
            // 插入链表中间
            // 1,新节点的next指向插入位置的节点
            // 2,插入位置的前置节点的next指向新节点
            Node prevNode = getNode(index-1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    public Node deleteNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围！");
        }
        Node deleteNode = getNode(index);
        if (index == 0) {
            // 如果是头结点
            // 1,将头结点的next置为头结点
            head = deleteNode.next;
        } else if (index == size-1) {
            // 如果是尾节点
            // 1,获取尾节点的prev节点
            // 2,将尾节点的prev节点的next节点置为null
            Node prev = getNode(index-1);
            prev.next = null;
            last = prev;
        } else {
            Node deletePrevNode = getNode(index-1);
            deletePrevNode.next  = deleteNode.next;
        }
        size --;
        return deleteNode;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围！");
        }
        Node temp = head;
        for (int i=0; i<index; i++) {
            temp =temp.next;
        }
        return temp;
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.date);
            temp = temp.next;
        }
    }

    private static class Node {
        int date;
        Node next;
        Node(int date) {
            this.date = date;
        }
    }
}
