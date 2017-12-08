package com.yhx.dataStructure.tree;

public interface BinaryTreeHandler<T extends Comparable<? super T>> {

    BinaryTree<T> insert(T data);

    boolean contains(T data);

    BinaryTree<T> findMaxData();

    BinaryTree<T> findMinData();

    BinaryTree<T> remove(T data);

    boolean isEmpty();



}
