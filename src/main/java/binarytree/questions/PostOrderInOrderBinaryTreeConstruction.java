package binarytree.questions;

import binarytree.*;

import java.util.Collections;
import java.util.List;

/**
 * User: shoubhik Date: 16/12/12 Time: 8:13 PM
 */
public class PostOrderInOrderBinaryTreeConstruction {

    private List<Integer> getPostOrder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.POSTORDER, bt);
        return traversal.getOrderWalkList();

    }

    private List<Integer> getInorder(BinaryTree bt) {
        BinaryTreeOrderListAdapter traversal = new BinaryTreeOrderListAdapter();
        traversal.walk(BaseBinaryTreeOrderTraversal.Order.INORDER, bt);
        return traversal.getOrderWalkList();
    }

    private BinaryTree.Node getTreeFromPostOrderInOrder(List<Integer> postOrder, List<Integer> inorder){
        BinaryTree.Node node = null;
        List<Integer> leftPostOrder;
        List<Integer> rightPostOrder;
        List<Integer> leftInOrder;
        List<Integer> rightInOrder;
        int inOrderIdx, postOrderIdx;
        if(postOrder.size() != 0 && inorder.size() != 0){
            node = BinaryTree.getNewNode(postOrder.get(postOrder.size() -1));
            inOrderIdx = inorder.indexOf(postOrder.get(postOrder.size() -1));
            leftInOrder = inorder.subList(0, inOrderIdx);
            rightInOrder = inorder.subList(inOrderIdx + 1, inorder.size());
            postOrderIdx = leftInOrder.size();
            leftPostOrder = postOrder.subList(0, postOrderIdx);
            rightPostOrder = postOrder.subList(postOrderIdx ,
                                               postOrder.size() - 1);
            node.left = getTreeFromPostOrderInOrder(leftPostOrder, leftInOrder);
            node.right = getTreeFromPostOrderInOrder(rightPostOrder,
                                                     rightInOrder);
        }
        return node;
    }

    public static void main(String[] args) {
        BinaryTree bt = BinaryTreeFactory
                .getBinaryTree(
                        BinaryTreeFactory.BINARY_TREE.COMPLETE_BINARY_TREE);
        PostOrderInOrderBinaryTreeConstruction  construct =
                new PostOrderInOrderBinaryTreeConstruction ();
        List<Integer> inorder = construct.getInorder(bt);
        System.out.println("Complete binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println("inorder = " + inorder);
        List<Integer> postOrder = construct.getPostOrder(bt);
        System.out.println("postorder =" + postOrder);
        // construct binary tree
        bt = new BinaryTree(construct.getTreeFromPostOrderInOrder(postOrder,
                                                                  inorder));
        System.out.println("Printing constructed tree");
        bt.print(new BinaryTreePrettyWriter());


        // with incomplete binary tree

        bt = BinaryTreeFactory
                .getBinaryTree(
                        BinaryTreeFactory.BINARY_TREE.INCOMPLETE_BINARY_TREE);
        inorder = construct.getInorder(bt);
        System.out.println("Incomplete binary tree");
        bt.print(new BinaryTreePrettyWriter());
        System.out.println("inorder = " + inorder);
        postOrder = construct.getPostOrder(bt);
        System.out.println("postorder =" + postOrder);
        // construct binary tree
        bt = new BinaryTree(construct.getTreeFromPostOrderInOrder(postOrder,
                                                                  inorder));
        System.out.println("Printing constructed tree");
        bt.print(new BinaryTreePrettyWriter());
    }

}
