package binarytree;

/**
 * Created with IntelliJ IDEA. User: shoubhik Date: 18/11/12 Time: 11:43 AM To
 * change this template use File | Settings | File Templates.
 */
public class TrivialBinaryTreeConstructor implements  BinaryTreeConstructor{

    private BinaryTree bt;

    public TrivialBinaryTreeConstructor(BinaryTree bt){
        assert(bt != null);
        this.bt = bt;
    }
    @Override
    public BinaryTree construct() {
        // level 0
        bt.setRoot(20);
        // level 1
        bt.addAsLeftChild(bt.getRoot(), bt.getNewNode(14));
        bt.addAsRightChild(bt.getRoot(), bt.getNewNode(32));
        //level 2
        bt.addAsLeftChild(bt.getRoot().left, bt.getNewNode(12));
        bt.addAsRightChild(bt.getRoot().left, bt.getNewNode(17));

        bt.addAsLeftChild(bt.getRoot().right, bt.getNewNode(26));

        return bt;
    }
}
