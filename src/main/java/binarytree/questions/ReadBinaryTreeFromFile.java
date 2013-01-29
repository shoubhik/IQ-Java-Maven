package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Design an algorithm and write code to serialize and deserialize a binary
 * tree. Writing the tree to a file is called ‘serialization’ and reading
 * back from the file to reconstruct the exact same binary tree is
 * ‘deserialization’.
 *
 * Hint:
 If you have not read my previous article about Saving a Binary Search Tree
 to a File, you should read it now. Since we are dealing with a binary tree,
 not a binary search tree (BST), our previous method will not work. However,
 this will get you started.

 Solution:
 Our previous method will not work in the case of Binary Tree,
 because binary trees are not bound with the same rule as BST. In order for
 the nodes to be inserted at the correct place, we would need to output the
 NULL nodes using some kind of sentinel (Here, we use ‘#‘ as the sentinel) as
 we are doing pre-order traversal.

 Assume we have a binary tree below:

    _30_
  /     \
 10     20
 /     /  \
50    45  35
 Using pre-order traversal, the algorithm should write the following to a file:

 30 10 50 # # # 20 45 # # 35 # #

 */
public class ReadBinaryTreeFromFile implements BinaryTreeConstructor {

    private String fileName;
    private FileReader fstream;
    private BufferedReader in;
    private int idx  =  0;
    private BinaryTree binaryTree;

    public ReadBinaryTreeFromFile(String fileName) throws FileNotFoundException,
            URISyntaxException {
        assert (fileName != null);
        this.fileName = fileName;
        File f = new File(getClass().getResource(this.fileName).toURI());
        this.fstream = new FileReader(f);
        this.in = new BufferedReader(fstream);
        this.binaryTree = new BinaryTree(0);

    }

    private String[] getPreOrderWithSentennial() throws IOException {
        String line  = this.in.readLine().trim();
        return line.split(" ");
    }

    private void createBinaryTree(String[] data,  BinaryTree.Node node){
        if(idx >= data.length) return ;
        if(!data[idx].equals("#")){
            node.data = Integer.parseInt(data[idx]);
            idx++;
            if(idx >= data.length) return ;
            if(!data[idx].equals("#"))
                node.makeNonNullLeft();
            createBinaryTree(data, node.left);
            idx++;
            if(idx >= data.length) return ;
            if(!data[idx].equals("#"))
                node.makeNonNullRight();
            createBinaryTree(data, node.right);
        }
    }

    @Override
    public BinaryTree construct() {
        try {
            String data[] = getPreOrderWithSentennial();
            createBinaryTree(data, this.binaryTree.getRoot());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.binaryTree;

    }

    public static void main(String[] args) throws FileNotFoundException,
            URISyntaxException {
        System.out.println("path  " + System.getProperty("user.dir"));

        BinaryTreeConstructor constructor = new ReadBinaryTreeFromFile("BinaryTree");

        BinaryTree bt = constructor.construct();
        // print the tree
        bt.print(new BinaryTreePrettyWriter());

    }
}
