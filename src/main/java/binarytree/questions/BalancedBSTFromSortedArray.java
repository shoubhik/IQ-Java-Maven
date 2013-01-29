package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import utils.Utils;

import java.util.Arrays;

import static utils.Utils.printArraySingleLine;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class BalancedBSTFromSortedArray implements BinaryTreeConstructor{

    private int input[];
    private BinaryTree out;

    public BalancedBSTFromSortedArray(int arr[]) {
        assert(arr != null);
        this.input = arr;
        this.out = new BinaryTree();
    }

    private BinaryTree.Node getTreeFromSortedArray(int arr[], int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        BinaryTree.Node node = BinaryTree.getNewNode(arr[mid]);
        node.left = getTreeFromSortedArray(arr, start, mid -1);
        node.right = getTreeFromSortedArray(arr, mid + 1, end);
        return node;
    }

    @Override
    public BinaryTree construct() {
        this.out.setRoot(getTreeFromSortedArray(this.input, 0,
                                                this.input.length - 1 ));
        return this.out;
    }

    public static void main(String[] args) {
        int input[] = {9,12,14,17,19,23,50,54,67,72,76};
        System.out.println("input array = " + printArraySingleLine(input));
        BinaryTreeConstructor btc = new BalancedBSTFromSortedArray(input);
        BinaryTree bt = btc.construct();
        System.out.println("output tree");
        bt.print(new BinaryTreePrettyWriter());
    }
}
