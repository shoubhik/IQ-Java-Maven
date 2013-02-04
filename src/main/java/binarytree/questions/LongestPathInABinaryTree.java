package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import utils.MutableInteger;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Return the leaf node of the longest path of a binary tree
 */
public class LongestPathInABinaryTree {

    public static BinaryTree.Node getFarthestLeaf(BinaryTree.Node node,
                                                  int level,
                                                  MutableInteger maxLevelTillNow)
    {
        BinaryTree.Node farthestNode1 = null;
        BinaryTree.Node farthestNode2 = null;
        if((node.left == null
                && node.right == null)){
            node.level = level;
            return  node;
        }
        if(node.left != null)
            farthestNode1 = getFarthestLeaf(node.left, level+1, maxLevelTillNow);
        if(node.right != null)
            farthestNode2 = getFarthestLeaf(node.right, level+1, maxLevelTillNow);
        if(node.left == null)
            return node.right;
        else if(node.right == null)
            return  node.left;
        else
        return farthestNode1.level > farthestNode2.level ? farthestNode1 :
                farthestNode2;
    }

    public static void main(String[] args) throws
            FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc =
                new ReadBinaryTreeFromFile("LCS-binary-tree.txt");
        BinaryTree bt = btc.construct();
        bt.getRoot().right.left.right = null;
        System.out.println("input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.printf("farthest leaf node is %d",
                          getFarthestLeaf(bt.getRoot(), 0,
                                          new MutableInteger(0)).data);
    }
}
