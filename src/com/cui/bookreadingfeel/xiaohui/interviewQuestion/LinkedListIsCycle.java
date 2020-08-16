package com.cui.bookreadingfeel.xiaohui.interviewQuestion;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/6/5 17:08
 * 链表是否有环   入环点    环长
 */
public class LinkedListIsCycle {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(isCycle(node1));
        System.out.println(cycleLength(node1));

        System.out.println(getCyclePoint(node1));
    }

    // 是否有环
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    // 环长
    // 环长 = 每一次速度差 × 前进次数。
    public static int cycleLength(Node head) {
        int count = 0;
        int length = 0;
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            length++;
            if (p1 == p2) {
                if (count == 1) {
                    return length;
                }
                if (count == 0) {
                    count++;
                    length = 0;
                }
            }
        }
        return -1;
    }

    public static Node firstMeetNode(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    /**
     * 只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，两个指针都是每
     * 次向前走1步。那么，它们最终相遇的节点，就是入环节点。
     * @param node
     * @return
     */
    public static Node getCyclePoint(Node node) {
        Boolean flag = isCycle(node);
        Node firstMeetNode = new Node(0);
        if (flag) {
            firstMeetNode = firstMeetNode(node);
        }
        Node p1 = node;
        Node p2 = firstMeetNode;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
