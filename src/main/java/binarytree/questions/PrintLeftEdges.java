package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Print the left edges of a binary tree
 */
public class PrintLeftEdges implements BinaryTreeWriter {

    private void printLeftEdges(BinaryTree.Node node, boolean isEdge){
        if(node == null) return;
        if(isEdge || (node.left == null && node.right == null)){
            System.out.print(node.data + " ");
        }
        printLeftEdges(node.left, isEdge);
        printLeftEdges(node.right, (isEdge && node.left == null ? true : false));

    }

    public void write(BinaryTree bt) {
        if(bt.getRoot() == null) return;
        System.out.print(bt.getRoot().data + " ");
        printLeftEdges(bt.getRoot().left, true);

    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile("EdgeNodesBinaryTree.txt");
        BinaryTree bt = btc.construct();
        System.out.println("Input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println("Printing the edge walk in anticlockwise");
        bt.print(new PrintLeftEdges());
    }
}
