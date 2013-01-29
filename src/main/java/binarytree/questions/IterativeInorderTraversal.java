package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;
import binarytree.TrivialBinaryTreeConstructor;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA. User: shoubhik Date: 18/11/12 Time: 1:47 PM To
 * change this template use File | Settings | File Templates.
 */
public class IterativeInorderTraversal implements BinaryTreeWriter{

    public static void main(String[] args) {
        TrivialBinaryTreeConstructor tbc = new
                TrivialBinaryTreeConstructor(new BinaryTree());
        BinaryTree bt = tbc.construct();
        // print the binary tree
        System.out.println("input tree");
        bt.print(new BinaryTreePrettyWriter());
        // print the iterative inorder
        System.out.println("Iterative inorder traversal");
        bt.print(new IterativeInorderTraversal());
    }

    @Override
    public void write(BinaryTree tree) {
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        BinaryTree.Node current = tree.getRoot();
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                current = stack.peek();
                stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
}
