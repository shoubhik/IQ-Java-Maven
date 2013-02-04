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
    // how to handle duplicate nodes
    // some how need to incorporate visited field of the node.
    public static BinaryTree.Node getAncestorWithSet(BinaryTree.Node node1,
                                                     BinaryTree.Node node2) {

        if (node1 == null || node2 == null) return null;
        // set method
        Set<BinaryTree.Node> set = new HashSet<BinaryTree.Node>();
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                if (!set.add(node1)) return node1;
                node1 = node1.parent;
            }
            if (node2 != null) {
                if (!set.add(node2)) return node2;
                node2 = node2.parent;
            }
        }
        return null; //not in the same tree
    }

    public static BinaryTree.Node getAncestorWithHeightCalc(
            BinaryTree.Node node1, BinaryTree.Node node2) {
        if (node1 == null || node2 == null) return null;
        BinaryTree.Node temp = node1;
        BinaryTree.Node temp1 = null;
        int h1 = 0, h2 = 0;
        while (temp != null) {
            h1++;
            temp = temp.parent;
        }
        temp = node2;
        while (temp != null) {
            h2++;
            temp = temp.parent;
        }
        int dh = Math.abs((h1 - h2));
        if (h1 >= h2) {
            temp1 = node1;
            temp = node2;
        } else {
            temp1 = node2;
            temp = node1;
        }
        for (int i = 0; i < dh; i++)
            temp1 = temp1.parent;
        while (temp1 != temp && (temp1 != null && temp != null)) {
            temp = temp.parent;
            temp1 = temp1.parent;
        }
        if (temp == null) return temp;
        else if (temp1 == null) return temp1;
        return temp;
    }

    public static void main(
            String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc =
                new ReadBinaryTreeFromFile("LCS-binary-tree.txt", true);
        BinaryTree bt = btc.construct();
        System.out.println("input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        BinaryTree.Node node1 = bt.getRoot().left.left;
        BinaryTree.Node node2 = bt.getRoot().right.left.right;
        System.out.printf("common ancestor of %d and %d is %d", node1.data,
                          node2.data,
                          getAncestorWithHeightCalc(node1, node2).data);
    }
}
