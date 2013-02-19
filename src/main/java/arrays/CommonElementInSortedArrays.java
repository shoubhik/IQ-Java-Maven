package arrays;

import utils.Utils;

/**
 * How to get common elements from two sorted arrays and you should not use
 * any additional buffers.

 ex:- a[] = {1,1,3,4,6,9}
 b[] = {1,1,3,4,5,9}
 output[] = {1,1,3,4,9}


 */
public class CommonElementInSortedArrays {

    public static void printCommonElements(int a[], int b[]){
        int aIdx = 0, bIdx = 0;
        int count = 0;
        boolean isMatch = false;
        while(aIdx < a.length && bIdx < b.length){
            count  = 0;
            isMatch = false;
            while(aIdx < a.length-1 && a[aIdx + 1] == a[aIdx])
                aIdx++;
            if(b[bIdx] == a[aIdx]){
                isMatch = true;
                count++;
            }
            while(bIdx <b.length-1 && b[bIdx+1] == b[bIdx]){
                bIdx++;
                if(isMatch)
                    count++;
            }
            for(int  i = 0 ; i < count; i++)
                System.out.print(b[bIdx] + " ");
            aIdx++; bIdx++;
        }
    }


    public static void main(String[] args) {
        int a[] = {1,3,4,6,9};
        int b[] = {1,1,3,4,5};
        printCommonElements(a,b);
    }
}
