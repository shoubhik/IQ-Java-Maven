package linklist;

/**
 * Given a linked-list and 2 integers k & m. Reverse the linked-list till k
 * elements and then traverse till m elements and repeat.
 */
public class RvereseKTravereseM {

    public static LinkList.LinkListNode reverse(LinkList.LinkListNode parent,
                               LinkList.LinkListNode child, int k, int num){
        LinkList.LinkListNode lastNode = null;
        if(child == null)
            return parent;
        else if(num == k ) {
            LinkList.LinkListNode temp = child.next;
            child.next = parent;
            parent.next = null;
            return temp;
        }
        else{
            lastNode = reverse(child, child.next, k, num+1);
            child.next = parent;
            if(num == 2){
                parent.next = lastNode;
            }
            else
                parent.next = null;
            return lastNode;
        }

    }

    public static LinkList.LinkListNode traverse(LinkList.LinkListNode node,
                                                 int m){
        int count = 1;
        while( m != count && node.next != null){
            node = node.next;
            count++;
        }
        return node;

    }

    public static void reverseAndTraverse(LinkList l, int k, int m){
        LinkList.LinkListNode temp = l.getHead();
        if(l == null)
            return;
        // set the new head
        LinkList.LinkListNode temp1 = temp;
        int count = 1;
        while (count < k && temp1.next != null){
            temp1 = temp1.next;
            count++;
        }
        l.setHead(temp1);
        while(temp != null){
            temp = reverse(temp, temp.next, k, 2);
            if(temp != null) {
                temp = traverse(temp, m);
                temp1 = temp.next;
                count = 1;
                while(count < k && temp1 != null){
                    count++;
                    temp1 = temp1.next;
                }
                LinkList.LinkListNode temp2 = temp;
                temp = temp.next;
                temp2.next = temp1;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[20];
        for(int i = 0; i<20;i++)
            arr[i] = i+1;
        LinkList ll = new LinkList(arr) ;
        System.out.println("input = " + ll);
        reverseAndTraverse(ll, 3 ,2);
        System.out.println("output = " + ll);
    }
}
