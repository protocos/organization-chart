package com.company;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    final T node;
    Node<T> parent;
    List<Node<T>> children;

    public Node(T node) {
        this.node = node;
        this.children = new LinkedList<Node<T>>();
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
        this.parent.addChild(this);
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public List<Node<T>> getChildren() {
        return new LinkedList<Node<T>>(children);
    }

    public List<Node<T>> getChildren(int level) {
        List<Node<T>> childrenAtLevel = new LinkedList<Node<T>>();
        getChildren(this, 0, level, childrenAtLevel);
        return childrenAtLevel;
    }

    private void getChildren(Node<T> currentNode, int currentLevel, int maxLevel, List<Node<T>> allChildren) throws RuntimeException {
        if (currentLevel == maxLevel)
        {
            allChildren.add(currentNode);
            return;
        }
        ++currentLevel;
        for (Node<T> child : currentNode.getChildren()) {
            getChildren(child, currentLevel, maxLevel, allChildren);
        }
    }

    public T getNode() {
        return this.node;
    }
}
