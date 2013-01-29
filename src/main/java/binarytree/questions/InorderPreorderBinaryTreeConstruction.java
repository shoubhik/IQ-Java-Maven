package binarytree.questions;

import binarytree.*;

import java.util.List;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Hint:
 A good way to attempt this question is to work backwards. Approach this
 question by drawing a binary tree, then list down its preorder and inorder
 traversal. As most binary tree problems, you want to solve this recursively.

 About Duplicates:
 In this solution, we will assume that duplicates are not allowed in the
 binary tree. Why?

 Consider the following case:

 preorder = {7, 7}
 inorder = {7, 7}
 We can construct the following trees which are both perfectly valid solutions.

 7                     7
 /           or          \
 7                         7

 example tree
                  __1______________
          /                                \
   _______2______                  _______3______
   /              \                /              \
 ___4__             5           6               7
 /      \
 8      _9
       /  \
     10  11

 */
public class InorderPreorderBinaryTreeConstruction {


    private List<Integer> getPreorder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.PREPORDER, bt);
        return traversal.getOrderWalkList();

    }

    private List<Integer> getInorder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.INORDER, bt);
        return traversal.getOrderWalkList();
    }


    private BinaryTree.Node getBinaryTreeFromInorderPreOrder(
            List<Integer> inorder, List<Integer> preorder) {
        List<Integer> leftInroder;
        List<Integer> rightInorder;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        int inorderIdx, preOrderIdx;
        BinaryTree.Node node = null;
        if (inorder.size() != 0 && preorder.size() != 0) {
            node = BinaryTree.getNewNode(preorder.get(0));
            inorderIdx = inorder.indexOf(preorder.get(0));
            leftInroder = inorder.subList(0, inorderIdx);
            rightInorder = inorder.subList(inorderIdx + 1, inorder.size());
            preOrderIdx = leftInroder.size();
            leftPreOrder = preorder.subList(1, preOrderIdx + 1);
            rightPreOrder = preorder.subList(preOrderIdx + 1, preorder.size());
            node.left =
                    getBinaryTreeFromInorderPreOrder(leftInroder, leftPreOrder);
            node.right = getBinaryTreeFromInorderPreOrder(rightInorder,
                                                          rightPreOrder);

        }
        return node;
    }

    public static void main(String[] args) {
        BinaryTree bt = BinaryTreeFactory
                .getBinaryTree(BinaryTreeFactory.BINARY_TREE.COMPLETE_BINARY_TREE);
        // print the binary tree
        System.out.println("Input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        InorderPreorderBinaryTreeConstruction construct =
                new InorderPreorderBinaryTreeConstruction();
        // print preorder
        List<Integer> preorder = construct.getPreorder(bt);
        System.out.println("prorder = " + preorder);
        // print inorder
        List<Integer> inorder = construct.getInorder(bt);
        System.out.println("inorder  = " + inorder);

        BinaryTree.Node root =
                construct.getBinaryTreeFromInorderPreOrder(inorder, preorder);
        // create a new binary tree
        bt = new BinaryTree(root);

        // recreate the tree

        System.out.println("the reproduced binary tree");
        bt.print(new BinaryTreePrettyWriter());


    }
}
