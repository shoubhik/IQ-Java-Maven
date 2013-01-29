package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import utils.MutableInteger;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search
 * Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * In this post, we develop a solution to find the largest BST subtree in a
 * binary tree. Please note that a subtree must include all of its
 * descendants. If you are only interested in the solution of finding the
 * largest BST where it may or may not include all of its descendants,
 * read my next post: Largest Binary Search Tree (BST) in a Binary Tree.
 *
 * It’s important that you understand the question correctly. Let’s try an
 * example below. Which is the largest BST subtree?

    ____10____
   /          \
  __5_         15_
 /    \           \
 1     8           7
 For most people, there would be two possible interpretations for the term “subtree”.

 Is this ( subtree (1) ) the largest BST subtree?

     ____10____
    /          \
  __5_         15     -------- subtree (1)
 /    \
 1     8
 How about this one ( subtree (2) ) ?

  __5_
 /    \               -------- subtree (2)
 1     8

 According to Wikipedia, a subtree of a tree T is a tree consisting of a node
 in T and all of its descendants in T. Therefore, there is no doubt that
 subtree (2) is the correct answer, as subtree (1) does not include all of
 its descendants. It is important that you understand the term subtree
 correctly. If you are not sure, ask the interviewer and you should not make
 any assumptions.

 Naive Approach:
 A naive approach is to reuse the solution from Determine if a Binary Tree is
 a Binary Search Tree. Starting from the root, we process in the order of
 current node, left child, then right child. For each node,
 you would call isBST() to check if the current subtree is a BST. If it is,
 then we have found the largest BST subtree. If it is not,
 then we have to continue examining its left and right child. If only one of
 the subtrees is BST, then we can return that subtree. However,
 if both left and right subtrees are BSTs, then we have to compare which
 subtree is larger (has more descendant nodes), then return the larger one.

 Assume that we have a complete tree (ie, all leaves are at the same depth)
 with n nodes, the naive approach’s run time complexity is O(n lg n). The
 proof is left as an exercise to the reader.

 A Flawed Approach:
 How about doing an in-order traversal for the binary tree? The longest
 increasing contiguous sequence must be the largest BST subtree. Try to do an
 in-order traversal for the example tree above. This approach simply does not
 work. Period.

 A Bottom-up Approach:
 The naive approach is using a top-down approach. It is hardly efficient,
 simply because we are calling isBST() over and over again. Each time isBST()
 is called, it traverses down to the leaves to verify if the subtree is a BST.

 Let’s think from another perspective. Instead of traversing down the tree,
 why not traverse up the tree using a bottom-up approach? In other words,
 we verify the deeper nodes before we verify if the above nodes satisfy the
 BST requirements.

 The main reason of doing this is when one of the nodes does not satisfy the
 BST properties, all subtrees above (which includes this node as well) must
 also not satisfy the BST requirements.

 First, let’s review our definition of a BST. A tree is a BST if the
 following properties are satisfied:

 Both left and right subtrees of a node are BSTs.
 The node’s value is greater than its left subtree’s maximum.
 The node’s value is less than its right subtree’s minimum.
 Using a bottom-up approach, we need to pass some information up the tree.
 Obviously, we need to pass minimum and maximum values of the subtree as we
 traverse up the tree, so the above subtrees could be verified for BST’s
 properties.

 As compared to the top-down approach, the bottom-up approach is such an
 awesome choice because the results for total number of nodes could be passed
 up the tree. This saves us from recalculating over and over again. The total
 number of nodes for a subtree is simply the total number of nodes of its
 left and right subtrees plus one.

 */
public class LargestBSTSubtree implements BinaryTreeConstructor {

    private BinaryTree input;
    private BinaryTree output;

    public LargestBSTSubtree(BinaryTree input) {
        assert (input != null);
        this.input = input;
        this.output = new BinaryTree();
    }

    @Override
    public BinaryTree construct() {
        MutableInteger min = new MutableInteger(Integer.MIN_VALUE);
        MutableInteger max = new MutableInteger(Integer.MAX_VALUE);
        MutableInteger maxNodes = new MutableInteger(Integer.MIN_VALUE);
        findLargestBSTSubtree(this.input.getRoot(), min, max, maxNodes,
                              this.output);
        return this.output;
    }

    private int findLargestBSTSubtree(BinaryTree.Node node, MutableInteger min,
                                      MutableInteger max,
                                      MutableInteger maxNodes,
                                      BinaryTree largestBST) {
        if (node == null) return 0;
        boolean isBST = true;
        int leftNodes = findLargestBSTSubtree(node.left, min, max, maxNodes,
                                              largestBST);
        int currMin = leftNodes == 0 ? node.data : min.getVal();
        if (leftNodes == -1 || (leftNodes != 0 && node.data <= max.getVal()))
            isBST = false;
        int rightNodes = findLargestBSTSubtree(node.right, min, max, maxNodes,
                                               largestBST);
        int currMax = rightNodes == 0 ? node.data : max.getVal();
        if (rightNodes == -1 || (rightNodes != 0 && node.data >= min.getVal()))
            isBST = false;
        if (isBST) {
            min.setVal(currMin);
            max.setVal(currMax);
            int totalNodes = leftNodes + rightNodes + 1;
            if (totalNodes > maxNodes.getVal()) {
                maxNodes.setVal(totalNodes);
                largestBST.setRoot(node);
            }
            return totalNodes;
        } else return -1;

    }


    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc =
                new ReadBinaryTreeFromFile("largest-bst-subtree.txt");
        BinaryTree bt = btc.construct();
        System.out.println("input tree");
        bt.print(new BinaryTreePrettyWriter());

        btc = new LargestBSTSubtree(bt);

        BinaryTree out = btc.construct();
        System.out.println("the largest BST subtree");
        out.print(new BinaryTreePrettyWriter());
    }
}
