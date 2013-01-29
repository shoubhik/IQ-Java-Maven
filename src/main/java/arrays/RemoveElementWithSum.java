package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList A, B, C are sorted int arraylists.

 When A[i] + B[j] = C[k], you need to remove C[k] from ArrayList C.

 Please implement code with O(N^2). Note that you are not allowed to use
 additional data structures such as arrays, hash tables, etc.
 */
public class RemoveElementWithSum {

    private static int getIndexOfElementLessThanEqualTo(List<Integer> list, int element){
        int i = 0;
        while((i < list.size() && list.get(i) <= element ))
           i++;
        return i > list.size() ? -1 : i-1;
    }

    public static void removeElements(List<Integer> a, List<Integer> b,
                                      List<Integer> c){
        for(Iterator<Integer> it = c.iterator();it.hasNext();){
            int element = it.next();
            int alim = getIndexOfElementLessThanEqualTo(a, element);
            int blim = getIndexOfElementLessThanEqualTo(b, element);
            int left = 0, right = blim;
            if( alim>=0 && blim >= 0){
                while(left <= alim && blim >= 0){
                    if(a.get(left) + b.get(right) == element){
                        it.remove();
                        break;
                    }
                    else if(a.get(left) + b.get(right) < element)
                        left++;
                    else
                        right--;

                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(6);

        List<Integer> b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(5);
        b.add(8);

        List<Integer> c = new ArrayList<Integer>();
        c.add(2);
        c.add(3);
        c.add(5);
        c.add(8);
        c.add(10);
        System.out.println("list A" + a);
        System.out.println("list B" + b);
        System.out.println("original list C" + c);
        removeElements(a,b,c);
        System.out.println("list C after elements removed" + c);
        
        
    }
}
