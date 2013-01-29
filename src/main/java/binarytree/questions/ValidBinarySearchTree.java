package binarytree.questions;

import binarytree.*;

/**
 * Write a function isBST(BinaryTree *node) to verify if a given binary tree is
 * a Binary Search Tree (BST) or not.
 * <p/>
 * First, you must understand the difference between Binary Tree and Binary
 * Search Tree (BST). Binary tree is a tree data structure in which each node
 * has at most two child nodes. A binary search tree (BST) is based on binary
 * tree, but with the following additional properties: The left subtree of a
 * node contains only nodes with keys less than the node’s key.
 * <p/>
 * The right subtree of a node contains only nodes with keys greater than the
 * node’s key.
 * <p/>
 * Both the left and right subtrees must also be binary search trees.
 *
 * Assume that the current node’s value is k. Then for each node,
 * check if the left node’s value is less than k and the right node’s value
 * is greater than k. If all of the nodes satisfy this property,
 * then it is a BST.
 It sounds correct and convincing, but look at this counter example below: A
 sample tree which we name it as binary tree (1).

   10
  /  \
 5   15     -------- binary tree (1)
    /  \
   6    20

 */
public class ValidBinarySearchTree {

    public static enum ALGO{
        BRUT_FORCE, RANGE_COMPARISON, INORDER_VALIDATOR
    }

    public static BSTValidator getValidator(ALGO algo)
    {
        switch (algo){
            case BRUT_FORCE:
                return new BinarySearchTreeBrutForceValidator();
            case RANGE_COMPARISON:
                return new BinarySearchTreeRangeComparisonValidator();
            case INORDER_VALIDATOR:
                return  new BinarySearchTreeInorderValidator();

        }
        throw new IllegalArgumentException("Not a valid algo!!");
    }

    public static interface BSTValidator{

        public boolean isValid(BinaryTree bt);

    }

    /**
     * Based on BST’s definition, we can then easily devise a brute-force
     * solution:

     Assume that the current node’s value is k. Then for each node,
     check if all nodes of left subtree contain values that are less than k.
     Also check if all nodes of right subtree contain values that are greater
     than k. If all of the nodes satisfy this property, then it must be a BST.
     */

    private static class BinarySearchTreeBrutForceValidator
            implements BSTValidator {

        private boolean isSubtreeLessThan(BinaryTree.Node node, int val) {
            if (node == null) return true;
            return (node.data < val && isSubtreeLessThan(node.left, val) &&
                    isSubtreeLessThan(node.right, val));
        }

        private boolean isSubtreeGreaterThan(BinaryTree.Node node, int val) {
            if (node == null) return true;
            return (node.data > val && isSubtreeGreaterThan(node.left, val) &&
                    isSubtreeGreaterThan(node.right, val));
        }

        private boolean validateBinarySearchTree(BinaryTree.Node node) {
            if (node == null) return true;
            return isSubtreeLessThan(node.left,
                                     node.data) && isSubtreeGreaterThan(
                    node.right, node.data) && validateBinarySearchTree(
                    node.left)
                    && validateBinarySearchTree(node.right);
        }

        @Override
        public boolean isValid(BinaryTree bt) {
            return validateBinarySearchTree(bt.getRoot());
        }
    }

    /**
     * Here is the much better solution. Instead of examining all nodes of
     * both subtrees in each pass, we only need to examine two nodes in each
     * pass.

     Refer back to the binary tree (1) above. As we traverse down the tree
     from node (10) to right node (15), we know for sure that the right
     node’s value fall between 10 and +INFINITY. Then, as we traverse further
     down from node (15) to left node (6), we know for sure that the left
     node’s value fall between 10 and 15. And since (6) does not satisfy the
     above requirement, we can quickly determine it is not a valid BST. All
     we need to do is to pass down the low and high limits from node to node!
     Once we figure out this algorithm, it is easy to code.
     */
    private static class BinarySearchTreeRangeComparisonValidator
            implements BSTValidator {

        private boolean validatorHelper(int min, int max,
                                        BinaryTree.Node node) {
            if (node == null) return true;
            if (node.data > min && node.data < max) {
                return validatorHelper(min, node.data, node.left) &&
                        validatorHelper(node.data, max, node.right);
            } else return false;
        }

        @Override
        public boolean isValid(BinaryTree bt) {
            return validatorHelper(Integer.MIN_VALUE, Integer.MAX_VALUE,
                                   bt.getRoot());
        }
    }

    /**
     * Another solution is to do an in-order traversal of the binary tree,
     * and verify that the previous value (can be passed into the recursive
     * function as reference) is less than the current value. This works
     * because when you do an in-order traversal on a BST,
     * the elements must be strictly in increasing order. This method also runs
     * in O(N) time and O(1) space.
     */
    private static class BinarySearchTreeInorderValidator implements
                                                          BSTValidator{

        private boolean inOrderHelper(BinaryTree.Node node, Integer prev){
            if(node == null) return true;
            if(inOrderHelper(node.left, prev)){
                if(node.data > prev){
                    return inOrderHelper(node.right, new Integer(node.data));

                }
                else return false;
            }
            else
                return false;
        }

        @Override
        public boolean isValid(BinaryTree bt) {
            return inOrderHelper(bt.getRoot(), Integer.MIN_VALUE);
        }
    }


    public static void main(String[] args) {
        // valid binary tree
        BinaryTreeConstructor btc =
                new TrivialBinaryTreeConstructor(new BinaryTree());
        BinaryTree bt = btc.construct();
        // print the tree
        bt.print(new BinaryTreePrettyWriter());
        // validate using brut force approach
        BSTValidator validator =
                ValidBinarySearchTree.getValidator(ALGO.BRUT_FORCE);
        // check if valid should be true
        assert (validator.isValid(bt) == true);
        System.out.println("brut force=" + validator.isValid(bt));
        // use range comparison
        validator =
                ValidBinarySearchTree.getValidator(ALGO.RANGE_COMPARISON);
        // check if valid should be true
        assert (validator.isValid(bt) == true);
        System.out.println("range comparison force=" +
                                   validator.isValid(bt));
        // use inorder validation
        validator =
                ValidBinarySearchTree.getValidator(ALGO.INORDER_VALIDATOR);
        // check if valid should be true
        assert (validator.isValid(bt) == true);
        System.out.println("inoder validation=" +
                                   validator.isValid(bt));


        // invalid binary tree
        bt = BinaryTreeFactory
                .getBinaryTree(BinaryTreeFactory.BINARY_TREE.INVALID_BST);
        // print the tree
        bt.print(new BinaryTreePrettyWriter());
        // validate using brut force approach
        validator = ValidBinarySearchTree.getValidator(ALGO.BRUT_FORCE);
        // check if valid should be false
        assert (validator.isValid(bt) == false);
        System.out.println("brut force=" + validator.isValid(bt));
        // using range comparison algo
        validator = ValidBinarySearchTree.getValidator(ALGO.RANGE_COMPARISON);
        // check if valid should be false
        assert (validator.isValid(bt) == false);
        System.out.println("range comarison force=" +
                                   validator.isValid(bt));
        // using inoredr validation
        validator = ValidBinarySearchTree.getValidator(ALGO.INORDER_VALIDATOR);
        // check if valid should be false
        assert (validator.isValid(bt) == false);
        System.out.println("range comarison force=" +
                                   validator.isValid(bt));
    }
}
