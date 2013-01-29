package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import linklist.LinkList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Naive Solution:
 A naive way is to apply the previous solution directly. In each recursive
 call, you would have to traverse half of the list’s length to find the
 middle element. The run time complexity is clearly O(N lg N),
 where N is the total number of elements in the list. This is because each
 level of recursive call requires a total of N/2 traversal steps in the list,
 and there are a total of lg N number of levels (ie,
 the height of the balanced tree).

 Hint:
 How about inserting nodes following the list’s order? If we can achieve
 this, we no longer need to find the middle element,
 as we are able to traverse the list while inserting nodes to the tree.

 Best Solution:
 As usual, the best solution requires you to think from another perspective.
 In other words, we no longer create nodes in the tree using the top-down
 approach. We create nodes bottom-up, and assign them to its parents. The
 bottom-up approach enables us to access the list in its order while creating
 nodes.

 Isn’t the bottom-up approach neat? Each time you are stucked with the
 top-down approach, give bottom-up a try. Although bottom-up approach is not
 the most natural way we think, it is extremely helpful in some cases.
 However, you should prefer top-down instead of bottom-up in general,
 since the latter is more difficult to verify in correctness.
 */
public class BalancedBSTFromList implements BinaryTreeConstructor {

    private LinkList input;
    private BinaryTree out;
    private LinkList.LinkListNode listNode;

    public BalancedBSTFromList(LinkList list){
        assert(list != null);
        this.input = list;
        this.out = new BinaryTree();
    }

    /**
     * Below is the code for converting a singly linked list to a balanced
     * BST. Please note that the algorithm requires the list’s length to be
     * passed in as the function’s parameters. The list’s length could be
     * found in O(N) time by traversing the entire list’s once. The recursive
     * calls traverse the list and create tree’s nodes by the list’s order,
     * which also takes O(N) time. Therefore, the overall run time complexity is
     * still O(N).
     * @param start
     * @param end
     * @return
     */
    private BinaryTree.Node getBSTFromList( int start, int end){
        if(start > end ) return null;
        int mid  = (start + end) / 2;
        BinaryTree.Node leftChild = getBSTFromList( start, mid - 1);
        BinaryTree.Node parent = BinaryTree.getNewNode(listNode.data);
        parent.left = leftChild;
        listNode = listNode.next;
        parent.right = getBSTFromList(mid + 1, end);
        return parent;
    }

    @Override
    public BinaryTree construct() {
        this.listNode = this.input.getHead();
        BinaryTree.Node root = getBSTFromList( 0, this.input.getLength()-1);
        this.out.setRoot(root);
        return out;
    }

    public static void main(String[] args) {
        LinkList list = new LinkList(new int[]{9,12,14,17,19,23,50,54,67,72,76});
        System.out.print("input list = ");
        list.print();
        System.out.println();
        BinaryTreeConstructor btc = new BalancedBSTFromList(list);
        BinaryTree bt = btc.construct();
        System.out.println("output BST");
        bt.print(new BinaryTreePrettyWriter());
    }
}
