package com.cui.bookreadingfeel.xiaohui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @data 2020/5/31 10:59
 * 深度优先遍历（前序，中序，后序）
 * 广度优先遍历（层序遍历）
 * 二叉树
 */
public class TreeNodeTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(9);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(10);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(8);
        linkedList.add(null);
        linkedList.add(4);
        TreeNode treeNode = createBinaryTree(linkedList);
        System.out.println(treeNode.toString());
        System.out.println("前序遍历使用递归：");
        preOrderTraversal(treeNode);
        System.out.println("\n中序遍历：");
        inOrderTraversal(treeNode);
        System.out.println("\n后序遍历：");
        postOrderTraversal(treeNode);
        System.out.println("\n前序遍历使用Stack：");
        preOrderTraversalWithStack(treeNode);
        System.out.println("\n中序遍历使用Stack：");
        inOrderTraversalWithStack(treeNode);
        System.out.println("\n后序遍历使用Stack：");
        postOrderTraversalWithStack(treeNode);
        System.out.println("\n广度优先遍历使用Queue：");
        levelOrderTraversal(treeNode);
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        TreeNode node = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        Integer data = linkedList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            // 递归，第一次，找到所有根节点的左子树   然后遍历节点
            // 一直添加左子节点，直到null。。。
            node.leftChild = createBinaryTree(linkedList);
            // 递归，第一次，找到所有根节点的右子树
            node.rightChild = createBinaryTree(linkedList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历  根节点、左子树、右子树
     * @param node  二叉树节点
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data+"\t");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树中序遍历  左子树、根节点、右子树
     * @param node  二叉树节点
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data+"\t");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历  左子树、右子树、根节点
     * @param node  二叉树节点
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data+"\t");
    }

    /**
     * 二叉树非递归前序遍历
     * @param root  二叉树根节点
     */
    public static void preOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        // null != null  返回false
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代左节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.print(treeNode.data+"\t");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void inOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data+"\t");
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void postOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = stack.peek().rightChild;
            // 只有当前节点的右节点为null时才出栈   如果不为null，执行while，入栈
            if (treeNode == null || treeNode == root) {
                treeNode = stack.pop();
                System.out.print(treeNode.data+"\t");
                root = treeNode;
                treeNode = null;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data+"\t");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
