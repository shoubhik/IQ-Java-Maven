package linklist;

/**
 * Reverse a Singly LinkList
 */
public class ReverseLinkList {

    public static LinkList.LinkListNode reverse(LinkList.LinkListNode parent,
                                         LinkList.LinkListNode child){
        LinkList.LinkListNode head = null;
        if(child != null){
            head = reverse(child, child.next);
            child.next = parent;
            parent.next = null;

        }
        else
            return parent;
        return head;

    }

    public static void main(String[] args) {
        LinkList ll = new LinkList(new int[]{1,2,3,4});
        System.out.println("input =" + ll.toStringForSimpleLinkList());
        LinkList.LinkListNode node = reverse(ll.getHead(), ll.getHead().next);
        ll.setHead(node);
        System.out.println("output = " + ll.toStringForSimpleLinkList());
    }
}
