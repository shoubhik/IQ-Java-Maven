package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Adapted from here - https://www.youtube.com/watch?v=J_odcqzHGqw
 */
public class SubsetOfASet {

  public static void indent(int n) {
    System.out.println();
//    System.out.print("|");
    for (int i = 0; i < n; i++) {
      System.out.print("----");
    }
  }

  public static void subsetHelper(List<String> input, List<String> chosen) {
    indent(chosen.size());
    System.out.printf("('%s', %s)", input, chosen);
    if (input.isEmpty()) {
      System.out.println(chosen);
    }
    else {
      String explore = input.get(0);
      input.remove(0); // choose

      // explore with the element included
      chosen.add(explore);
      subsetHelper(input, chosen);

      // explore without the element excluded
      chosen.remove(chosen.size() - 1);
      subsetHelper(input, chosen);

      // undo choose
      input.add(0, explore);
    }
  }

  public static void main(String[] args) {
    ArrayList<String> input = new ArrayList<>();
    input.add("a");
    input.add("b");
    input.add("c");
    subsetHelper(input, new ArrayList<>());
  }
}
