package com.company;

public class Node<E>{
    private E data;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;

    public Node(E data){
        this.data=data;
        left=null;
        right=null;
        parent=null;
    }
    public E get(){
        return data;
    }
    public Node<E> getLeft(){
        return left;
    }
    public Node<E> getRight(){
        return right;
    }
    public Node<E> getParent() {
        return parent;
    }
    public void setLeft(Node<E> left){
        this.left=left;
    }
    public void setRight(Node<E> right){
        this.right=right;
    }
    public void setParent(Node<E> parent) {
        this.parent = parent;
    }
    public void set(E data) {
        this.data = data;
    }
}
