package backtracking;

import utils.MutableInteger;

/**
 * User: shoubhik Date: 29/12/12 Time: 7:00 PM
 */
public class PermutationOfAString extends GeneralBackTrackingAlgo{
    @Override
    protected void construct_candidates(int[] a, int k, Data input, int[] c,
                                        MutableInteger ncandidates) {
        char str[] = (char [])input.getData();
        boolean in_perm[] = new boolean[str.length + 1];
        for(int  i = 1; i< k;i++) in_perm[a[i]] = true;
        ncandidates.setVal(0);
        for(int i = 1; i<= str.length; i++) {
            if(!in_perm[i]){
                c[ncandidates.getVal()] = i;
                ncandidates.increment();
            }
        }
    }

    @Override
    protected void process_solution(int[] a, int k, Data input) {
        char str[] = (char[])input.getData();
        for(int  i =1; i<= str.length; i++)
            System.out.print(str[a[i] - 1 ]);
        System.out.println();
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Data input) {
        return k == ((char [])input.getData()).length;
    }

    public void print_permutation(char str[]){
        int a[] = new int[str.length + 1];
        backtrack(a, 0, getData(str));
    }

    public static void main(String[] args) {
        PermutationOfAString permutations = new PermutationOfAString();
        char str[] = "abc".toCharArray();
        permutations.print_permutation(str);
    }
}
