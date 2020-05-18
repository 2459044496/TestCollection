package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 15:09
 * 深度优先搜索示例
 */
public class MainTest {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node20 = new Node(20);
        Node node25 = new Node(25);
        Node node30 = new Node(30);
        Node node35 = new Node(35);
        Node node40 = new Node(40);
        node5.addAdjecents(node10);
        node10.addAdjecents(node15);
        node15.addAdjecents(node20);
        node10.addAdjecents(node25);
        node25.addAdjecents(node35);
        node35.addAdjecents(node40);
        node25.addAdjecents(node30);
        DFS demo = new DFS();
        System.out.println("DFS traversal of above graph: ");
        demo.stackSolution(node5);
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }
}
