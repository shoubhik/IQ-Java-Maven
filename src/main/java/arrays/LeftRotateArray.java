package arrays;

import utils.Utils;

/**
 * User: shoubhik Date: 30/12/12 Time: 7:41 PM
 */
public class LeftRotateArray {

    public static void leftRotateSubArray(int arr[], int startIdx, int endIdx){
        assert(startIdx > 0 && startIdx < arr.length);
        assert(endIdx >= startIdx && endIdx < arr.length);
        int temp = arr[startIdx];
        for(int i=startIdx;i<endIdx;i++) {
            arr[i] = arr[i+1];
        }
        arr[endIdx] = temp;
    }

    public static void leftRotateSubArrayNtimes(int arr[], int startIdx,
                                                int endIdx, int times) {
        for(int  i = 0;i<times;i++){
            leftRotateSubArray(arr, startIdx, endIdx);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int startIdx,endIdx;
        System.out.println("original array:" + Utils.printArraySingleLine(arr));
        startIdx = 1;
        endIdx = 3;
        leftRotateSubArray(arr, startIdx, endIdx);
        System.out.println("after rotation:" +
                                   Utils.printArraySingleLineWithRotation(arr,
                                                             startIdx, endIdx));

        System.out.println("testing n rotations");
        int nrotate = 2;
        startIdx = 1;
        endIdx = 3;
        leftRotateSubArrayNtimes(arr, startIdx , endIdx , nrotate);
        System.out.println("after " + nrotate + " array should be back to normal:"
                                   + Utils.printArraySingleLineWithRotation(arr,
                                                              startIdx,endIdx));

        System.out.print(
                "rotating the whole array to test if it works on entire array");
        nrotate = 2;
        startIdx = 0;
        endIdx = arr.length -1;
        leftRotateSubArrayNtimes(arr, startIdx , endIdx , nrotate);
        System.out.print(":" + Utils.printArraySingleLineWithRotation(arr,
                                                             startIdx, endIdx));
        System.out.println();
        System.out.print("testing for rotation of single element multiple times:");
        startIdx = endIdx = 1;
        leftRotateSubArrayNtimes(arr, startIdx , endIdx , nrotate);
        System.out.print(Utils.printArraySingleLineWithRotation(arr, startIdx,
                                                                endIdx));
    }
}
