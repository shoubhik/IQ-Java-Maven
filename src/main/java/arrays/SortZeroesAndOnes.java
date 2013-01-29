package arrays;

import utils.Utils;

/**
 * array contains only 0 and 1's need to sort the array such that all zeros
 * at first and 1's later part of the array
 */
public class SortZeroesAndOnes {

    public static void sort(int a[]){
        int i = 0, j= a.length-1;
        while(j > i){
            if(a[i] == 0) i++;
            else{
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {0,0,1,1,0,1};
        System.out.println("input array: " + Utils.printArraySingleLine(a));
        sort(a);
        System.out.println("output array: " + Utils.printArraySingleLine(a));
    }
}
