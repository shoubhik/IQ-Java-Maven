package strings;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.MinMaxPriorityQueue;
import java.util.ArrayList;
import java.util.List;
import strings.SuffixTable.Suffix;

/**
 * Taken from -https://www.youtube.com/watch?v=53VIWj8ksyI
 */
public class LongestCommonPrefixArray {

  public static class  LcpValue {
    private final int lcpValue;
    private final String suffix;

    public LcpValue(int lcpValue, String suffix) {
      this.lcpValue = lcpValue;
      this.suffix = suffix;
    }

    public int getLcpValue() {
      return lcpValue;
    }

    public String getSuffix() {
      return suffix;
    }

    public String toString() {
      return String.format("(%d, %s)", lcpValue, suffix);
    }
  }

  public static List<LcpValue> constructFrom(MinMaxPriorityQueue<Suffix> suffixes) {
    System.out.println(suffixes);
    int count = 0;
    List<LcpValue> output = new ArrayList<>();
    String previousEntry = null;
    while (!suffixes.isEmpty()) {
      String currentEntry = suffixes.pollFirst().getSuffix();
      System.out.println(currentEntry);
      if(count == 0) {
        output.add(new LcpValue(0, currentEntry));
      }
      else {
        int i = 0;
        while (i < currentEntry.length() && i < previousEntry.length() && currentEntry.charAt(i) == previousEntry.charAt(i)  ) i++;
        output.add(new LcpValue(i, currentEntry));
      }
      previousEntry = currentEntry;
      count++;
    }
    return output;
  }

}
