package com.yhx.dataStructure.tree;

public class BinaryTreeHandlerImpl implements BinaryTreeHandler<String> {

    private BinaryTree<String> root;

    @Override
    public BinaryTree<String> insert(String data) {

        //不包含才能被插入
      return insert(data,root);

    }


    @Override
    public boolean contains(String data) {
        return contains(data,root)!=null;
    }

    @Override
    public BinaryTree<String> findMaxData() {
        return null;
    }

    @Override
    public BinaryTree<String> findMinData() {
        return null;
    }

    @Override
    public BinaryTree<String> remove(String data) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    private BinaryTree<String> contains(String data,BinaryTree<String> node){

        if(null==node){
            return null;
        }

        int compareResult=data.compareTo(node.getData());
        if(compareResult>0){
            return contains(data,node.getRight());
        }else if(compareResult<0){
            return contains(data,node.getLeft());
        }else{
            //equals
            return node;
        }
    }

    private BinaryTree<String> insert(String data,BinaryTree<String> node){

        int result= data.compareTo(node.getData());

        if(result>0){

            if(!node.hasSon()){
               BinaryTree<String> bt= new BinaryTree<String>(data,null,null);
                node.setRight(bt);
                return bt;
            }else{
                return insert(data,node.getRight());
            }
        }else if(result<0){
            if(!node.hasSon()){
                BinaryTree<String> bt= new BinaryTree<String>(data,null,null);
                node.setLeft(bt);
                return bt;
            }else{
                return insert(data,node.getLeft());
            }
        }else{
            return null;
        }
    }
}
