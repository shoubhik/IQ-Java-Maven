package linklist;

/**
 * Divide the given liklist into two lists. one with the even nodes and one with t
 * he odd nodes.
 */
public class DivideIntoTwoLinkList {

    public static void main(String[] args) {
        LinkList original = new LinkList(new int[]{1,2,3,4});
        System.out.println("original = " + original.toStringForSimpleLinkList());
        if(original.getHead() == null)
            return;
        LinkList oddList = new LinkList();
        LinkList eveList = new LinkList();
        LinkList.LinkListNode oddNode = original.getHead();
        LinkList.LinkListNode evenNode = oddNode.next;
        oddList.setHead(oddNode);
        eveList.setHead(evenNode);
        while(oddNode != null && evenNode != null){
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            if(oddNode != null)
                evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        System.out.println("odd list = " + oddList.toStringForSimpleLinkList());
        System.out.println("even list = " + eveList.toStringForSimpleLinkList());
        System.out.println("\u2191");
    }
}
