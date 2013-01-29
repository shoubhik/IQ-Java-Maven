package backtracking;

import utils.MutableInteger;

/**
 * User: shoubhik Date: 29/12/12 Time: 2:40 PM
 */
public class UpperAndLowerCaseCombination extends GeneralBackTrackingAlgo {

    private static int UPPER = 1;
    private static int LOWER = 0;
    @Override
    protected void construct_candidates(int[] a, int k, Data input, int[] c,
                                        MutableInteger ncandidates) {
        c[0] = UPPER;
        c[1] = LOWER;
        ncandidates.setVal(2);

    }

    @Override
    protected void process_solution(int[] a, int k, Data input) {
        char arr[] = (char [])input.getData();
        for(int  i = 1; i <= arr.length; i++){
            if(a[i] == UPPER) System.out.print(Character.toUpperCase(arr[i-1]));
            else System.out.print(Character.toLowerCase(arr[i - 1]));
        }
        System.out.println();
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Data input) {
        return k == ((char [])input.getData()).length;
    }

    public void print_combination(char []str){
        int a[] = new int[str.length + 1];
        backtrack(a, 0, getData(str));
    }

    public static void main(String[] args) {
        char str[] = "abc".toCharArray();
        UpperAndLowerCaseCombination combination = new UpperAndLowerCaseCombination();
        combination.print_combination(str);
    }
}
