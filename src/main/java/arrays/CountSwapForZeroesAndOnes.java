package arrays;

/**
 *Given an array containing sequence of bits (0 or 1), you have to sort this
 * array in the ascending order i.e. all 0' in first part of array followed
 * by all 1's. The constraints is that you can swap only the adjacent
 * elements in the array. Find the minimum number of swaps required to sort
 * the given input array.

 Example: Given the array (0,0,1,0,1,0,1,1) the minimum number of swaps is 3.

 Note: You just need to complete the function given below for this task. The
 function is given a binary string as input and returns the required answer.
 */
public class CountSwapForZeroesAndOnes {

    public static int countSwaps(int arr[]){
        int swapCount = 0;
        for(int i = 0; i <  arr.length; i++){
            if(arr[i] == 0) {
                int j = i;
                while(j >= 1){
                    if(arr[j-1] == 1){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        swapCount++;
                        j--;
                    }
                    else break;
                }
            }

        }
        return swapCount;
    }

    public static void main(String[] args) {
        int arr[] = {0,0,1,0,1,0,1,1,0};
        System.out.println("number of swaps = " + countSwaps(arr));
    }
}
