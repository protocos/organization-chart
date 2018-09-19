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

    public List<Node<T>> getChildren(int levelsDeep) {
        List<Node<T>> children = new LinkedList<Node<T>>();
        getChildren(this, 0, levelsDeep, children);
        return children;
    }

    private void getChildren(Node<T> currentNode, int currentLevel, int maxLevel, List<Node<T>> allChildren) {
        if (currentLevel == maxLevel - 1)
        {
            allChildren.addAll(currentNode.getChildren());
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
