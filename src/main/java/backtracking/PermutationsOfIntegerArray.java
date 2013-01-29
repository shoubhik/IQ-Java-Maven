package backtracking;

import binarytree.BinaryTree;
import utils.Utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of intergers. Write a program to print all the permutations
 * of the numbers in the array. The output should be sorted in a
 * non-increasing order. For example for the array { 12, 4, 66, 8, 9},
 * the output should be:

 9866412

 9866124

 9846612

 ....

 ....

 1246689


 */
public class PermutationsOfIntegerArray {

    private void swap(int arr[], int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permute(int arr[], int idx, SortedSet<String> set){
        if(idx == arr.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<arr.length;i++)
               sb.append(arr[i]);
            set.add(sb.toString());
        }
        else{
            for(int j=idx;j<arr.length;j++){
                swap(arr, idx, j);
                permute(arr, idx+1, set);
                swap(arr,idx,j); // back track

            }
        }
    }

    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                int int1 = Integer.parseInt(s);
                int int2 = Integer.parseInt(s2);
                if(int1 == int2) return 0;
                else if(int1 > int2) return 1;
                else return -1;
            }
        });
        int arr[] = { 12, 4, 66, 8, 9};
        PermutationsOfIntegerArray permutationsOfIntegerArray =
                new PermutationsOfIntegerArray();
        permutationsOfIntegerArray.permute(arr,0,set);
        System.out.println("original array:" + Utils.printArraySingleLine(arr));
        for(Iterator<String> it = set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
