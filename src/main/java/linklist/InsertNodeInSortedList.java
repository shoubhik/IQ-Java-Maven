package linklist;

/**
 * Insert node in a sorted singly linked list
 */
public class InsertNodeInSortedList {

    public static void insert(LinkList sortedList, int valueToInsert){
        LinkList.LinkListNode temp = sortedList.getHead();
        LinkList.LinkListNode node = LinkList.getNewNode(valueToInsert);;
        if(valueToInsert < temp.data){
            node.next = temp;
            sortedList.setHead(node);
            return;
        }
        while(temp.next != null && temp.next.data <= valueToInsert)
            temp = temp.next;
        node.next = temp.next;
        temp.next = node;
    }

    public static void main(String[] args) {
        LinkList sortedList = new LinkList(new int[] {1,3,5,7,9});
        System.out.println("before = " + sortedList);
        int valueToInsert = 4;
        System.out.println("value to insert = " + valueToInsert);
        insert(sortedList, valueToInsert);
        System.out.println("after insertion  =" + sortedList);
        System.out.println();
        System.out.println("before = " + sortedList);
        valueToInsert = 10;
        System.out.println("value to insert = " + valueToInsert);
        insert(sortedList, valueToInsert);
        System.out.println("after insertion  =" + sortedList);
        System.out.println();
        System.out.println("before = " + sortedList);
        valueToInsert = 0;
        System.out.println("value to insert = " + valueToInsert);
        insert(sortedList, valueToInsert);
        System.out.println("after insertion  =" + sortedList);
    }
}
