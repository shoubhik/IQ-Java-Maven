package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;

/**
 * User: shoubhik Date: 1/1/13 Time: 5:06 PM
 */
public class SearchInBSTRecursively {

    public BinaryTree.Node  searchNode(BinaryTree.Node node, int item){
        if(node == null) return null;
        if(node.data == item) return node;
        if(node.data > item) return searchNode(node.left, item);
        else return searchNode(node.right, item);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTreeConstructor btc = new ReadBSTFromFile("TrivialBinaryTree");
        BinaryTree bt = btc.construct();
        System.out.println("input binary tree:");
        bt.print(new BinaryTreePrettyWriter());
        int searchElement = 32;
        SearchInBSTRecursively searchInBSTRecursively =
                new SearchInBSTRecursively();
        BinaryTree.Node searchNode =
                searchInBSTRecursively.searchNode(bt.getRoot(), searchElement);
        System.out.println("element 32 should be found: "+
                                   Boolean.toString(searchNode != null));
        searchElement = 50;

        searchNode =
                searchInBSTRecursively.searchNode(bt.getRoot(), searchElement);
        System.out.println("element 50 should not be found: "+
                                   Boolean.toString(searchNode == null));

        System.out.println("testing boundary conditions");
        searchElement = 20;

        searchNode =
                searchInBSTRecursively.searchNode(bt.getRoot(), searchElement);
        System.out.println("root should not be found: "+
                                   Boolean.toString(searchNode != null));

        searchElement = 26;

        searchNode =
                searchInBSTRecursively.searchNode(bt.getRoot(), searchElement);
        System.out.println("leaf node should not be found: "+
                                   Boolean.toString(searchNode != null));




    }
}
