package arrays;

import java.util.Arrays;

/**
 *Given two arrays of integers, unsorted. Write a program to find the common
 * elements within the two.
 */
public class FindCommonElements {

    public static void printCommonElements(int a[], int b[]){
        Arrays.sort(a); // sort A
        Arrays.sort(b); // sort B
        int i=0,j=0;
        // print common elements in O(n)
        while(i<a.length && j<b.length){
            if(a[i] == b[j]) System.out.println(a[i]);
            if(a[i] < b[j]) i++;
            else j++;

        }
    }

    public static void main(String[] args) {
        int a[] = {1,3,5,7};
        int b[] = {2,4,5,7,8};
        printCommonElements(a,b);
    }
}
