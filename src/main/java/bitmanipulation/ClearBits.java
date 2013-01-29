package bitmanipulation;

import utils.Utils;

/**
 * Given a integer. clear its bits from i to j
 */
public class ClearBits {

    public static void main(String[] args) {
        int max = ~0;
        int leftShiftIdx = 23;
        int rightShiftIdx = 16;
        int left = max - ((1 << leftShiftIdx) - 1 ) ;
        int right  = (1 << rightShiftIdx) - 1 ;
        System.out.println("max = " + Utils.toBinary(max));
        System.out.println("left = " + Utils.toBinary(left));
        System.out.println("right = " + Utils.toBinary(right));
        int mask = left | right;
        System.out.println("mask = " + Utils.toBinary(mask));
        int num = 0xaabbccdd;
        System.out.println("num = " + Utils.toBinary(num));
        System.out.println("num = " + Utils.toBinary(num & mask));



    }
}
