package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import utils.MutableInteger;

import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 Solution:

 For root node, first check two subtrees and figure out the path with maximum
 sum in each subtree (and the path must contains the root node). More
 precisely, we can compare root->val, root->val + leftsubtree,
 root->val + rightsubtree.

 But this is not enough since the maximum path might contains two subtrees.
 We have to compute the value of root->val + leftsubtree + rightsubtree as
 well. The problem is, we cannot directly return this value since this path
 cannot go to upper nodes anymore. So we also use another global variable to
 store the maximum sum in each recursion, and update this variable once we
 find any path with larger sum.

 The following code passes the LeetCode Online Large Judge.

 */
public class MaximalSumPath {
    public static int getMaxSum(BinaryTree bt){
        MutableInteger maxSum = new MutableInteger(Integer.MIN_VALUE);
        MutableInteger csum = new MutableInteger(0);
        maxSumHelper(bt.getRoot(), csum, maxSum);
        return maxSum.getVal();

    }

    private static void maxSumHelper(BinaryTree.Node node, MutableInteger csum,
                                     MutableInteger maxSum){
        if(node == null){
            csum.setVal(0);
            return;
        }
        MutableInteger lsum = new MutableInteger(0);
        MutableInteger rsum = new MutableInteger(0);
        maxSumHelper(node.left, lsum, maxSum);
        maxSumHelper(node.right, rsum, maxSum);
        csum.setVal(Math.max(node.data, Math.max(node.data  + lsum.getVal(),
                                                 node.data + rsum.getVal())));
        maxSum.setVal(Math.max(maxSum.getVal(), Math.max(csum.getVal(),
                                                         node.data + lsum.getVal() +
                                                                 rsum.getVal())));
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor constructor = new ReadBinaryTreeFromFile("BinaryTree");

        BinaryTree bt = constructor.construct();
        // print the tree
        bt.print(new BinaryTreePrettyWriter());

        System.out.printf("maximal sum = %d", getMaxSum(bt));

    }
}


