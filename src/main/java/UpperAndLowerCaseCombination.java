/**
 * print all the upper and lower case combinations of a word
 * eg: abc
 *   abc
     abC
     aBc
     aBC
     Abc
     AbC
     ABc
     ABC
 *
 */
public class UpperAndLowerCaseCombination {

    private static void combination(String word, char[] arr, int idx){
        if(idx == word.length()) {
            System.out.println(arr);
        }
        else{
            char ch = word.charAt(idx);
            arr[idx] = Character.toLowerCase(ch);
            combination(word, arr, idx + 1);
            arr[idx] = Character.toUpperCase(ch);
            combination(word, arr, idx+1);
       }
    }

    public static void main(String[] args) {
        String word = "bankai";
        combination(word, new char[word.length()], 0);
    }
}
