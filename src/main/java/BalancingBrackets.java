import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You receive a string with the following characters: '{' '(' '[' ']' ')' '}'
 the string can be any size, any number of each character.
 You have to decide if the string is balanced, for examplo
 {()[]} - correct
 (({)}) - incorrect
 {()) - incorrect
 */
public class BalancingBrackets {

    private static Map<Character, Integer> MAP =
            new HashMap<Character, Integer>();
    static{
        MAP.put('{', -1);
        MAP.put('(', -2);
        MAP.put('[', -3);

        MAP.put('}', 1);
        MAP.put(')', 2);
        MAP.put(']', 3);
    }

    public static boolean isCorrect(String expression){
        Stack<Integer> stack = new Stack<Integer>();
        for(char ch : expression.toCharArray()) {
            int val = MAP.get(ch);
            if(val < 0)
                stack.push(val);
            else
            {
                if(stack.isEmpty() || val + stack.pop() != 0)
                    return false;
           }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{()[]}";
        System.out.printf("input = %s , isvalid = %b\n", str, isCorrect(str));

        str = "(({)})";
        System.out.printf("input = %s , isvalid = %b\n", str, isCorrect(str));

        str = "{())";
        System.out.printf("input = %s , isvalid = %b\n", str, isCorrect(str));

        str = "][";
        System.out.printf("input = %s , isvalid = %b\n", str, isCorrect(str));
    }
}
