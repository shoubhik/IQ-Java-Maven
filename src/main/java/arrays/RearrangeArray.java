package arrays;

import utils.Utils;

import static arrays.RightRotateArray.rightRotateSubArray;

/**
 * Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn.
 * Implement an algorithm
 * to change this array to a1, b1, a2, b2, ..., an, bn.
 */
public class RearrangeArray {

    /**
     * this has O(n^2) complexity
     * @param arr
     */
    public static void rotationSolution(int arr[]){
        int n = arr.length/2;
        for(int i = 0, j = 1; i < n;i++,j+=2 ){
            rightRotateSubArray(arr,j,n+i);
        }
    }

    /**
     * O(N log N) Solution
     Let’s solve it by using the divide and conquer technique.
     Rearrange(A,p,q)
     1.	 if p is not equal to q do the following
     2.	 r ← (p+q)/2
     3.	 Exchange A[(p+r)/2..r] ←→ A[(p+q)/2 +1 ..(r+q)/2].
     4.	 Rearrange(A,p,r)
     5.	 Rearrange(A,r+1,q)
     6.	 return
     T(n) = 2T(n/2) + O(n) hence . T(n) < O(nlogn)

     * @param arr
     * @param p
     * @param q
     */

    public static void divideAndConquer(int arr[], int p, int q){
        if(q-p+1 == 2) return;
        boolean isOddElements =  ((q-p+1) /2)%2 == 1; // number of elements in the division are odd or even.
        int r = (p+q)/2;
        int low ;
        if(isOddElements)
         low = (r-p == 1)? r : (p+r)/2;
        else
          low = (r+p+1)/2;
        int j = 1;
        for(int i=low;i<=r;i++){
            int temp = arr[i];
            arr[i] = arr[r+j];
            arr[r+j] = temp;
            j++;
        }
        int idx = isOddElements ? r-1 : r;

        if(idx > p)
            divideAndConquer(arr,p,idx);
        idx = isOddElements? r+2 :r+1;
        if(idx < q)
            divideAndConquer(arr, idx,q);
    }

    public static void main(String[] args) {
        int arr[] = generateArray(5);
        System.out.println("original array:"+ Utils.printArraySingleLine(arr));
        System.out.println("using the rotation solution");
        rotationSolution(arr);
        System.out.println("output:" + Utils.printArraySingleLine(arr));

        int arr1[] = generateArray(7);
        System.out.println("original array:"+ Utils.printArraySingleLine(arr1));
        System.out.println("using the divide-and-conquer solution");
        divideAndConquer(arr1,0,arr1.length-1);
        System.out.println("output:" + Utils.printArraySingleLine(arr1));

    }

    private static int[] generateArray(int n){
        int arr[] = new int[2*n];
        for(int i=0;i<n;i++){
            arr[i] = arr[n+i] = i;
        }
        return arr;
    }
}
