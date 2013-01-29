package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Return a list of the walk.
 */
public class BinaryTreeOrderListAdapter extends BaseBinaryTreeOrderTraversal {

    private List<Integer> orderList;

    public BinaryTreeOrderListAdapter() {
        orderList = new ArrayList<Integer>();
    }

    @Override
    protected void takeAction(BinaryTree.Node node) {
        orderList.add(node.data);
    }

    public List<Integer> getOrderWalkList() {
        return this.orderList;
    }
}