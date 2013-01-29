package binarytree;

/**
 * User: shoubhik Date: 10/12/12 Time: 12:43 PM
 */
public class BinaryTreeHeightCalculator {

    public int getMaXHeight(BinaryTree bt) {
        return calculateMaxHeight(bt.getRoot());
    }

    public int getMinHeight(BinaryTree bt) {
        return calculateMinHeight(bt.getRoot());

    }

    private int calculateMinHeight(BinaryTree.Node node) {
        if (node == null) return 0;
        return 1 + Math.min(calculateMinHeight(node.left),
                            calculateMinHeight(node.right));

    }

    private int calculateMaxHeight(BinaryTree.Node node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateMaxHeight(node.left),
                            calculateMaxHeight(node.right));
        // the following is another method

//        int leftHeight = calculateMaxHeight(node.left);
//        int rightHeight = calculateMaxHeight(node.right);
//        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
