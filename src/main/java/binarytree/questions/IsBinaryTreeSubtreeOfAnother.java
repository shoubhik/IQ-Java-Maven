package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Given two binary trees, check if the first tree is subtree of the second
 * one. A subtree of a tree T is a tree S consisting of a node in T and all
 * of its descendants in T. The subtree corresponding to the root node is the
 * entire tree; the subtree corresponding to any other node is called a proper
 * subtree.
 *
 * For example, in the following case, tree S is a subtree of tree T.

 Tree S
      10
  /       \
 4       6
  \
  30


 Tree T
        26
      /   \
    10     3
 /    \     \
 4    6       3
  \
  30
 Solution: Traverse the tree T in inorder fashion. For every visited node in
 the traversal, see if the subtree rooted with this node is identical to S.


 */
public class IsBinaryTreeSubtreeOfAnother {

    public static boolean areTreeIdentical(BinaryTree.Node t1,
                                           BinaryTree.Node t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null )
            return true;
        if(t2 == null)
            return false;
        return  (t1.data == t2.data ) && areTreeIdentical(t1.left, t2.left)
                && areTreeIdentical(t1.right, t2.right) ;

    }

    // check is t1 is subtree of t2
    public static boolean isSubtree(BinaryTree.Node t1, BinaryTree.Node t2){
        if(t2 == null) return true;
        if(t1 == null) return false;
        if(areTreeIdentical(t1, t2))
            return true;
        return isSubtree(t2.left, t1) || isSubtree(t2.right, t1);
    }

    public static void main(String[] args) throws FileNotFoundException,
            URISyntaxException {
        BinaryTreeConstructor constructor =
                new ReadBinaryTreeFromFile("supertree.txt");

        BinaryTree bt = constructor.construct();
        // print the tree
        System.out.println("super tree");
        bt.print(new BinaryTreePrettyWriter());

        constructor =
                new ReadBinaryTreeFromFile("subtree.txt");

        BinaryTree bt1 = constructor.construct();
        // print the tree
        System.out.println("sub tree");
        bt1.print(new BinaryTreePrettyWriter());

        System.out.printf("\n is subtree = %B\n",
                          isSubtree(bt1.getRoot(), bt.getRoot()));

        System.out.println("modifying the sub tree");

        bt1.getRoot().addParentPointerToRightChild().left.right = null;
        System.out.println("modified tree");
        bt1.print(new BinaryTreePrettyWriter());

        System.out.printf("\n is subtree = %B",
                          isSubtree(bt1.getRoot(), bt.getRoot()));

    }
}
