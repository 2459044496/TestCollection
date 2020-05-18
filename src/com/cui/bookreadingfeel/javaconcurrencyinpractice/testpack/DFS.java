package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

import java.util.List;
import java.util.Stack;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 15:08
 */
public class DFS {
    public void stackSolution(Node node) {
        Stack<Node> DFS_stack = new Stack<Node>();
        DFS_stack.add(node);
        node.setVisited(true);
        while (!DFS_stack.isEmpty()) {
            Node nodeRemove = DFS_stack.pop();
            System.out.print(nodeRemove.getVal() + " ");

            List<Node> adjs = nodeRemove.getAdjacenets();
            for (int i = 0; i < adjs.size(); i++) {
                Node currentNode = adjs.get(i);
                if(currentNode != null && !currentNode.isVisited()) {
                    DFS_stack.add(currentNode);
                    currentNode.setVisited(true);
                }
            }
        }
    }
}
