package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * You have an array of size n with values ranging from 1 to n. Exactly one
 * number is missed and one number is repeated. Find missing number and
 * Repeated number.
 */
public class FindRepeatedAndMissingNumber {

    public static void printRepeatedAndMissingNumber(int arr[]){
        int i = 0;
        while(i<arr.length){
            while(arr[i]-1 != i && arr[i] != -1){
                if(arr[i] == arr[arr[i] - 1 ]){
                    System.out.println("repeated  = " + arr[i]);
                    arr[i] = -1;
                    i++;
                }
                else{
                    int temp = arr[arr[i]-1];
                    arr[arr[i]-1]  = arr[i];
                    arr[i] = temp;
                }

            }
            i++;
        }
        for(i = 0; i <arr.length;i++){
            if(arr[i] == -1) System.out.println("missing =" + (i+ 1));
        }
    }

    private  static void printMissingAndDuplicate(int[] a){
        Set<Integer> set = new HashSet<Integer>();
        int duplicate = 0;
        long sum = 0;
        boolean isAdded = false;
        for(int i = 0;i<a.length;i++){
            isAdded = set.add(a[i]);
            if(!isAdded){
                duplicate = a[i];
            }
            sum += a[i];
        }
        sum = sum - duplicate;
        long idealSum = (a.length)*((a.length+1)/2);
        long missing = idealSum - sum;
        System.out.println("Duplicate and Missing "+duplicate+" "+missing);
    }



    public static void main(String[] args) {
        int arr[] = {2,4,5,1,6,1,3};
        printRepeatedAndMissingNumber(arr);
    }
}
