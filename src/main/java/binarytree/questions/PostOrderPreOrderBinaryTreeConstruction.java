package binarytree.questions;

import binarytree.*;

import java.util.Collections;
import java.util.List;

/**
 * This is applicable only for complete binary tree.
 */
public class PostOrderPreOrderBinaryTreeConstruction {

    private List<Integer> getPreorder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.PREPORDER, bt);
        return traversal.getOrderWalkList();

    }

    private List<Integer> getPostOrder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.POSTORDER, bt);
        return traversal.getOrderWalkList();
    }

    private BinaryTree.Node getTreeFromPostOrderPreOrder(
            List<Integer> postOrder, List<Integer> preorder) {
        BinaryTree.Node node = null;
        List<Integer> leftPostOrder;
        List<Integer> rightPostOrder;
        List<Integer> leftPreOrder;
        List<Integer> rightPreOrder;
        int postOrderIdx, preOrderIdx;
        if (postOrder.size() != 0 && preorder.size() != 0) {
            node = BinaryTree.getNewNode(preorder.get(0));
            if (preorder.size() == 1) {
                postOrderIdx = -1;
                preOrderIdx = postOrderIdx + 2;
            } else {
                postOrderIdx = postOrder.indexOf(preorder.get(1));
                preOrderIdx = postOrder.indexOf(preorder.get(0));
            }
            leftPostOrder = postOrderIdx != -1 ?
                    postOrder.subList(0, postOrderIdx + 1) :
                    Collections.<Integer>emptyList();
            rightPostOrder = postOrder.subList(postOrderIdx + 1, preOrderIdx);
            leftPreOrder = preorder.subList(1, leftPostOrder.size() + 1);
            rightPreOrder =
                    preorder.subList(leftPostOrder.size() + 1, preorder.size());
            node.left =
                    getTreeFromPostOrderPreOrder(leftPostOrder, leftPreOrder);
            node.right =
                    getTreeFromPostOrderPreOrder(rightPostOrder, rightPreOrder);

        }
        return node;
    }

    public static void main(String[] args) {
        BinaryTree bt = BinaryTreeFactory
                .getBinaryTree(BinaryTreeFactory.BINARY_TREE.COMPLETE_BINARY_TREE);
        PostOrderPreOrderBinaryTreeConstruction construct =
                new PostOrderPreOrderBinaryTreeConstruction();
        List<Integer> preorder = construct.getPreorder(bt);
        System.out.println("Input binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println("preorder = " + preorder);
        List<Integer> postOrder = construct.getPostOrder(bt);
        System.out.println("postorder =" + postOrder);
        // reconstruct from prostorder and preorder

        bt = new BinaryTree(
                construct.getTreeFromPostOrderPreOrder(postOrder, preorder));
        System.out.println("constructed tree");
        bt.print(new BinaryTreePrettyWriter());
    }
}
