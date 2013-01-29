package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, print out the tree in zig zag level order (ie,
 * from left to right, then right to left for the next level and alternate
 * between). Output a newline after the end of each level.

     3
   /  \
  9   20
     /  \
   15    7
 For example, the zig zag level order output of the tree above is:

 3
 20 9
 15 7
 */
public class ZigZagPrinter implements BinaryTreeWriter {


    @Override
    public void write(BinaryTree bt) {
        if(bt.getRoot() == null) return;
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        boolean isReverse = true;
        int currentLevel = 1, nextLevel = 0;
        q.add(bt.getRoot());
        while(!q.isEmpty()){
            BinaryTree.Node node = q.remove();
            currentLevel--;
            if(node != null){
                System.out.print(node.data + " ");
                if(isReverse){
                    q.add(node.right);
                    q.add(node.left);
                }
                else{
                    q.add(node.left);
                    q.add(node.right);
                }
                nextLevel += 2;
            }
            if(currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
                isReverse = !isReverse;
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile(
                "LevelOrderBinaryTree");
        BinaryTree bt  = btc.construct();
        System.out.println("Input Tree");
        bt.print(new BinaryTreePrettyWriter());
        // printing in zigzag
        BinaryTreeWriter writer = new ZigZagPrinter();
        System.out.println("Printing in zig zag");
        writer.write(bt);

    }
}
