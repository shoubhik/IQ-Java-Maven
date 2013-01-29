package binarytree.questions;

import binarytree.*;

/**
 * Calculate the height of a binaryTree recursively
 */
public class BinaryTreeHeight {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeConstructor btc = new TrivialBinaryTreeConstructor(bt);
        btc.construct();
        BinaryTreeWriter writer = new BinaryTreePrettyWriter();
        writer.write(bt);
        BinaryTreeHeightCalculator heightCalculator =
                new BinaryTreeHeightCalculator();
        // this is a recursive solution
        // calculate max height
        System.out.println("max height of the binary tree = " + heightCalculator
                .getMaXHeight(bt));
        // calculate min height
        System.out.println("min height of the binary tree = " + heightCalculator
                .getMinHeight(bt));

    }
}
