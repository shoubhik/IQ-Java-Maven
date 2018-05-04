package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap data structure
 */
public class  Heap<T extends Comparable<T>> {

    public static enum HEAP_TYPE{
        MIN_HEAP, MAX_HEAP
    }

    private List<T> heap;
    private HEAP_TYPE heap_type;

    public Heap( HEAP_TYPE heap_type){
        this.heap_type = heap_type;
        heap = new ArrayList<T>();
    }

    private int getParent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }


    private void exchange(int idx_i, int idx_k){
        T temp = heap.get(idx_i);
        heap.set(idx_i, heap.get(idx_k));
        heap.set(idx_k, temp);
    }

    private void maxHeapify(int idx_i){
        int l_idx = left(idx_i);
        int r_idx = right(idx_i);
        int largest_idx;
        if(l_idx < heap.size() && heap.get(l_idx).compareTo( heap.get(idx_i)) > 0)
            largest_idx  = l_idx;
        else largest_idx  = idx_i;
        if(r_idx < heap.size() && heap.get(r_idx).compareTo(heap.get(largest_idx)) > 0)
            largest_idx = r_idx;
        if(largest_idx != idx_i)
        {
            exchange(idx_i,largest_idx);
            maxHeapify(largest_idx);
        }
    }

    private void minHeapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest;
        if(l < heap.size() && heap.get(l).compareTo( heap.get(i)) < 0)
            smallest  = l;
        else smallest  = i;
        if(r < heap.size() && heap.get(r).compareTo(heap.get(smallest)) < 0)
            smallest = r;
        if(smallest != i)
        {
            exchange(i,smallest);
            maxHeapify(smallest);
        }
    }

    private void addMaxHeap(T ele){
        heap.add(ele);
        int p = getParent(heap.size() - 1);
        if(p >= 0)
            maxHeapify(p);
    }

    private void addMinHeap(T ele){
        heap.add(ele);
        int p = getParent(heap.size() - 1);
        if(p >= 0)
            minHeapify(p);
    }

    private T extractMax(){
        if(heap.size() == 0)
            throw new RuntimeException("heap is empty");
        T ele = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        maxHeapify(0);
        return ele;
    }

    private T extractMin(){
        if(heap.size() == 0)
            throw new RuntimeException("heap is empty");
        T ele = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        minHeapify(0);
        return ele;
    }

    public String toString(){
        return heap.toString();
    }

    public void add(T ele){
        if(this.heap_type == HEAP_TYPE.MAX_HEAP)
            addMaxHeap(ele);
        else if(this.heap_type == HEAP_TYPE.MIN_HEAP)
            addMinHeap(ele);
    }

    public T extract(){
        if(this.heap_type == HEAP_TYPE.MAX_HEAP)
            return extractMax();
        else if(this.heap_type == HEAP_TYPE.MIN_HEAP)
            return extractMin();
        throw new IllegalStateException("heap type not defined");
    }

    public int size(){
        return this.heap.size();
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(HEAP_TYPE.MAX_HEAP);
        heap.add(1);
        heap.add(15);
        heap.add(20);
        heap.add(7);
        heap.add(9);
        heap.add(12);
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
        heap.extract();
        System.out.println(heap);
    }

}