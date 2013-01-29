package divideandconquer;

import utils.Utils;

/**
 * QuckSort algo
 */
public class QuickSort {

    public static void quicksort(int arr[], int low, int high){
        if(high - low > 0){
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int firstHigh = low;
        int pivot = high;
        for(int  i = low; i < high; i++){
            if(arr[i] < arr[pivot]){
                swap(arr, i, firstHigh);
                firstHigh++;
            }
        }
        swap(arr, firstHigh, pivot);
        return firstHigh;
    }

    private static void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    public static void main(String[] args) {
        int arr[] = {7,5,3,2,9,22,15,98,1,45};
        System.out.println("input  = " + Utils.printArraySingleLine(arr));
        quicksort(arr,0,arr.length-1);
        System.out.println("output = " + Utils.printArraySingleLine(arr));
    }
}
