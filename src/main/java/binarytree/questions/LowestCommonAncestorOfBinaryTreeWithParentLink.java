package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in
 * the tree. Each node contains a parent pointer which links to its parent.
 */
public class LowestCommonAncestorOfBinaryTreeWithParentLink {

    public static BinaryTree.Node getAncestor(BinaryTree.Node node1, BinaryTree.Node
            node2) {

        if(node1 == null || node2 == null) return null;
        // set method
        Set<BinaryTree.Node> set = new HashSet<BinaryTree.Node>();
        while(node1 != null || node2 != null){
            if(node1 != null){
                if(!set.add(node1))
                    return node1;
                node1 = node1.parent;
            }
            if(node2 != null){
                if(!set.add(node2))
                    return node2;
                node2 = node2.parent;
            }
        }
        return null; //not in the same tree
    }

    public static void main(String[] args) throws FileNotFoundException,
            URISyntaxException {
        BinaryTreeConstructor btc = new
                ReadBinaryTreeFromFile("LCS-binary-tree.txt", true);
        BinaryTree bt = btc.construct();
        System.out.println("input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        BinaryTree.Node node1 = bt.getRoot().left.left;
        BinaryTree.Node node2 = bt.getRoot().right.left;
        System.out.printf("common ancestor of %d and %d is %d", node1.data,
                          node2.data, getAncestor(node1, node2).data);
    }
}
