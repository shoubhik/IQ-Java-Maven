package backtracking;

import utils.MutableInteger;

import java.util.HashSet;
import java.util.Set;

/**
 * User: shoubhik Date: 29/12/12 Time: 2:03 PM
 */
public class SubsetOfAGivenSet extends GeneralBackTrackingAlgo{

    private static int TRUE = 1;
    private static int FALSE = 0;

    private static int NMAX = 100;

    @Override
    protected void construct_candidates(int[] a, int k, Data input, int[] c,
                                        MutableInteger ncandidates) {
        c[0] = TRUE;
        c[1] = FALSE;
        ncandidates.setVal(2);
    }

    @Override
    protected void process_solution(int[] a, int k, Data input) {
        Object set[] = ((Set<?>)input.getData()).toArray();
        System.out.print("{");
        for(int i = 1; i <= k; i++){
            if(a[i] == TRUE) System.out.print(" " + set[i-1]);
        }
        System.out.println("}");
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Data input) {
        return k == ((Set<?>)(input.getData())).size();
    }

    public void print_subset(Set<?> set){
        Data data = getData(set);
        int a[] = new int[NMAX];
        backtrack(a, 0, data);
    }

    public static void main(String[] args) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('b');
        set.add('c');
        SubsetOfAGivenSet subset = new SubsetOfAGivenSet();
        subset.print_subset(set);
    }
}
