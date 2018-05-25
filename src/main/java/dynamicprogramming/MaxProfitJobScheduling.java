package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that
 * jobs in subset do not overlap.
 */
public class MaxProfitJobScheduling {

  public static class Job {
    Integer start;
    Integer end;
    int profit;

    public Job(Integer start, Integer end, int profit) {
      this.start = start;
      this.end = end;
      this.profit = profit;
    }

    public Integer getEnd() {
      return end;
    }

    public boolean intersects(Job anotherTask) {
      return !(isFullyOnTheLeftInNumberLine(anotherTask) || isFullyOntheRightInNumberLine(anotherTask));

    }

    private boolean isFullyOnTheLeftInNumberLine(Job anotherTask) {
      return anotherTask.start <= this.start && anotherTask.end <= this.start;
    }

    private boolean isFullyOntheRightInNumberLine(Job anotherJob) {
      return anotherJob.start >= this.end && anotherJob.end >= this.end;
    }


    @Override
    public String toString() {
      return "Job{" +
          "start=" + start +
          ", end=" + end +
          ", profit=" + profit +
          '}';
    }
  }

  public static void printMaxProfitScheduling(Job[] arr) {
    Arrays.sort(arr, Comparator.comparing(Job::getEnd));
    int table[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      table[i] = arr[i].profit;
    }
    for (int i = 1; i < arr.length; i++) {
      //
      Job curr = arr[i];
      for (int j = 0; j < i; j++) {
        Job task_j = arr[j];
        if(!task_j.intersects(curr)) {
          table[i] = Math.max(table[j] + curr.profit, table[i]);
        }
      }
    }
    System.out.println(Arrays.toString(table));
  }

  public static void main(String[] args) {
    //
    Job[] arr = new Job[] {
    new Job(1,3,5),
    new Job(2,5,6),
    new Job(4,6,5),
    new Job(6,7,4),
    new Job(5,8,11),
    new Job(7,9,2),
    };
    printMaxProfitScheduling(arr);
    

  }
}
