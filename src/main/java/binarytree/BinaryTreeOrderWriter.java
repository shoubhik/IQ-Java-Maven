package binarytree;


/**
 * User: shoubhik Date: 11/12/12 Time: 12:41 PM
 */
public class BinaryTreeOrderWriter extends BaseBinaryTreeOrderTraversal
        implements BinaryTreeWriter {


    public BinaryTreeOrderWriter(Order order) {
        assert(order != null);
        this.order = order;
    }

    @Override
    public void write(BinaryTree bt) {
        super.walk(this.order, bt);

    }

    @Override
    protected void takeAction(BinaryTree.Node node) {
        System.out.print(node.data + " ");
    }
}
