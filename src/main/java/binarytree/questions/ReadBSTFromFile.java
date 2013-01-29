package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: shoubhik Date: 11/12/12 Time: 3:43 PM Read/Construct a BST from file
 * written in <b>Preorder</b> Describe an algorithm to save a Binary Search Tree
 * (BST) to a file in terms of run-time and disk space complexity. You must be
 * able to restore to the exact original BST using the saved format.
 * Hint:
 Remember the big three tree traversal algorithm? Yes, it’s pre-order,
 in-order, and post-order traversal. Only one of them is useful for storing a
 BST.

 Assume we have the following BST:

   _30_
  /     \
 20     40
 /     /  \
10    35  50

 In-order traversal
 If we do an in-order traversal, we will output 10 20 30 35 40 50. There is
 no way of telling how the original BST structure looks like,
 as the following unbalanced BST is one of the possible BST sets from the
 output 10 20 30 35 40 50.

 _50
 /
 40
 /
 35
 /
 30
 /
 20
 /
 10

 Post-order traversal:
 If we do a post-order traversal, we will output the leaf nodes before its
 parent node. Specifically, we will output 10 20 35 50 40 30 using post-order
 traversal. Imagine we’re reading the nodes to construct the tree back. See
 the problem that we are reading the leaf nodes before its parent? There’s
 too much trouble to create the child nodes before its parent. Remember that
 the BST insertion algorithm works by traversing the tree from the root to
 the correct leaf to insert.

 Pre-order traversal:
 Pre-order traversal is the perfect algorithm for making a copy of a BST. The
 output of a pre-order traversal of the BST above is 30 20 10 40 35 50.
 Please note the following important observation:

 A node’s parent is always output before itself.

 Therefore, when we read the BST back from the file, we are always able to
 create the parent node before creating its child nodes. The code for writing
 a BST to a file is exactly the same as pre-order traversal.
 */
public class ReadBSTFromFile implements BinaryTreeConstructor {

    private String fileName;
    private FileReader fstream;
    private BufferedReader in;
    // the binary tree to construct.
    private BinaryTree binaryTree;

    public ReadBSTFromFile(String fileName) throws FileNotFoundException {
        assert (fileName != null);
        this.fileName = fileName;
        this.fstream = new FileReader(fileName);
        this.in = new BufferedReader(fstream);
        // empty binary terr
        this.binaryTree = new BinaryTree();
    }

    @Override
    /**
     * Remember my post: Determine if a Binary Tree is a Binary Search Tree
     * (BST) http://www.leetcode.com/2010/09/determine-if-binary-tree-is-binary.html?

     We use the same idea here. We pass the valid range of the values from
     the parent node to its child nodes. When we are about to insert a node,
     we will check if the insert value is in the valid range. If it is,
     this is the right space to insert. If it is not,
     we will try the next empty space. Reconstructing the whole BST from a file
     will take only O(n) time.
     */
    public BinaryTree construct() {
        try {
            // int data[] = getDataFromFile();
            int data = Integer.parseInt(this.in.readLine());
            // set dummy value
            this.binaryTree.setRoot(-1);
            readBSTHelper(Integer.MIN_VALUE, Integer.MAX_VALUE,
                          this.binaryTree.getRoot(), new int[]{data});

        } catch (IOException e) {
            throw new RuntimeException(
                    "error in reading data from file = " + this.fileName);
        }
        return this.binaryTree;
    }

    private void readBSTHelper(int min, int max, BinaryTree.Node p,
                               int data[]) {
        if (data[0] > min && data[0] < max) {
            int val = data[0];
            p.data = val;
            try {
                String line = this.in.readLine();
                if (line == null) return;
                data[0] = Integer.parseInt(line);
                if (data[0] > min && data[0] < p.data) {
                    p.makeNonNullLeft();
                    readBSTHelper(min, p.data, p.left, data);
                }
                if (data[0] > p.data && data[0] < max) {
                    p.makeNonNullRight();
                    readBSTHelper(p.data, max, p.right, data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree bt = btc.construct();
        BinaryTreeWriter writer = new BinaryTreePrettyWriter();
        writer.write(bt);
    }
}
