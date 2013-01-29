package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import linklist.LinkList;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a function calcDifference which takes in the root pointer of a
 binary tree as it's input. Complete the function to return the sum of values
 of nodes at
 odd height - sum of values of node at even height. Consider the root node is
 at height 1
 */
public class LevelDiffCalc {

    public static int clacDiff(BinaryTree.Node root){
        if(root == null) throw new IllegalArgumentException("root cannot be null");
        int currentLevel  = 1, nextLevel = 0 ;
        int oddSum = 0, evenSum = 0, counter = 1;
        Queue<BinaryTree.Node> q = new LinkedList<BinaryTree.Node>();
        q.add(root);
        while(!q.isEmpty()){
            currentLevel--;
            BinaryTree.Node temp = q.remove();
            if(temp != null){
                if(counter % 2 == 0)
                    evenSum += temp.data;
                else oddSum += temp.data;
                q.add(temp.left);
                q.add(temp.right);
                nextLevel += 2;
            }
            if(currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                counter++;
            }

        }
        return oddSum - evenSum;
    }


    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile(
                "LevelOrderBinaryTree");
        BinaryTree bt  = btc.construct();
        System.out.println("Input Tree");
        bt.print(new BinaryTreePrettyWriter());

        System.out.println("difference in sum =" + clacDiff(bt.getRoot()));
    }
}
