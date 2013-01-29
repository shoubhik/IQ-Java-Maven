package binarytree.questions;

import binarytree.*;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, print out the tree in level order (ie,
 * from left to right, level by level). Output a newline after the end of
 * each level.

     3
   /  \
  9   20
     /  \
    15    7
 For example, the level order output of the tree above is:

 3
 9 20
 15 7

 The most natural solution for level-order traversal is Breadth First Search
 (BFS), since it visits the nodes level by level. BFS requires the use of a
 data structure called Queue, which is a First In First Out (FIFO) structure.
 If you are curious, level-order traversal can be implemented using DFS too.
 See my next post: Binary Tree Level-Order Traversal Using Depth First Search
 (DFS) for the challenge.
 */
public class LevelOrderPrint implements BinaryTreeWriter {

    public static enum Algo{
        BFS, DFS
    }

    private Algo algo;

    public LevelOrderPrint(Algo algo){
        assert(algo != null);
        this.algo = algo;
    }

    /**
     *  The single queue solution requires two extra counting variables which
     *  keep tracks of the number of nodes in the current level
     *  (nodesInCurrentLevel) and the next level (nodesInNextLevel). When we
     *  pop a node off the queue, we decrement nodesInCurrentLevel by one.
     *  When we push its child nodes to the queue,
     *  we increment nodesInNextLevel by two. When nodesInCurrentLevel
     *  reaches 0, we know that the current level has ended, therefore we print
     *  an endline here.
     * @param bt
     */

    private void printUsingBFS(BinaryTree bt){
        if(bt.getRoot() == null) return;
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        int currentLevel = 1, nextLevel =0;
        q.add(bt.getRoot());
        while(!q.isEmpty()){
            BinaryTree.Node node = q.remove();
            currentLevel--;
            if(node != null) {
                System.out.print(node.data + " ");
                q.add(node.left);
                q.add(node.right);
                nextLevel += 2;
            }
            if(currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel  = 0;
            }

        }

    }


    private void printDFSHelper(BinaryTree.Node node, int level) {
        if(node == null) return;
        if(level == 1) {
            System.out.print(node.data  + " ");
        }
        else {
            printDFSHelper(node.left , level -1);
            printDFSHelper(node.right, level -1);

        }


    }

    private void printUsingDFS(BinaryTree bt){
        BinaryTreeHeightCalculator heightCalculator = new BinaryTreeHeightCalculator();
        int height = heightCalculator.getMaXHeight(bt);
        for(int level = 1; level <= height; level++ ) {
            printDFSHelper(bt.getRoot(), level);
            System.out.println();
        }
    }

    @Override
    public void write(BinaryTree bt) {
        switch (this.algo){
            case BFS:
                printUsingBFS(bt);
                break;
            case DFS:
                printUsingDFS(bt);

        }

    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile(
                "LevelOrderBinaryTree");
        BinaryTree bt  = btc.construct();
        System.out.println("Input Tree");
        bt.print(new BinaryTreePrettyWriter());
        // using BFS
        System.out.println("Printing level order using BFS");
        BinaryTreeWriter writer = new LevelOrderPrint(Algo.BFS);
        writer.write(bt);
        // using DFS

        System.out.println("Printing level order using DFS");
        writer = new LevelOrderPrint(Algo.DFS);
        writer.write(bt);
    }
}
