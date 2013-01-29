package binarytree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: shoubhik Date: 11/12/12 Time: 1:54 PM] serialize the binary tree in a
 * preorder traversal
 */
public class BinaryTreeFileSerializer implements BinaryTreeWriter {

    private String fileName;
    private FileWriter fstream;
    private BufferedWriter out;
    private TreeSerializer serializer;

    public static enum TreeType {
        BST, BINARY_TREE
    }

    private TreeType treeType;

    private interface TreeSerializer {
        public void serialize(BinaryTree bt);
    }

    private class BSTSerializer extends BaseBinaryTreeOrderTraversal
            implements TreeSerializer {

        private Order order;
        private BufferedWriter out;

        public BSTSerializer(Order order, BufferedWriter out) {
            this.order = order;
            this.out = out;
        }

        @Override
        protected void takeAction(BinaryTree.Node node) {
            try {
                out.write(node.data + "\n");
            } catch (IOException e) {
                throw new RuntimeException(
                        "unable to write data for node = " + node.data + "at " +
                                "file" +
                                " = " + fileName);

            }
        }

        @Override
        public void serialize(BinaryTree bt) {
            super.walk(this.order, bt);
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException("unable to close out stream");
            }
        }
    }

    private class BinaryTreeSerializer extends BaseBinaryTreeOrderTraversal
            implements TreeSerializer {

        private Order order;
        private BufferedWriter out;

        public BinaryTreeSerializer(Order order, BufferedWriter out) {
            this.order = order;
            this.out = out;
        }

        protected void takeActionForNullNode() {
            try {
                out.write("# ");
            } catch (IOException e) {
                throw new RuntimeException(
                        "unable to write data for node = null" + "at file" +
                                " = " + fileName);

            }

        }


        @Override
        protected void takeAction(BinaryTree.Node node) {
            try {
                out.write(node.data + " ");
            } catch (IOException e) {
                throw new RuntimeException(
                        "unable to write data for node = " + node.data + "at " +
                                "file" +
                                " = " + fileName);

            }
        }

        @Override
        public void serialize(BinaryTree bt) {
            super.walk(this.order, bt);
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException("unable to close out stream");
            }
        }
    }

    private TreeSerializer getSerializer(TreeType treeType,
                                         BufferedWriter out) {
        switch (treeType) {
            case BST:
                return new BSTSerializer(
                        BaseBinaryTreeOrderTraversal.Order.PREPORDER, out);
            case BINARY_TREE:
                return new BinaryTreeSerializer(
                        BaseBinaryTreeOrderTraversal.Order.PREPORDER, out);

        }
        throw new IllegalArgumentException("illegal tree type");
    }

    public BinaryTreeFileSerializer(String filename,
                                    TreeType treeType) throws IOException {
        this.treeType = treeType;
        this.fileName = filename;
        fstream = new FileWriter(filename);
        out = new BufferedWriter(fstream);
        this.serializer = getSerializer(treeType, out);
    }


    @Override
    public void write(BinaryTree bt) {
        this.serializer.serialize(bt);
    }


    public static void main(String[] args) throws IOException {
//        BinaryTreeConstructor btc = new TrivialBinaryTreeConstructor(new
//        BinaryTree());
//        BinaryTree bt = btc.construct();
        BinaryTree bt = BinaryTreeFactory.getBinaryTree(
                BinaryTreeFactory.BINARY_TREE.BINARY_TREE_FOR_SERIALIZATION);
        BinaryTreeWriter writer = new BinaryTreeFileSerializer("BinaryTree",
                                                               TreeType.BINARY_TREE);
        writer.write(bt);
    }
}
