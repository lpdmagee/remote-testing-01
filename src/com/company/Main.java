package com.company;
//this is the second commit.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
        bst1.add(90);
        bst1.add(80);
        bst1.add(100);
        bst1.add(70);
        bst1.add(85);
        bst1.add(98);
        bst1.add(120);
        System.out.println(bst1.toString());
        System.out.println(bst1.toStringPreOrder());
        System.out.println(bst1.getHeight());

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
        bst2.add(90);
        bst2.add(91);
        bst2.add(92);
        bst2.add(93);
        System.out.println(bst2.toString());
        System.out.println(bst2.toStringPreOrder());
        System.out.println(bst2.getHeight());

        BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
        bst3.add(90);
        bst3.add(150);
        bst3.add(170);
        bst3.add(160);
        bst3.add(171);
        bst3.add(151);
        System.out.println(bst3.toString());
        System.out.println(bst3.toStringPreOrder());
        System.out.println(bst3.getHeight());

    }
}
