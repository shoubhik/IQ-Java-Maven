package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromStreamOfIntegers {

  PriorityQueue<Integer> leftHeap;
  PriorityQueue<Integer> rightHeap;

  public MedianFromStreamOfIntegers() {
    this.leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    this.rightHeap = new PriorityQueue<>();
  }

  public void putNumber(int num) {
    leftHeap.offer(num);
    rightHeap.offer(leftHeap.poll());
    if(leftHeap.size() < rightHeap.size()) {
      leftHeap.offer(rightHeap.poll());
    }

  }

  public double getMedian() {
    if(leftHeap.size() == rightHeap.size()) {
      return ((double) (leftHeap.peek() + rightHeap.peek() ) )/2;
    }
    return leftHeap.peek();
  }

  public static void main(String[] args) {
    MedianFromStreamOfIntegers medianFromStreamOfIntegers = new MedianFromStreamOfIntegers();
    medianFromStreamOfIntegers.putNumber(1);
    medianFromStreamOfIntegers.putNumber(2);
//    medianFromStreamOfIntegers.putNumber(3);
    System.out.println(medianFromStreamOfIntegers.getMedian());
  }
}
