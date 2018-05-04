package backtracking;

public class WordBreakAlgorithm {

  /* A utility function to check whether a word
  is present in dictionary or not.  An array of
  strings is used for dictionary.  Using array
  of strings for dictionary is definitely not
  a good idea. We have used for simplicity of
  the program*/
  boolean dictionaryContains(String word)
  {
    String dictionary[] = {"mobile","samsung","sam","sung",
        "man","mango", "icecream","and",
        "go","i","love","ice","cream"};
    for (int i = 0; i < dictionary.length; i++)
      if (dictionary[i].equals(word))
        return true;
    return false;
  }

  // result store the current prefix with spaces
// between words
  void wordBreakUtil(String str, String result)
  {
    System.out.printf("** %s : %s ** \n", str, result);
    // Process all prefixes one by one
    for (int i=1; i<=str.length(); i++)
    {
      //extract substring from 0 to i in prefix
      String prefix = str.substring(0, i);

      // if dictionary conatins this prefix, then
      // we check for remaining string. Otherwise
      // we ignore this prefix (there is no else for
      // this if) and try next
      if (dictionaryContains(prefix))
      {
        // if no more elements are there, print it
        if (i == str.length())
        {
          // add this element to previous prefix
          result += prefix;
          System.out.println(result);
          return;
        }
//        System.out.printf("%d, %d, %s, %s\n", i, n, str, result);
        wordBreakUtil(str.substring(i, str.length()),
            result + prefix + " ");
      }
    }      //end for
  }//end function

  // Prints all possible word breaks of given string
  void wordBreak(String str)
  {
    // last argument is prefix
    wordBreakUtil(str, "");
  }

  public static void main(String[] args) {
    WordBreakAlgorithm wordBreakAlgorithm = new WordBreakAlgorithm();
    wordBreakAlgorithm.wordBreak("iloveicecreamandmango");
  }
}
