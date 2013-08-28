package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.FileNotFoundException;

/**
 * Analysis: Mirror of binary trees may be a new concept for many candidates, so
 * they may not find a solution in short time during interviews. In order to get
 * some visual ideas about mirrors, we may draw a binary tree and its mirror
 * according to our daily experience. For example, the binary tree on the right
 * of Figure 1 is the mirror of the left one.
 *
 */
public class MirrorABinaryTree implements BinaryTreeConstructor{
    BinaryTree in ;
    BinaryTree out;

    public MirrorABinaryTree(BinaryTree in){
        assert (in != null);
        this.in = in;
        this.out = new BinaryTree();

    }

    private void createMirror(BinaryTree.Node in, BinaryTree.Node out){
        if(in == null) return;
        if(in.right != null)
            out.setLeft(in.right.data);
        if(in.left != null)
            out.setRight(in.left.data);
        createMirror(in.left, out.right);
        createMirror(in.right, out.left);
    }

    public BinaryTree construct() {
        out.setRoot(in.getRoot().data);
        createMirror(in.getRoot(), out.getRoot());
        return out;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree in = btc.construct();
        System.out.println("input tree");
        BinaryTreePrettyWriter writer = new BinaryTreePrettyWriter();
        in.print(writer);
        MirrorABinaryTree mirror = new MirrorABinaryTree(in);
        BinaryTree out = mirror.construct();
        System.out.println("mirror tree");
        out.print(writer);

    }
}
