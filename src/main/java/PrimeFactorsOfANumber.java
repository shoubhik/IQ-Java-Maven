/**
 * number is 12, then output should be “2 2 3″. And if the input number is
 * 315, then output should be “3 3 5 7″.

 Following are the steps to find all prime factors.
 1) While n is divisible by 2, print 2 and divide n by 2.
 2) After step 1, n must be odd. Now start a loop from i = 3 to square root
 of n. While i divides n, print i and divide n by i,
 increment i by 2 and continue.
 3) If n is a prime number and is greater than 2, then n will not become 1 by
 above two steps. So print n if it is greater than 2.
 */
public class PrimeFactorsOfANumber {

    private static void printPrimeFactors(int num){
        while(num % 2== 0){
            System.out.print(2+ " ");
            num /= 2;
        }
        for(int i = 3; i <= Math.sqrt(num); i+=2){
            while(num % i == 0){
                System.out.print(i + " ");
                num /= i;
            }
        }
        if(num > 2 ) System.out.print(num + " ");

    }

    public static void main(String[] args) {
        printPrimeFactors(23);

    }
}
