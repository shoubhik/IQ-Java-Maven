package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;

import java.io.FileNotFoundException;

/**
 * check if the binary trees are mirror or not
 */
public class MirrorBinaryTreesOrNot {

    public static boolean isMirror(BinaryTree.Node node1, BinaryTree.Node node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        return (node1.data == node2.data) && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree t1 = btc.construct();
        btc = new MirrorABinaryTree(t1);
        BinaryTree t2 = btc.construct();
        System.out.printf("is mirror = %b\n", isMirror(t1.getRoot(), t2.getRoot()));
        System.out.println("modifying the mirror tree ");
        t2.getRoot().left.right.setLeft(1);
        System.out.printf("is mirror = %b", isMirror(t1.getRoot(), t2.getRoot()));
    }
}
