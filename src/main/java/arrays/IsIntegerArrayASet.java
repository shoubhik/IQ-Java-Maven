package arrays;

import utils.Utils;

/**
 * Tell me if a array of integers is a set.

 A set must pass on these three conditions:
 - All values are positive
 - Sorted
 - Non-duplicates

 After the first solution, I was asked about time and space complexity and to
 create 5 test cases for my function.


 */
public class IsIntegerArrayASet {

    public static boolean isASet(int arr[]){
        int unique = 1;
        for(int  i=1; i<arr.length;i++){
            int count = 0;
            while(count < unique){
                if(arr[count] == arr[i]){
                    break;
                }
                else
                    count++;
            }
            if(count == unique) {
                arr[unique] = arr[i];
                unique++;
            }

        }
        return unique == arr.length;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        boolean  isSet = isASet(arr);
        System.out.println("input = " + Utils.printArraySingleLine(arr));
        System.out.printf("output  = %b\n", isSet);

        int arr1[] = {1,4,5,1};
        isSet = isASet(arr1);
        System.out.println("input = " + Utils.printArraySingleLine(arr1));
        System.out.printf("output  = %b\n", isSet);

        isSet = isASet(new int[]{});
        System.out.println("input = " + Utils.printArraySingleLine(new int[]{}));
        System.out.printf("output  = %b\n", isSet);
    }
}
