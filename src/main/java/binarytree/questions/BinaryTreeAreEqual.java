package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;

import java.io.FileNotFoundException;

/**
 * Are the given binary trees equal
 */
public class BinaryTreeAreEqual {

    public static boolean areEqualTrees(BinaryTree.Node node1,
                                        BinaryTree.Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return (node1.data == node2.data) && areEqualTrees(node1.left,
                                                           node2.left) &&
                areEqualTrees(
                node1.right, node2.right);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree t1 = btc.construct();
        btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree t2 = btc.construct();
        System.out.printf("trees should be equal = %b\n",
                          areEqualTrees(t1.getRoot(), t2.getRoot()));
        System.out.println("with different trees");
        t2.getRoot().setLeft(0);
        System.out.printf("trees should NOT be equal = %b\n",
                          areEqualTrees(t1.getRoot(), t2.getRoot()));
    }
}
