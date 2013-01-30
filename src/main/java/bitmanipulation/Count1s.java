package bitmanipulation;

/**
 * count number of 1s in a number
 */
public class Count1s {

    public static long getCountOfOnes(long n){
        long count = 0;
        for(count =0; n > 0; count++)
            n &= n-1; // clear the least significant bit set
        return count;
    }

    public static void main(String[] args) {
        long n = 7;
        System.out.printf("ones in %d is %d", n, getCountOfOnes(n));
    }
}
