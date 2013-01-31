package arrays;

/**
 * Find the number repeated odd number of times
 */
public class ElementRepeatingOddNumberOfTimes {

    public static int getNumber(int arr[]){
        int num  = arr[0];
        for(int k=1;k<arr.length;k++)
            num ^= arr[k];
        return num;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,2,2,3,3,3,4,4,4,4,4,4};
        System.out.printf("number repeated odd numbers = %d  " , getNumber(arr));
    }
}
