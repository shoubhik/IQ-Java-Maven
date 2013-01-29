package binarytree;

import readerwriters.PaddedWriter;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * User: shoubhik Date: 10/12/12 Time: 12:42 PM
 */
public class BinaryTreePrettyWriter implements BinaryTreeWriter {

    public static enum Sibling{
        LEFT, RIGHT;
    }

    private BinaryTreeHeightCalculator binaryTreeHeightCalculator;
    private int level, indentSpace;
    private PaddedWriter out;
    private Sibling sibling;



    public BinaryTreePrettyWriter() {
        this(null);
    }

    public BinaryTreePrettyWriter(Sibling sibling) {
        binaryTreeHeightCalculator = new BinaryTreeHeightCalculator();
        level = 1;
        indentSpace = 0;
        out = new PaddedWriter(System.out);
        this.sibling =  sibling;
    }

    @Override
    public void write(BinaryTree bt) {
        printPretty(bt, level, indentSpace, out);
    }

    private void printPretty(BinaryTree tree, int level, int indentSpace,
                             PaddedWriter out) {
        int h = binaryTreeHeightCalculator.getMaXHeight(tree);
        int nodesInThisLevel = 1;
        int branchLen =
                2 * ((int) Math.pow(2.0, h) - 1) - (3 - level) * (int) Math
                        .pow(2.0, h - 1);
        int nodeSpaceLen = 2 + (level + 1) * (int) Math.pow(2.0, h);
        int startLen = branchLen + (3 - level) + indentSpace;

        Deque<BinaryTree.Node> nodesQueue = new LinkedList<BinaryTree.Node>();
        nodesQueue.offerLast(tree.getRoot());
        for (int r = 1; r < h; r++) {
            printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel,
                          nodesQueue, out);
            branchLen = branchLen / 2 - 1;
            nodeSpaceLen = nodeSpaceLen / 2 + 1;
            startLen = branchLen + (3 - level) + indentSpace;
            printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel,
                       nodesQueue, out);

            for (int i = 0; i < nodesInThisLevel; i++) {
                BinaryTree.Node currNode = nodesQueue.pollFirst();
                if (currNode != null) {
                    nodesQueue.offerLast(currNode.getLeft());
                    nodesQueue.offerLast(currNode.getRight());
                } else {
                    nodesQueue.offerLast(null);
                    nodesQueue.offerLast(null);
                }
            }
            nodesInThisLevel *= 2;
        }
        printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel,
                      nodesQueue, out);
        printLeaves(indentSpace, level, nodesInThisLevel, nodesQueue, out);
    }

    // Print the arm branches (eg, /    \ ) on a line
    private void printBranches(int branchLen, int nodeSpaceLen, int startLen,
                               int nodesInThisLevel,
                               Deque<BinaryTree.Node> nodesQueue,
                               PaddedWriter out) {
        Iterator<BinaryTree.Node> iterator = nodesQueue.iterator();
        for (int i = 0; i < nodesInThisLevel / 2; i++) {
            if (i == 0) {
                out.setw(startLen - 1);
            } else {
                out.setw(nodeSpaceLen - 2);
            }
            out.write();
            BinaryTree.Node next = iterator.next();
            if (next != null) {
                out.write("/");
            } else {
                out.write(" ");
            }
            out.setw(2 * branchLen + 2);
            out.write();
            next = iterator.next();
            if (next != null) {
                out.write("\\");
            } else {
                out.write(" ");
            }
        }
        out.endl();
    }

    // Print the branches and node (eg, ___10___ )
    private void printNodes(int branchLen, int nodeSpaceLen, int startLen,
                            int nodesInThisLevel,
                            Deque<BinaryTree.Node> nodesQueue,
                            PaddedWriter out) {
        Iterator<BinaryTree.Node> iterator = nodesQueue.iterator();
        BinaryTree.Node currentNode;
        for (int i = 0; i < nodesInThisLevel; i++) {
            currentNode = iterator.next();
            if (i == 0) {
                out.setw(startLen);
            } else {
                out.setw(nodeSpaceLen);
            }
            out.write();
            if (currentNode != null && currentNode.getLeft() != null) {
                out.setfill('_');
            } else {
                out.setfill(' ');
            }
            out.setw(branchLen + 2);
            if (currentNode != null) {
                out.write(currentNode.toString());
//                if(currentNode.nextRight != null) {
//                    out.setw(nodeSpaceLen);
//                    out.setfill('-');
//                    out.write();
//                    out.setw(branchLen);
//                }
            } else {
                out.write();
            }
            if (currentNode != null && currentNode.getRight() != null) {
                out.setfill('_');
            } else {
                out.setfill(' ');
            }
            out.setw(branchLen);
            out.write();
            out.setfill(' ');
        }
        out.endl();
    }

    // Print the leaves only (just for the bottom row)
    private void printLeaves(int indentSpace, int level, int nodesInThisLevel,
                             Deque<BinaryTree.Node> nodesQueue,
                             PaddedWriter out) {
        Iterator<BinaryTree.Node> iterator = nodesQueue.iterator();
        BinaryTree.Node currentNode;
        for (int i = 0; i < nodesInThisLevel; i++) {
            currentNode = iterator.next();
            if (i == 0) {
                out.setw(indentSpace + 2);
            } else {
                out.setw(2 * level + 2);
            }
            if (currentNode != null) {
                out.write(currentNode.toString());
            } else {
                out.write();
            }
        }
        out.endl();
    }
}
