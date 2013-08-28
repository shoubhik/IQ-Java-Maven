package arrays;

import java.security.PublicKey;
import java.util.Deque;
import java.util.LinkedList;

/**
 * An array of size N is given. Array is sub divided into sub array of size K
 * . Find maximum value of each sub array.

 My ans-
 While traversing the array keep on adding values to max heap of size K and
 keeping a virtual window of size K on array.
 When element leaves the window then remove the leaving element from heap too
 and reheapify the heap. And max element of that window will be again on top
 in heap.

 Any better approach?
 */
public class MaximumWindowProblem {

    private static class Data{
        public int data;
        public int index;

        public Data(int data, int index){
            this.data = data;
            this.index = index;
        }
    }

    public static void maximumWindow(int arr[], int k){
        Deque<Data> dque = new LinkedList<Data>();
        int i ;
        for(i = 0; i< k;i++){
            while(!dque.isEmpty() && arr[i] >= dque.getLast().data)
                dque.removeLast();
            dque.addLast(new Data(arr[i], i));

        }
        for(; i<arr.length;i++){
            System.out.println(arr[dque.getFirst().index]);
            while (!dque.isEmpty() && dque.getFirst().index <= i-k)
                dque.removeFirst();
            while(!dque.isEmpty() && arr[i] >= dque.getLast().data)
                dque.removeLast();
            dque.addLast(new Data(arr[i], i));
        }
        System.out.println(arr[dque.getFirst().index]);
    }

    public static void main(String[] args) {
        int arr[] = {5,6,1,2,3,4,5,6,7,8,9};
        int k = 3;
        maximumWindow(arr, k);
    }
}
