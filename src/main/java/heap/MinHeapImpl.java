package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap implementation taken from here - https://www.geeksforgeeks.org/binary-heap/
 */
public class MinHeapImpl {

  private List<Integer> heap;
  private int heapSize;
  private final int maxSize;

  public MinHeapImpl(int size) {
    heap = new ArrayList<>(size);
    maxSize = size;
    heapSize = 0;
  }

  private int getParent(int idx) {
    return (idx - 1) /2;
  }

  private int getLeft(int idx) {
    return (2*idx + 1);
  }

  private int getRight(int idx) {
    return 2*idx + 2;
  }

  public void insertElement(int element) {
    heapSize++;
    if(heapSize == maxSize) {
      throw new RuntimeException("Heap is full");
    }
    if(heapSize > heap.size()) {
      heap.add(element);
    } else {
      heap.set(heapSize - 1, element);
    }
    int idx = heapSize - 1;
    int parent = getParent(idx);
    while (idx > 0 && heap.get(parent) > heap.get(idx) ) {
      int temp = heap.get(parent);
      heap.set(parent, heap.get(idx));
      heap.set(idx, temp);
      idx = parent;
      parent = getParent(idx);
    }
  }

  public int extractElement() {
    if(heapSize == 0) {
      throw new RuntimeException("Heap is empty");
    }
    int smallestElement = heap.get(0);
    if(heapSize == 1) {
      heapSize--;
      return smallestElement;
    }
    int idx = 0;
    heap.set(idx, heap.get(heapSize - 1));
    bubbleDown(idx);
    heapSize--;
    return smallestElement;

  }

  private void bubbleDown(int idx) {
    int smallestIdx = idx;
    int leftChild = getLeft(idx);
    int rightChild = getRight(idx);
    if(leftChild < heapSize && heap.get(leftChild) < heap.get(idx)) {
      smallestIdx = leftChild;
    }
    if(rightChild < heapSize && heap.get(smallestIdx) > heap.get(rightChild)) {
      smallestIdx = rightChild;
    }
    if(smallestIdx != idx) {
      int temp = heap.get(smallestIdx);
      heap.set(smallestIdx, heap.get(idx));
      heap.set(idx, temp);
      bubbleDown(smallestIdx);
    }

  }

  public List<Integer> heapSort() {
    List<Integer> output = new ArrayList<>();
    while (heapSize > 0) {
      output.add(extractElement());
    }
    return output;
  }

  public static void main(String[] args) {
    MinHeapImpl impl = new MinHeapImpl(10);
    impl.insertElement(10);
    impl.insertElement(12);
    impl.insertElement(6);
    impl.insertElement(5);
//    System.out.println(impl.extractElement());
    impl.insertElement(4);
    System.out.println(impl.heap);
    System.out.println(impl.heapSort());

    System.out.println();
  }
}
