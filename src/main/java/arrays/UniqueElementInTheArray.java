package arrays;

/**
 * You are given an array that contains integers. The integers content is
 * such that every integer occurs 3 times in that array leaving one integer
 * that appears only once.

 Fastest way to find that single integer
 eg:
 Input: [2,1,4,5,1,4,2,2,4,1]
 Answer: 5
 */
public class UniqueElementInTheArray {

    /**
     * If the problem were this: "one element appears once,
     * all others an even number of times", then the solution would be to XOR
     * the elements. The reason is that x^x = 0, so all the paired elements
     * would vanish leaving only the lonely element. If we tried the same
     * tactic here, we would be left with the XOR of distinct elements,
     * which is not what we want.



     Instead, the algorithm above does the following:



     ones is the XOR of all elements that have appeared exactly once so far
     twos is the XOR of all elements that have appeared exactly twice so far
     Each time we take x to be the next element in the array,
     there are three cases:



     if this is the first time x has appeared, it is XORed into ones
     if this is the second time x has appeared, it is taken out of ones (by
     XORing it again) and XORed into twos
     if this is the third time x has appeared, it is taken out of ones and twos.
     Therefore, in the end, ones will be the XOR of just one element,
     the lonely element that is not repeated. There are 5 lines of code that
     we need to look at to see why this works: the five after x = A[i].



     If this is the first time x has appeared, then ones&x=ones so twos
     remains unchanged. The line ones ^= x; XORs x with ones as claimed.
     Therefore x is in exactly one of ones and twos, so nothing happens in
     the last three lines to either ones or twos.



     If this is the second time x has appeared, then ones already has x (by
     the explanation above), so now twos gets it with the line twos |= ones &
     x;. Also, since ones has x, the line ones ^= x; removes x from ones
     (because x^x=0). Once again, the last three lines do nothing since
     exactly one of ones and twos now has x.



     If this is the third time x has appeared, then ones does not have x but
     twos does. So the first line let's twos keep x and the second adds x to ones.
     Now, since both ones and twos have x, the last three lines remove x from both.
     * @param arr
     * @return
     */
    public static int getUniqueElement(int arr[]){
        int ones=0, twos=0;
        int notThrees = 0;
        for(int i =0;i<arr.length;i++){
            int element = arr[i];
            twos |= ones&element;
            ones ^= element;
            notThrees = ~(ones&twos);
            ones &= notThrees;
            twos &= notThrees;
        }
        return ones;
    }

    public static void main(String[] args) {
        int arr[] =  {1,1,1,3,3,3,20,4,4,4};
        System.out.println("unique element is:" + getUniqueElement(arr));
    }
}
