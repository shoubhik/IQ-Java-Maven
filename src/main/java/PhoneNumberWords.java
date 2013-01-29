import java.util.HashMap;
import java.util.Map;

/**
 * given a seven digit phone number. write all combinations of valid words.
 */
public class PhoneNumberWords {

    private static Map<Integer, char[]>  charKeys = new HashMap<Integer, char[]>();
    static{
        charKeys.put(2, new char[]{'a','b','c'});
        charKeys.put(3, new char[]{'d','e','f'});
        charKeys.put(4, new char[]{'g','h','i'});
        charKeys.put(5, new char[]{'j','k','l'});
        charKeys.put(6, new char[]{'m','n','o'});
        charKeys.put(7, new char[]{'p','r','s'});
        charKeys.put(8, new char[]{'t','u','v'});
        charKeys.put(9, new char[]{'w','x','y'});
    }

    public static char getCharKey(int num, int idx){
        assert(idx >= 0 && idx < 3);
        if(num == 0 ) return '0';
        if(num == 1) return '1';
        return charKeys.get(num)[idx];
    }

    public static void printWords(int num[], int currIdx, char[] result){
        if(currIdx == num.length){
            System.out.println(result);
        }
        else{
            for(int  i = 0 ; i < 3; i++){
                result[currIdx] = getCharKey(num[currIdx], i);
                printWords(num, currIdx + 1, result);
                if(num[currIdx] == 0 || num[currIdx] == 1) return;
            }
        }
    }

    public static void main(String[] args) {
        int phonenum[] = {1,2,3,4,5,6,7};
        printWords(phonenum, 0, new char[phonenum.length]);
    }
}
