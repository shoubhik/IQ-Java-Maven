package binarytree.questions;

import binarytree.BinaryTree;
import binarytree.BinaryTreeConstructor;
import binarytree.BinaryTreePrettyWriter;
import binarytree.BinaryTreeWriter;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Stack;

/**
 * Post-order traversal is useful in some types of tree operations:

 Tree deletion. In order to free up allocated memory of all nodes in a tree,
 the nodes must be deleted in the order where the current node can only be
 deleted when both of its left and right subtrees are deleted.
 Evaluating post-fix notation.
 */
public class IterativePostOrderTraversal implements BinaryTreeWriter{

    public static enum Algo{
        TWO_STACK, SINGLE_STACK
    }

    private Algo algo;

    public IterativePostOrderTraversal(Algo algo) {
        assert(algo != null);
        this.algo = algo;
    }


    /**
     * An alternative solution is to use two stacks. Try to work it out on a
     * piece of paper. I think it is quite magical and beautiful. You will
     * think that it works magically, but in fact it is doing a reversed
     * pre-order traversal. That is, the order of traversal is a node,
     * then its right child followed by its left child. This yields
     * post-order traversal in reversed order. Using a second stack,
     * we could reverse it back to the correct order.

     Here is how it works:

     Push the root node to the first stack.
     Pop a node from the first stack, and push it to the second stack.
     Then push its left child followed by its right child to the first stack.
     Repeat step 2) and 3) until the first stack is empty.
     Once done, the second stack would have all the nodes ready to be
     traversed in post-order. Pop off the nodes from the second stack one by one
     and you’re done.

     Complexity Analysis:
     The two-stack solution takes up more space compared to the first
     solution using one stack. In fact, the first solution has a space
     complexity of O(h), where h is the maximum height of the tree. The
     two-stack solution however, has a space complexity of O(n),
     where n is the total number of nodes.
     * @param bt
     */
    private void usingTwoStacks(BinaryTree bt) {
        if (bt.getRoot() == null) return;
        Stack<BinaryTree.Node> stack1 = new Stack<BinaryTree.Node>();
        Stack<BinaryTree.Node> stack2 = new Stack<BinaryTree.Node>();
        stack1.push(bt.getRoot());
        while (!stack1.isEmpty()) {
            BinaryTree.Node node = stack1.pop();
            stack2.push(node);
            if(node.left != null)
                stack1.push(node.left);
            if(node.right != null)
                stack1.push(node.right);
        }
        System.out.print("postorder using 2 stacks = ");
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
    }

    /**
     * We use a prev variable to keep track of the previously-traversed node.
     * Let’s assume curr is the current node that’s on top of the stack. When
     * prev is curr‘s parent, we are traversing down the tree. In this case,
     * we try to traverse to curr‘s left child if available (ie,
     * push left child to the stack). If it is not available,
     * we look at curr‘s right child. If both left and right child do not
     * exist (ie, curr is a leaf node), we print curr‘s value and pop it off
     * the stack.

     If prev is curr‘s left child, we are traversing up the tree from the
     left. We look at curr‘s right child. If it is available,
     then traverse down the right child (ie, push right child to the stack),
     otherwise print curr‘s value and pop it off the stack.

     If prev is curr‘s right child, we are traversing up the tree from the right.
     In this case, we print curr‘s value and pop it off the stack.
     * @param bt
     */

    private void usingSingleStack(BinaryTree bt) {
        if(bt.getRoot() == null ) return;
        System.out.print("postorder using 1 stack = ");
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        stack.push(bt.getRoot());
        BinaryTree.Node prev = null;
        while(!stack.isEmpty()) {
            BinaryTree.Node curr = stack.peek();
            // we are traversing down the tree
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null)
                    stack.push(curr.left);
                else if(curr.right != null)
                    stack.push(curr.right);
                else{
                    System.out.print(curr.data + " ");
                    stack.pop();
                }

            }
            // we are traversing up the tyree form the left\
            else if(curr.left == prev){
                if(curr.right != null)
                    stack.push(curr.right);
                else{
                    System.out.print(curr.data + " ");
                    stack.pop();
                }
            }
            // we are traversing up the tree from the right
            else if(curr.right == prev){
                System.out.print(curr.data + " ");
                stack.pop();
            }
            prev = curr;
        }
    }

    @Override
    public void write(BinaryTree bt) {
        switch(this.algo){
            case TWO_STACK :
                usingTwoStacks(bt);
                break;
            case SINGLE_STACK:
                usingSingleStack(bt);

        }

    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BinaryTreeConstructor btc = new ReadBinaryTreeFromFile("BinaryTree");
        BinaryTree bt = btc.construct();
        System.out.println("input tree");
        bt.print(new BinaryTreePrettyWriter());
        bt.print(new IterativePostOrderTraversal(Algo.TWO_STACK));
        System.out.println();
        bt.print(new IterativePostOrderTraversal(Algo.SINGLE_STACK));

    }
}
