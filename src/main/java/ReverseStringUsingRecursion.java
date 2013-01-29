/**
 * program to reverse the words of the string?
 i.e., if i give i am a girl the output should be girl a am i
 */
public class ReverseStringUsingRecursion {

    public static void printReverse(String str, int idx){
        if(idx >= str.length())
            return;
        int wordIdx = str.indexOf(" ", idx) ==  -1 ? str.length() :
                str.indexOf(" ", idx);
        String word = str.substring(idx, wordIdx);
        printReverse(str, wordIdx + 1);
        System.out.print(word + " ");
    }

    public static void main(String[] args) {
        String str = "i am a girl";
        System.out.println("input string = " + str);
        printReverse(str, 0);
    }
}
