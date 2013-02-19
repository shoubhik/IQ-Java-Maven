package dynamicprogramming;

/**
 * User: shoubhik Date: 19/2/13 Time: 1:54 PM
 */
public class FibinacciWithMemoization {

    public static int getNthFiboncci(int  n){
        int arr[] = new int[2];
        arr[0]  = 1; arr[1] = 1;
        for(int i=2;i<=n;i++){
            int nth = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = nth;
        }
        return  arr[1];

    }

    public static void largestFibonacciLessThanGivenNumber( int num){
        int arr[] = new int[2];
        arr[0]  = 1; arr[1] = 1;
        int  i = 1;
        while(arr[1] < num){
            int nth = arr[0]  + arr[1];
            arr[0] = arr[1];
            arr[1] = nth;
            i++;
        }

        System.out.printf("fib(%d) = %d < %d", i-1, arr[0], num);

    }

    public static void main(String[] args) {
        System.out.println("fib(5) = " + getNthFiboncci(2));
        largestFibonacciLessThanGivenNumber(300);
    }
}
