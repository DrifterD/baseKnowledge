/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: BinaryTreeHandler.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.dataStructure.tree;

public interface BinaryTreeHandler<T extends Comparable<? super T>> {

    BinaryTree<T> insert(T data);

    boolean contains(T data);

    BinaryTree<T> findMaxData();

    BinaryTree<T> findMinData();

    BinaryTree<T> remove(T data);

    boolean isEmpty();



}
