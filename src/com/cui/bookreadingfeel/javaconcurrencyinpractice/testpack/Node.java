package com.cui.bookreadingfeel.javaconcurrencyinpractice.testpack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/12 15:07
 */
public class Node {
    private int val;
    private boolean visited;
    private List<Node> adjecents;
    public Node(int val) {
        this.val = val;
        this.adjecents = new ArrayList<>();
    }
    public void addAdjecents(Node n) {
        this.adjecents.add(n);
    }
    public List<Node> getAdjacenets() {
        return adjecents;
    }
    public int getVal() {
        return this.val;
    }
    public boolean isVisited() {
        return this.visited;
    }
    public void setVal(int v) {
        this.val = v;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
