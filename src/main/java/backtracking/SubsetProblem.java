package backtracking;

import utils.MutableInteger;

/**
 * print all subsets of a given set
 */
public class SubsetProblem extends GeneralBackTrackingAlgo{

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
        System.out.print("{");
        for(int  i = 1 ; i <= k;i++) {
            if(a[i] == TRUE) System.out.print(" " + i);
        }
        System.out.println("}");
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Data input) {
        return k == (Integer)input.getData();
    }

    public void generate_subset(int n){
        int a[] = new int[NMAX];
        backtrack(a,0, getData(new Integer(n)));
    }

    public static void main(String[] args) {
        SubsetProblem subsetProblem = new SubsetProblem();
        subsetProblem.generate_subset(3);

    }


}
