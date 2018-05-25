package strings;

import com.google.common.collect.MinMaxPriorityQueue;
import strings.SuffixTable.Suffix;

/**
 *
 Given a string, return the longest repeated substring.

 [edit][hide] Examples
 "banana" -> "ana"
 "tomato" -> "to"
 "aaaaaa" -> "aaaaa"
 "Ask not what your country can do for you, ask what you can do for your country." -> " can do for you"
 [edit][hide] Clarifications
 Is this word based? No, only think in terms of characters
 Does case matter? Yes, but what if it didn't?
 Can substrings overlap? Yes, refer to banana
 */
public class LongestRepeatedSubstring {

  public static void main(String[] args) {
//    String toTest = "ABRACADABRA";
    String toTest = "banana";
    SuffixTable suffixTable = new SuffixTable();
    for(int i = toTest.length() - 1; i >= 0; i--) {
      suffixTable.addSuffix(new Suffix(toTest.substring(i), i));
    }
    System.out.println(LongestCommonPrefixArray.constructFrom(suffixTable.getSuffixTable()));
  }
}
