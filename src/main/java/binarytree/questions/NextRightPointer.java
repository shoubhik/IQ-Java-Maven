package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;
import binarytree.TrivialBinaryTreeConstructor;

/**
 * Given a binary tree
 * <p/>
 * struct Node {
 * Node* leftChild;
 * Node* rightChild;
 * Node* nextRight; }
 * Populate the nextRight pointers in each node.
 * <p/>
 * You may assume that it is a full binary tree (ie, each node other than the
 * leaves has two children.
 *
 *
  1-Most likely this can be implemented recursively, because you can identify the
 linking of nodes as sub-problems.
  2-The main difficulty of this problem is linking rightChild with the
   nextSibling of rightChild.
  3-Each node has no parent pointer. Therefore, there is no way linking the
   rightChild with its nextSibling at a level.
 */
public class NextRightPointer {

    public static void connectToRightSibling(BinaryTree.Node node){
        if(node == null)
            return;
        if(node.left != null)
            node.left.nextRight = node.right;
        if(node.right!=null)
            node.right.nextRight = node.nextRight != null ? node.nextRight.left
                    : null;
        connectToRightSibling(node.left);
        connectToRightSibling(node.right);
    }

    public static void connectToNextLeftSibling(BinaryTree.Node node){
        if(node == null)
            return;
        if(node.left != null)
            node.left.nextLeft = node.nextLeft != null? node.nextLeft.right : null;
        if(node.right != null)
            node.right.nextLeft = node.left;
        connectToNextLeftSibling(node.left);
        connectToNextLeftSibling(node.right);
    }


    public static void main(String[] args) {
        TrivialBinaryTreeConstructor tvb = new TrivialBinaryTreeConstructor(
                new BinaryTree());
        BinaryTree bt  = tvb.construct();
        BinaryTreeWriter writer = new BinaryTreePrettyWriter();

        connectToRightSibling(bt.getRoot());
        writer.write(bt);

        tvb = new TrivialBinaryTreeConstructor(
                new BinaryTree());
        bt  = tvb.construct();
        connectToNextLeftSibling(bt.getRoot());


    }
}
