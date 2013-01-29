package binarytree.questions;

import binarytree.*;
import static binarytree.BaseBinaryTreeOrderTraversal.Order;

/**
 * User: shoubhik Date: 11/12/12 Time: 12:55 PM
 * Preorder, Inorder and Postorder traversal
 */
public class BinaryTreeOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeConstructor btc = new TrivialBinaryTreeConstructor(new BinaryTree());
        BinaryTree bt = btc.construct();
        // print the binary tree
        BinaryTreeWriter  orderTraversalWriter = new BinaryTreePrettyWriter();
        orderTraversalWriter.write(bt);
        //print preorder
        System.out.print("PreOrder::");
        orderTraversalWriter = new BinaryTreeOrderWriter(Order.PREPORDER);
        orderTraversalWriter.write(bt);
        System.out.println();
        // print inorder
        System.out.print("InOrder::");
        orderTraversalWriter = new BinaryTreeOrderWriter(Order.INORDER);
        orderTraversalWriter.write(bt);
        System.out.println();
        // print postorder
        System.out.print("Post2Order::");
        orderTraversalWriter = new BinaryTreeOrderWriter(Order.POSTORDER);
        orderTraversalWriter.write(bt);
        System.out.println();


    }
}
