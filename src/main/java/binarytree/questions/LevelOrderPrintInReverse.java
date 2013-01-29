package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Do level order printing in reverse
 */
public class LevelOrderPrintInReverse {

    public static void printLevelOrderInReverse(List<BinaryTree.Node> nodeList){
        boolean isLastLevel = true;
        List<BinaryTree.Node> newNodeList = new ArrayList<BinaryTree.Node>();
        for(BinaryTree.Node node : nodeList){
            if(node.left != null){
                newNodeList.add(node.left);
                isLastLevel = false;
            }
            if(node.right != null) {
                newNodeList.add(node.right);
                isLastLevel = false;
            }
        }
        if(!isLastLevel){
            printLevelOrderInReverse(newNodeList);
        }
        // print the current level
        for(BinaryTree.Node node : nodeList){
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc =
                new ReadBinaryTreeFromFile("largest-bst-subtree.txt");
        BinaryTree bt = btc.construct();
        System.out.println("input tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println();
        System.out.println("reverse level order print:");
        List<BinaryTree.Node> l = new ArrayList<BinaryTree.Node>();
        l.add(bt.getRoot());
        printLevelOrderInReverse(l);

    }
}
