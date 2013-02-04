package binarytree;

/**
 * Created with IntelliJ IDEA. User: shoubhik Date: 18/11/12 Time: 11:31 AM To
 * change this template use File | Settings | File Templates.
 */
public class BinaryTree {

    public static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node nextRight;
        public Node nextLeft;
        public Node parent;
        public boolean visited;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.nextRight = null;
            this.nextLeft = null;
            this.parent = null;
            this.visited  = false;
        }

        public String toString(){
            return new Integer(this.data).toString();
        }

        public Node getLeft(){
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setLeft(int data){
            this.makeNonNullLeft();
            this.left.data = data;
        }

        public void setRight(int data){
            this.makeNonNullRight();
            this.right.data = data;
        }

        public Node makeNonNullLeft(){
            if(this.left == null){
                this.left = new Node(0);
            }
            return this;
        }

        public Node addParentPointerToLeftChild(){
            if(this.left != null)
                this.left.parent = this;
            return this;
        }

        public Node makeNonNullRight(){
            if(this.right == null)
               this.right = new Node(0);
            return this;
        }

        public Node addParentPointerToRightChild(){
            if(this.right != null)
                this.right.parent = this;
            return this;
        }

        public boolean equals(Object node){
            if(!(node instanceof Node))
                return false;
            return ((Node)node).data == this.data;
        }
    }

    private Node root;

    public BinaryTree(){
        root  = null;
    }

    public BinaryTree(Integer data){
        this.root = new Node(data);
    }

    public BinaryTree(Node root){
        this.root = root;
    }

    public static Node getNewNode(int data){
        return new Node(data);
    }

    public void addAsLeftChild(Node parent, int child){
        assert(parent != null);
        parent.left = getNewNode(child);
    }

    public void addAsLeftChild(Node parent, Node child){
        assert(parent != null);
        parent.left = child;
    }

    public void addAsRightChild(Node parent, Node child){
        assert(parent != null);
        parent.right = child;
    }

    public void addAsRightChild(Node parent, int child){
        assert(parent != null);
        parent.right = getNewNode(child);
    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(int data){
        this.root = new Node(data);
    }

    public void setRoot(Node root) {
        this.root= root;
    }

    public void print(BinaryTreeWriter writer){
        writer.write(this);
    }
}
