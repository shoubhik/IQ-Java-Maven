package linklist;

/**
 * Find the merge point of two link lists
 */
public class MergePointOfTwoLinkList {

    public static LinkList.LinkListNode getMergePoint(LinkList l1, LinkList l2){
        LinkList.LinkListNode temp1 = l1.getHead();
        LinkList.LinkListNode temp2 = l2.getHead();
        // first iteration traverse both the lists
        // this is to find the longer of the two link list
        while(temp1.next != null && temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // references to the head of the short and long link list
        LinkList.LinkListNode headShort, headlong, tail, mergePoint = null;
        // both lists are of equal length
        if(temp1.next == null && temp2.next == null){
            headlong = l1.getHead();
            headShort = l2.getHead();
            tail = temp1; // can be temp2 as well
        }
        else if(temp1.next == null){ // list 2 is longer
            headlong = l2.getHead(); // l2 is longer
            headShort = l1.getHead();
            tail = temp2;
        }
        else{ // list 1 is longer
            headlong = l1.getHead();
            headShort = l2.getHead();
            tail = temp1;
        }
        while(tail.next != null){
            headlong = headlong.next;
            tail = tail.next;
        }
        // check for merge
        while((headlong != null && headShort != null)){
            if(headlong == headShort){
                mergePoint = headlong; // or headshort
                break;
            }
            headlong = headlong.next;
            headShort = headShort.next;
        }
        return mergePoint;
    }

    public static void main(String[] args) {
        LinkList mergedPart = new LinkList(new int[]{15,16,17,18});
        LinkList longer = new LinkList(new int[] {1,2,3,4,5});
        System.out.println("for unequal length of list");
        longer.append(mergedPart);
        System.out.println("longer ll = " + longer);
        LinkList shorter = new LinkList(new int[]{6,7,8});
        shorter.append(mergedPart);
        System.out.println("shorter ll = " + shorter);
        System.out.println(
                "merge point = " +
                        String.valueOf(getMergePoint(shorter, longer)));

        System.out.println("for equal length of list");
        LinkList l1 = new LinkList(new int[]{1,2,3}) ;
        l1.append(mergedPart);
        LinkList l2 = new LinkList(new int[]{4,5,6}) ;
        l2.append(mergedPart);
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println(
                "merge point = " +
                        String.valueOf(getMergePoint(l1, l2)));
        System.out.println("for disjoint lists");
        l1 = new LinkList(new int[]{1,2,3}) ;
        l2 = new LinkList(new int[]{4,5,6}) ;
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println(
                "merge point = " +
                        String.valueOf(getMergePoint(l1, l2)));
    }
}
