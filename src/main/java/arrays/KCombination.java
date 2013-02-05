package arrays;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array and a number K find all the k combinations of the array
 */
public class KCombination {

    public static  void printAllKCombinations(int offset, int k, int arr[],
                                              List<Integer> list, int m){
        if(k == 0) {
            System.out.println(list);
            return;
        }
        for(int i = offset; i < arr.length; i++){
            list.add(arr[i]);
            printAllKCombinations(i+1, k-1, arr, list, m);
            list.remove(list.size() -1);
        }
    }

    public static  void printAllKCombinationsWithArray(int offset, int k, int arr[],
                                              int out[], int m){
        if(k == 0) {
            System.out.println(Utils.printArraySingleLine(out));
            return;
        }
        for(int i = offset; i < arr.length; i++){
            out[m-k] = arr[i];
            printAllKCombinationsWithArray(i+1, k-1, arr, out, m);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int  k = 4;
        List<Integer> list = new ArrayList<Integer>();
//        printAllKCombinations(0, k, arr, list, k);
        printAllKCombinationsWithArray(0, k, arr, new int[k], k );
    }
}
