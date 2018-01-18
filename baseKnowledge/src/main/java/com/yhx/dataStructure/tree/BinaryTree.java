package com.yhx.dataStructure.tree;

/**
 * The type Binary tree.
 *
 * @param <T> the type parameter
 */
public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public BinaryTree(){}

    public BinaryTree(T data,BinaryTree<T> left,BinaryTree<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public boolean hasSon(){
        return (this.left!=null||this.right!=null);
    }

}
