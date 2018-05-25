package backtracking;

/**
 * Solution taken from here - https://www.youtube.com/watch?v=78t_yHuGg-0
 */

public class StringPermute {

  public static void indent(int n) {
    System.out.println();
    for (int i = 0; i < n; i++) {
      System.out.print("    ");
    }
  }

  public static void permuteHelper(StringBuilder s, StringBuilder chosen) {
    indent(chosen.length());
    System.out.printf("('%s', '%s')",s , chosen);
    // base case
    if(s.toString().isEmpty()) {
      System.out.println(chosen);
    } else {
      // choose / explore/ unchoose
      for (int i = 0; i < s.length(); i++) { // choose
        char ch = s.charAt(i); // choose
        s = s.deleteCharAt(i);
        chosen.append(ch);

        // explore
        permuteHelper(s, chosen);

        // un choose
        s = s.insert(i, ch);

        chosen = chosen.deleteCharAt(chosen.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    String test = "abc";
    permuteHelper(new StringBuilder(test), new StringBuilder(""));
  }
}
