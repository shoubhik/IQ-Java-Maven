package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;

/**
 * Print inorder successor of the given node of BST
 */
public class PrintInorderSuccessorOfBST {

    public static BinaryTree.Node getSuccessorWithParentPointer(
            BinaryTree.Node node){
        // if node has right child
        if(node.right != null){
            BinaryTree.Node temp = node.right;
            while(temp.left != null)
                temp = temp.left;
            return temp;
        }
        // if node is a left child
        else if(node.parent != null && node == node.parent.left)
            return node.parent;
        else{
            BinaryTree.Node temp = node.parent;
            while(temp.parent != null && temp != temp.parent.left)
                temp = temp.parent;
            return temp.parent;
        }
    }

    public static BinaryTree.Node getSuccessorWithoutParentPointer(
            BinaryTree.Node node, BinaryTree bt){
        if(node.right != null){
            BinaryTree.Node temp = node.right;
            while(temp.left != null)
                temp = temp.left;
            return temp;
        }
        return  getSuccessorWithoutParentPointerHelper(bt.getRoot(), node, null);

    }

    private static BinaryTree.Node getSuccessorWithoutParentPointerHelper(
            BinaryTree.Node x, BinaryTree.Node y, BinaryTree.Node c
    ) {
        if(x == y ) return c;
        if(y.data < x.data)
            return getSuccessorWithoutParentPointerHelper(x.left, y , x);
        else return getSuccessorWithoutParentPointerHelper(x.right, y , c);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree",
                                                        true);
        BinaryTree bt = btc.construct();
        BinaryTreeWriter writer = new BinaryTreePrettyWriter();
        writer.write(bt);
        BinaryTree.Node node = bt.getRoot().left;
        System.out.println();
        BinaryTree.Node result = getSuccessorWithoutParentPointer(node, bt);
        System.out.printf("successor of %d is %d", node.data,
                           result == null ? -1 : result.data);
    }
}
