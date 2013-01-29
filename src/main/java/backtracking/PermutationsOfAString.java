package backtracking;

/**
 * A permutation, also called an “arrangement number” or “order,
 * ” is a rearrangement of the elements of an ordered list S into a
 * one-to-one correspondence with S itself. A string of length n has n!
 * permutation.
 Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

 Below are the permutations of string ABC.
 ABC, ACB, BAC, BCA, CAB, CBA
 */
public class PermutationsOfAString {

    private static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * with duplicates
     * @param str
     * @param i
     * @param n
     */
    private static void printPermutations(char str[], int i, int n){
        if(i == n) System.out.println(str);
        else
        {
            for(int  j = i; j < n ; j++) {
                swap(str, i, j);
                printPermutations(str, i+1, n);
                swap(str, i, j); // backtrack
            }
        }
    }

    private static boolean check(char arr[], int i, int j){
        if(i == j) return true;
        for(;i<j;j++)
            if(arr[i] == arr[j]) return false;
        return true;
    }


    private static void printPermutationsWithoutDuplicates(char str[], int i, int n){

        if(i == n) System.out.println(str);
        else
        {
            for(int  j = i; j < n ; j++) {
                if(check(str, i, j)){
                swap(str, j, i);
                printPermutations(str, i+1, n);
                swap(str, i, j); // backtrack
                }
            }
        }

    }

    public static void main(String[] args) {
        String str = "apple";
//        printPermutations(str.toCharArray(), 0 , str.length());
        // for duplicates
        printPermutationsWithoutDuplicates(str.toCharArray(), 0 , str.length());
    }
}
