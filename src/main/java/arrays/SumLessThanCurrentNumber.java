package arrays;

/**
 *28 Answers
 Given an unsorted array.
 With each number, we can associated a sum which is equal to the sum of all
 the numbers, less than the current number.
 We've to find the total sum of all those numbers.
 e.g. unsorted array :1, 5, 3, 6, 4.
 for a[0]=1, sum[0]=0
 for a[1]=5, sum[1]=1
 for a[2]=3, sum[2]=1
 for a[3]=6, sum[3]=1+5+3
 for a[4]=4, sum[4]=1+3
 total sum =sum[0]+sum[1]+sum[2]+sum[3]+sum[4] = 15


 */
public class SumLessThanCurrentNumber {

    public static int getSum(int arr[], int idx){
        if(idx == 0) return 0;
        int sum = 0;
        for(int i = idx-1;i>=0;i--){
            if(arr[i] < arr[idx])
                sum += arr[i];
        }
        sum += getSum(arr, idx-1);
        return sum;
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 6, 4};
        System.out.println("sum = " + getSum(arr, arr.length-1));
    }
}
