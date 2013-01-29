package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.FileNotFoundException;

/**
 * User: shoubhik Date: 23/12/12 Time: 12:30 PM
 */
public class LowestCommonAncestorOfBST {


    private BinaryTree.Node commonAncestorHelper(BinaryTree.Node node1,
                                                 BinaryTree.Node node2,
                                                 BinaryTree.Node node) {
        if(node == null || node1 == null || node2 == null) return null;
        if((node.data == node1.data || node.data == node2.data) ||
                (node.data < node1.data && node.data > node2.data ) ||
                (node.data < node2.data && node.data > node1.data))
            return node;
        else{
            if(node.data > node1.data && node.data > node2.data)
                node = node.left;
            else
                node = node.right;
            return commonAncestorHelper(node1, node2, node);
        }

    }

    public BinaryTree.Node getCommonAncestor(BinaryTree.Node node1,
                                             BinaryTree.Node node2, BinaryTree bt) {
        return commonAncestorHelper(node1, node2, bt.getRoot());
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("lowest-common-ancestor-BST.txt");
        BinaryTree bt = btc.construct();
        System.out.println("input binary tree");
        bt.print(new BinaryTreePrettyWriter());

        LowestCommonAncestorOfBST ancestorOfBST =
                new LowestCommonAncestorOfBST();
        BinaryTree.Node node1 = BinaryTree.getNewNode(3);
        BinaryTree.Node node2 = BinaryTree.getNewNode(5);
        BinaryTree.Node node = ancestorOfBST.getCommonAncestor(node1, node2, bt);
        System.out.println("ancestor of " + node1.data + " and " + node2.data +
                                   " = " + node.data);
        node1 = BinaryTree.getNewNode(2);
        node2 = BinaryTree.getNewNode(4);
        node = ancestorOfBST.getCommonAncestor(node1, node2, bt);
        System.out.println("ancestor of " + node1.data + " and " + node2.data +
                                   " = " + node.data);

        node1 = BinaryTree.getNewNode(8);
        node2 = BinaryTree.getNewNode(9);
        node = ancestorOfBST.getCommonAncestor(node1, node2, bt);
        System.out.println("ancestor of " + node1.data + " and " + node2.data +
                                   " = " + node.data);

        node1 = BinaryTree.getNewNode(4);
        node2 = BinaryTree.getNewNode(7);
        node = ancestorOfBST.getCommonAncestor(node1, node2, bt);
        System.out.println("ancestor of " + node1.data + " and " + node2.data +
                                   " = " + node.data);
    }
}
