package arrays;

import utils.Utils;

/**
 * User: shoubhik Date: 30/12/12 Time: 7:21 PM
 */
public class RightRotateArray {
    /**
     * rotate once
     * both start index and end index inclusive
     * @param arr
     * @param startIdx
     * @param endIdx
     */

    public static void rightRotateSubArray(int arr[], int startIdx, int endIdx){
        assert(startIdx > 0);
        assert(endIdx < arr.length);
        int temp  = arr[endIdx];
        for(int i = endIdx ; i >= startIdx + 1; i--) {
            arr[i] = arr[i-1];
        }
        arr[startIdx] = temp;
    }

    public static void rightRotateNtimes(int arr[], int startIdx, int endIdx, int times){
        assert(startIdx > 0);
        assert(endIdx < arr.length);
        for(int  i= 0;i<times;i++){
            rightRotateSubArray(arr, startIdx, endIdx);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int startIdx,endIdx;
        System.out.println("original array:" +Utils.printArraySingleLine(arr));
        startIdx = 1;
        endIdx = 3;
        rightRotateSubArray(arr, startIdx, endIdx);
        System.out.println("after rotation:" +
                                   Utils.printArraySingleLineWithRotation(arr,
                                                             startIdx, endIdx));

        System.out.println("testing n rotations");
        int nrotate = 2;
        startIdx = 1;
        endIdx = 3;
        rightRotateNtimes(arr, startIdx , endIdx , nrotate);
        System.out.println("after " + nrotate + " array should be back to normal:"
                                   + Utils.printArraySingleLineWithRotation(arr,
                                               startIdx,endIdx));

        System.out.print(
                "rotating the whole array to test if it works on entire array");
        nrotate = 3;
        startIdx = 0;
        endIdx = arr.length -1;
        rightRotateNtimes(arr, startIdx , endIdx , nrotate);
        System.out.print(":" + Utils.printArraySingleLineWithRotation(arr,
                                                            startIdx, endIdx));
        System.out.println();
        System.out.print("testing for rotation of single element multiple times:");
        startIdx = endIdx = 1;
        rightRotateNtimes(arr, startIdx , endIdx , nrotate);
        System.out.print(Utils.printArraySingleLineWithRotation(arr, startIdx,
                                                                endIdx));
    }
}
