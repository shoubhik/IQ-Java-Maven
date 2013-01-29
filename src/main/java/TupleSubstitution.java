import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a Tuple for eg. (a, b, c)..
 Output : (*, *, *), (*, *, c), (*, b, *), (*, b, c), (a, *, *), (a, *, c),
 (a, b, *), (a, b, c)


 */
public class TupleSubstitution {

    public static void tupleSubstitute(List<Character> tuple, char arr[], int idx) {
        if(idx == tuple.size()){
            System.out.print("(");
            for(char ch: arr)
                System.out.print(ch + ",");
            System.out.println(")");
        }
        else{
            arr[idx] = '*';
            tupleSubstitute(tuple, arr, idx+1);
            arr[idx] = tuple.get(idx);
            tupleSubstitute(tuple, arr, idx+1);
        }
    }

    public static void main(String[] args) {
        List<Character> tuple = new ArrayList<Character>();
        tuple.add('a');
        tuple.add('b');
        tuple.add('c');
        char arr[] = new char[tuple.size()];
        tupleSubstitute(tuple, arr, 0);
    }
}
