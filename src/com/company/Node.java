package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    final T node;
    HashSet<Node<T>> parents;
    HashSet<Node<T>> children;

    public Node(T node) {
        this.node = node;
        this.parents = new HashSet<Node<T>>();
        this.children = new HashSet<Node<T>>();
    }

    public void addParent(Node<T> parent) {
        parent.children.add(this);
        this.parents.add(parent);
    }

    public List<Node<T>> getParents() {
        return new LinkedList<Node<T>>(this.parents);
    }

    public void addChild(Node<T> child) {
        child.parents.add(this);
        this.children.add(child);
    }

    public List<Node<T>> getChildren() {
        return new LinkedList<Node<T>>(this.children);
    }

    public List<Node<T>> getChildren(int level) {
        HashSet<Node<T>> childrenAtLevel = new HashSet<Node<T>>();
        getChildren(this, 0, level, childrenAtLevel, new HashSet<Node<T>>());
        return new LinkedList<Node<T>>(childrenAtLevel);
    }

    private void getChildren(Node<T> currentNode, int currentLevel, int maxLevel, HashSet<Node<T>> allChildren, HashSet<Node<T>> ancestors) throws RuntimeException {
        if (ancestors.contains(currentNode))
        {
            return;
        }
        if (currentLevel == maxLevel)
        {
            allChildren.add(currentNode);
            return;
        }
        ++currentLevel;
        for (Node<T> child : currentNode.children) {
            HashSet<Node<T>> newAncestorCollection = new HashSet<Node<T>>(ancestors);
            newAncestorCollection.add(currentNode);
            getChildren(child, currentLevel, maxLevel, allChildren, newAncestorCollection);
        }
    }

    public T getNode() {
        return this.node;
    }
}
