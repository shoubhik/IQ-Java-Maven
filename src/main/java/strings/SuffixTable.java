package strings;

import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue.Builder;
import java.util.Comparator;

/**
 * Taken from - https://www.youtube.com/watch?v=zqKlL3ZpTqs
 */
public class SuffixTable {

  public static class Suffix {
    private final String suffix;
    private final int suffixStartIdx;

    public Suffix(String suffix, int suffixStartIdx) {
      this.suffix = suffix;
      this.suffixStartIdx = suffixStartIdx;
    }

    public String getSuffix() {
      return suffix;
    }

    public int getSuffixStartIdx() {
      return suffixStartIdx;
    }

    public String toString() {
      return String.format("(%d, %s )", suffixStartIdx, suffix);
    }

  }

  private final MinMaxPriorityQueue<Suffix> suffixTable = MinMaxPriorityQueue.orderedBy(
      Comparator.comparing(Suffix::getSuffix))
      .create();

  public SuffixTable addSuffix(Suffix suffix) {
    suffixTable.offer(suffix);
    return this;
  }

  public MinMaxPriorityQueue<Suffix> getSuffixTable() {
    return suffixTable;
  }
}
