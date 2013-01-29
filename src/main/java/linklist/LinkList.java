package linklist;

/**
 * User: shoubhik Date: 21/12/12 Time: 4:42 PM
 */
public class LinkList {

    public static class LinkListNode{

        public int data;
        public LinkListNode next;
        public LinkListNode random;


        public LinkListNode(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static LinkListNode getNewNode(int data){
        return new LinkListNode(data);
    }
    private LinkListNode head;

    private boolean hasRandomNode = false;

    public LinkList(){
        this.head = null;
    }

    public LinkList(int data){
        this.head = new LinkListNode(data);
    }

    public LinkList(int arr[]){
        addLast(arr);
    }

    private LinkList(boolean hasRandomNode){
        this.hasRandomNode = hasRandomNode;
        this.head = null;
    }

    public static LinkList getListWithRandomLinks(int arr[], int randomLinks[]){
        LinkList linkList = new LinkList(true);
        linkList.addLast(arr);
        linkList.connectRandomNodes(randomLinks);

        return linkList;
    }


    private void connectRandomNodes(int randomLinks[]) {
        LinkListNode temp = getHead();
        for(int idx : randomLinks){
            temp.random = idx == -1 ? null : getNodeWithIndex(idx);
            temp = temp.next;
        }
    }

    private LinkListNode getNodeWithIndex(int index){
        LinkListNode temp = getHead();
        int count = 0;
        while(temp != null){
            if(count == index)
                return temp;
            else  {
                count++;
                temp = temp.next;
            }
        }
        return null;
    }

    private int getIndexOfNode(LinkListNode node){
        if(node == null)
            return -1;
        int count = 0;
        LinkListNode temp = getHead();
        while(temp != node) {
            count++;
            temp = temp.next;
        }
        return count;
    }



    public LinkListNode getHead() {
        return head;
    }

    public void setHead(LinkListNode node){
        this.head = node;
    }

    public void addLast(int data){
        if(this.head == null){
            this.head = new LinkListNode(data);
            return;
        }
        LinkListNode temp = this.head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = new LinkListNode(data);
    }

    public void addLast(int arr[]){
        for(int data : arr)
            addLast(data);
    }

    public int getLength(){
        LinkListNode temp = this.head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void print(){

        System.out.print(toString());
    }

    public String toString(){
        return !hasRandomNode ? toStringForSimpleLinkList() :
                toStringForLinListWithRandomNodes();
    }

    public String toStringForSimpleLinkList(){
        LinkListNode temp = getHead();
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while(temp != null) {
            sb.append(temp.data);
            if(temp.next != null)
                sb.append(" ,");
            temp=temp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }


    public String toStringForLinListWithRandomNodes(){
        LinkListNode temp = getHead();
        StringBuilder sb = new StringBuilder();
        while(temp != null) {
            sb.append("[ next:(");
            sb.append(getIndexOfNode(temp));
            sb.append(",");
            sb.append(getIndexOfNode(temp.next));
            sb.append("), random:(");
            sb.append(getIndexOfNode(temp));
            sb.append(",");
            sb.append(getIndexOfNode(temp.random));
            sb.append(") ]\n");
            temp = temp.next;
        }
        return sb.toString();
    }

    public void setHasRandomNode(boolean  hasRandomNode){
        this.hasRandomNode = hasRandomNode;
    }
}
