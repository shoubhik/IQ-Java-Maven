package backtracking;

import utils.MutableInteger;

/**
 * User: shoubhik Date: 29/12/12 Time: 7:40 PM
 */
public class PermutationOfAStringWithoutDuplicates extends GeneralBackTrackingAlgo{

    private boolean isDuplicate(char str[], int a[],char ch, int k, int idx){
        for(int i =1;i<=k-1;i++){
            if(str[a[i]-1] == ch && a[i] > idx)
                return true;
        }
        return false;
    }

    @Override
    protected void construct_candidates(int[] a, int k, Data input, int[] c,
                                        MutableInteger ncandidates) {
        char str[] = (char [])input.getData();
        boolean in_perm[] = new boolean[str.length + 1];
        for(int  i = 1; i< k;i++) in_perm[a[i]] = true;
        ncandidates.setVal(0);
        for(int i = 1; i<= str.length; i++) {
            if(!in_perm[i]){
                if(!isDuplicate(str,a,str[i-1], k, i)){
                    c[ncandidates.getVal()] = i;
                    ncandidates.increment();
                }
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
        PermutationOfAStringWithoutDuplicates permutations =
                new PermutationOfAStringWithoutDuplicates();
        char str[] = "aaaa".toCharArray();
        permutations.print_permutation(str);
    }
}
