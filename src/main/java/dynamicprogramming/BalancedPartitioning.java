package dynamicprogramming;

/**
 * In Balanced Partition problem,you have a set of n integers each in the
 * range 0 … K. Partition these integers into two subsets such that you
 * minimize |S1 – S2|, where S1 and S2 denote the sums of the elements in
 * each of the two subsets.
 */
public class BalancedPartitioning {

    /**
     * Algorithm:
     Firstly this algorithm can be viewed as knapsack problem where
     individual array elements are the weights and half the sum as total
     weight of the knapsack.

     1.take a solution array as boolean array sol[] of size sum/2+1

     2. For each array element,traverse the array and set sol [j] to be true
     if sol [j - value of array] is true

     3.Let halfsumcloser be the closest reachable number to half the sum and
     partition are sum-halfsumcloser and halfsumcloser.

     4.start from halfsum and decrease halfsumcloser once everytime until you
     find that sol[halfsumcloser] is true
     * @param arr
     * @return
     */
    public int getPartitionedMinSum(int arr[]/*array of +ve int*/){
        int sum = 0;
        for(int i =0;i<arr.length;i++)
            sum += arr[i];
        boolean lookUpTable[] = new boolean[sum/2 + 1];
        lookUpTable[0] = true;
        // this is bottom up approach
        for(int i : arr){
            for(int j= sum/2; j >= i; j--){
                if(lookUpTable[j-1]) lookUpTable[j] = true;
            }
        }
        int halfSumCloser = sum/2;
        for(;lookUpTable[halfSumCloser];halfSumCloser--);
        return halfSumCloser;
    }

    public static void main(String[] args) {
        BalancedPartitioning balancedPartitioning = new BalancedPartitioning();
        int arr[] ={2,10,3,8,5,7,9,5,3,2};
        int halfSum = balancedPartitioning.getPartitionedMinSum(arr);
        int sum = 0;
        for(int i=0;i<arr.length;i++) sum += arr[i];
        System.out.println("min diff = " + (sum - 2 * halfSum));
        System.out.println("half sum = " + halfSum);
    }
}
