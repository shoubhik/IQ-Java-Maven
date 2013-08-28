package arrays;

/**
 * User: shoubhik Date: 31/12/12 Time: 12:15 AM
 */
public class RemoveDuplicateCharactersInString {

    public static void removeDuplicates(char str[]){
        if(str.length == 0) return;
        int unique = 1;
        for(int i =1;i<str.length;i++){
            boolean isMatch = false;
            int count = 0;
            for(int j = 0;j< unique;j++){
                if(str[i] == str[j]){
//                    isMatch = true;
                    break;
                }
                count++;
            }
            if(count == unique){
                str[unique] = str[i];
                unique++;

            }

        }
        if(unique < str.length)
            str[unique] = '\0';
    }

    public static void main(String[] args) {
        char str[] = "abcbbede".toCharArray();
        removeDuplicates(str);
        int  i =0;
        while(!(str[i] == '\0') && i < str.length){
            System.out.print(str[i]);
            i++;
        }

    }
}
