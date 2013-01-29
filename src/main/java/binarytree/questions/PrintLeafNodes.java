package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Print the leaf nodes
 */
public class PrintLeafNodes implements BinaryTreeWriter {

    public void write(BinaryTree bt) {
        if(bt.getRoot() == null) return;
        switch (this.order){
            case LEFT_TO_RIGHT:
                printFromLeftToRight(bt.getRoot());
                System.out.println();
                break;
            case RIGHT_TO_LEFT:
                printFromRightToLeft(bt.getRoot());
                System.out.println();
                break;
        }
    }

    public static enum ORDER {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT
    }

    private ORDER order;

    private void printFromLeftToRight(BinaryTree.Node node){
        if(node == null ) return;
        printFromLeftToRight(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printFromLeftToRight(node.right);
    }

    private void printFromRightToLeft(BinaryTree.Node node){
        if(node == null ) return;
        printFromRightToLeft(node.right);
        if(node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printFromRightToLeft(node.left);
    }

    public PrintLeafNodes(ORDER order){
        this.order = order;
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile("EdgeNodesBinaryTree.txt");
        BinaryTree bt = btc.construct();
        System.out.println("Input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println("Printing leaf nodes for left to right");
        bt.print(new PrintLeafNodes(ORDER.LEFT_TO_RIGHT));

        System.out.println("Printing leaf nodes for right to left");
        bt.print(new PrintLeafNodes(ORDER.RIGHT_TO_LEFT));
    }
}
