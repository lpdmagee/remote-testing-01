package com.company;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int height;

    public BinarySearchTree() {
        root = null;
        height = 0;
    }

    public void add(E data) {
        if(root==null) {
            root = new Node<E>(data);
        } else {
            add(data, root);
        }
    }

    private void add(E data, Node<E> current) {
        if (data.compareTo(current.get()) < 0) {
            if (current.getLeft() == null) {
                Node<E> node = new Node<E>(data);
                current.setLeft(node);
                node.setParent(current);
            }
            else {
                add(data, current.getLeft());
                current.getLeft().setParent(current);
            }
        }
        else if (data.compareTo(current.get()) > 0) {
            if (current.getRight() == null) {
                Node<E> node = new Node<E>(data);
                current.setRight(node);
                node.setParent(current);
            }
            else {
                add(data, current.getRight());
                current.getRight().setParent(current);
            }
        }
    }

    public void remove(E data) {
        remove(data, root);
    }

    private void remove(E data, Node<E> current) {
        if(current == null) {}
        else if(data.compareTo(current.get()) == 0) {
            // no children
            if(current.getLeft() == null && current.getRight() == null) {
                // root
                if(current == root) {
                    root = null;
                }
                // not root
                else {
                    // current is a left child
                    if(current.getParent().getLeft() == current) {
                        current.getParent().setLeft(null);
                    }
                    else {
                        current.getParent().setRight(null);
                    }
                }
            }
            // one left child
            else if(current.getLeft() != null && current.getRight() == null) {
                // root
                if(current == root) {
                    root = root.getLeft();
                }
                // not root
                else {
                    if(current.getParent().getLeft() == current) {
                        current.getParent().setLeft(current.getLeft());
                    }
                    else {
                        current.getParent().setRight(current.getLeft());
                    }
                }
            }
            // one right child
            else if(current.getLeft() == null && current.getRight() != null) {
                // root
                if(current == root) {
                    root = root.getRight();
                }
                // not root
                else {
                    if(current.getParent().getLeft() == current) {
                        current.getParent().setLeft(current.getRight());
                    }
                    else {
                        current.getParent().setRight(current.getRight());
                    }
                }
            }
            // two children
            else {
                // root
                if(current == root) {
                    Node<E> lowestLeft = getAndRemoveLowest(current.getRight(), current);
                    lowestLeft.setLeft(root.getLeft());
                    lowestLeft.setRight(root.getRight());
                    root = lowestLeft;
                }
                // not root
                else {
                    // get and remove the lowest node to the right of the current
                    Node<E> lowestLeft = getAndRemoveLowest(current.getRight(), current);
                    // put in references from current into lowestLeft
                    lowestLeft.setLeft(current.getLeft());
                    lowestLeft.setRight(current.getRight());
                    //System.out.println(lowestLeft+" "+lowestLeft.getLeft()+" "+lowestLeft.getRight());
                    // remove the current node
                    if(current.getParent().getLeft() == current)
                        current.getParent().setLeft(lowestLeft);
                    else
                        current.getParent().setRight(lowestLeft);
                }
            }
        }
        else {
            //System.out.println(data+" "+data.compareTo(current.get())+" "+current.get()+" "+current.getLeft()+" "+current.getRight());
            if(data.compareTo(current.get()) < 0)
                remove(data, current.getLeft());
            else
                remove(data, current.getRight());
        }
    }

    public Node<E> getAndRemoveLowest(Node<E> current, Node<E> parent) {
        if(current.getLeft() == null) {
            if(parent.getRight() == current)
                parent.setRight(null);
            else
                parent.setLeft(null);
            return current;
        }
        else {
            return getAndRemoveLowest(current.getLeft(), current);
        }
    }

    public boolean contains(E data) {
        return contains(data, root);
    }
    private boolean contains(E data, Node<E> current) {
        if(current != null) {
            if(data.compareTo(current.get()) == 0) {
                return true;
            }
            if(data.compareTo(current.get()) < 0) {
                return contains(data, current.getLeft());
            }
            else {
                return contains(data, current.getRight());
            }
        }
        return false;
    }

    public String toString(){
        return inOrderString(root);
    }

    private String inOrderString(Node<E> current){
        if(current != null){
            String str = inOrderString(current.getLeft());
            str += current.get() + ", ";
            str += inOrderString(current.getRight());
            return str;
        }
        return "";
    }

    public String toStringPreOrder() {
        return toStringPreOrder(root);
    }

    private String toStringPreOrder(Node<E> current){
        if(current != null){
            String str = current.get() + ", ";
            str += toStringPreOrder(current.getLeft());
            str += toStringPreOrder(current.getRight());
            return str;
        }
        return "";
    }

    public int getLevel() {
        return getLevel(root);
    }

    public int getHeight() {
        return getLevel(root)-1;
    }

    private int getLevel(Node<E> current) {
        if (current == null) {
            return 0;
        }

        return 1 + Math.max(getLevel(current.getLeft()), getLevel(current.getRight()));
    }
}
