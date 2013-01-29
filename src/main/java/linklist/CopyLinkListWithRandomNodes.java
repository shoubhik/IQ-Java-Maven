package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 *
 You have a link list with the following structure:
 struct Node{ Node*next; Node*other; }

 next pointer points to next node, but "other" pointer points to any node in
 the list, it can be itself or null.

 you receive the header of a list with this structure.

 you have to copy it(allocate new memory) , you cannot modify the structure,
 you can not modify the list you are given.
 */
public class CopyLinkListWithRandomNodes {

    public static LinkList makeCopy(LinkList listWithRandomLinks) {
        LinkList.LinkListNode temp = listWithRandomLinks.getHead();
        Map<LinkList.LinkListNode, LinkList.LinkListNode> map = new HashMap
                <LinkList.LinkListNode, LinkList.LinkListNode>();
        LinkList.LinkListNode prev = null;
        LinkList copyList = new LinkList();
        copyList.setHasRandomNode(true);
        while(temp != null){
            LinkList.LinkListNode currNode = null , randomNode = null;
            if(!map.containsKey(temp)){
                currNode = LinkList.getNewNode(temp.data);
                map.put(temp, currNode);

            }
            if(temp.random != null && !map.containsKey(temp.random)){
                randomNode = LinkList.getNewNode(temp.random.data);
                map.put(temp.random, randomNode);
            }
            currNode = map.get(temp);
            randomNode =map.get(temp.random);
            currNode.random = randomNode;
            if(prev == null)
                copyList.setHead(currNode);
            else
                prev.next = currNode;
            prev = currNode;
            temp = temp.next;

        }
        return copyList;
    }

    public static void main(String[] args) {
        LinkList ll = LinkList.getListWithRandomLinks(new int[]{1,2,3,4},
                                                      new int[]{1,-1,0,1});
        System.out.println("input = " + ll);
        LinkList copy = makeCopy(ll);

        System.out.println("copy = " + copy);

        System.out.println("are equal ? "  +
                                   String.valueOf(ll.toString()).equals(
                                           copy.toString()));
    }
}
