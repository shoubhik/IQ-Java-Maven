package binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: shoubhik Date: 11/12/12 Time: 2:29 PM
 * Construct a binary tree for a queue: reverse BFS
 */
public class BFSBinaryTreeConstructor implements BinaryTreeConstructor {

    private Queue<Integer> nodesQueue;
    private BinaryTree binaryTree;

    public BFSBinaryTreeConstructor(Queue<Integer> nodesQueue) {
        this.nodesQueue = nodesQueue;
        this.binaryTree = new BinaryTree();
    }


    @Override
    public BinaryTree construct() {
        // set the root
        binaryTree.setRoot(this.nodesQueue.remove());
        for (Iterator<Integer> it = this.nodesQueue.iterator(); it.hasNext(); )
        {
            putInBinaryTree(it.next());
        }
        return binaryTree;
    }

    // do a normal ln(n) comparison to insert the value to correct place.
    private void putInBinaryTree(int val) {
        BinaryTree.Node node = this.binaryTree.getRoot();
        BinaryTree.Node parent = node;
        while (node != null) {
            parent = node;
            if (val < node.data) node = node.left;
            else node = node.right;
        }
        if (val < parent.data) this.binaryTree.addAsLeftChild(parent, val);
        else this.binaryTree.addAsRightChild(parent, val);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(20);
        q.add(14);
        q.add(32);
        q.add(12);
        q.add(17);
        q.add(26);
        BinaryTreeConstructor btc = new BFSBinaryTreeConstructor(q);
        BinaryTree bt = btc.construct();
        BinaryTreeWriter writer = new BinaryTreePrettyWriter();
        writer.write(bt);
    }
}
