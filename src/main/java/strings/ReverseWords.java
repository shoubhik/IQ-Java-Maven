package strings;

/**
 * Example: Let the input string be “i like this program very much”. The
 * function should change the string to “much very program this like i”

 Algorithm:

 1) Reverse the individual words, we get the below string.
 "i ekil siht margorp yrev hcum"
 2) Reverse the whole string from start to end and you get the desired output.
 "much very program this like i"
 */
public class ReverseWords{

    public static void reverse(char arr[], int fromIdx, int toIdx){
        while(fromIdx < toIdx) {
            char temp = arr[fromIdx];
            arr[fromIdx] = arr[toIdx];
            arr[toIdx] = temp;
            fromIdx++;
            toIdx--;
        }


    }

    public static void reverseWords(char arr[]){
        int startIdx = -1;
        int counter = 0;
        while(counter < arr.length){
            if(startIdx == -1 && arr[counter] != ' ')
                startIdx = counter;
            else if(startIdx != -1 && (counter + 1 == arr.length ||
                    arr[counter+1] == ' ' )) {
                reverse(arr,startIdx, counter);
                startIdx = -1;
            }
            counter++;
        }
        reverse(arr,0, arr.length-1);
    }

    public static void main(String[] args) {
        String str = "  i like this program very much";
        System.out.println("input = " + str);
        char arr [] = str.toCharArray();
        reverseWords(arr);
        System.out.println("output = " + new String(arr));
    }
}
