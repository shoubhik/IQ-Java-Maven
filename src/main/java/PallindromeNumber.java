/**
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 *
 * First, the problem statement did not specify if negative integers qualify as
 * palindromes. Does negative integer such as -1 qualify as a palindrome?
 * Finding out the full requirements of a problem before coding is what every
 * programmer must do. For the purpose of discussion here, we define negative
 * integers as non-palindromes.
 * <p/>
 * The most intuitive approach is to first represent the integer as a string,
 * since it is more convenient to manipulate. Although this certainly does work,
 * it violates the restriction of not using extra space. (ie, you have to
 * allocate n characters to store the reversed integer as string, where n is the
 * maximum number of digits). I know, this sound like an unreasonable
 * requirement (since it uses so little space), but don’t most interview
 * problems have such requirements?
 * <p/>
 * Another approach is to first reverse the number. If the number is the same as
 * its reversed, then it must be a palindrome. You could reverse a number by
 * doing the following:
 * <p/>
 * int reverse(int num) { assert(num >= 0);   // for non-negative integers only.
 * int rev = 0; while (num != 0) { rev = rev * 10 + num % 10; num /= 10; }
 * return rev; }
 * <p/>
 * This seemed to work too, but did you consider the possibility that the
 * reversed number might overflow? If it overflows, the behavior is language
 * specific (For Java the number wraps around on overflow, but in C/C++ its
 * behavior is undefined). Yuck.
 * <p/>
 * Of course, we could avoid overflow by storing and returning a type that has
 * larger size than int (ie, long long). However, do note that this is language
 * specific, and the larger type might not always be available on all
 * languages.
 */
public class PallindromeNumber {

    public static boolean isPallindrome(int num) {
        int leftPowIdx = (int) Math.log10((double) num) + 1;
        int rightPowIdx = 1;
        boolean isPallindrome = true;
        while (leftPowIdx >= rightPowIdx) {
            int rightPart = ((num % (int) Math.pow(10, rightPowIdx)) -
                    (num % (int) Math.pow(10, rightPowIdx - 1)))
                    / (int) (int) Math.pow(10, rightPowIdx - 1);
            int leftPart = ((num - (num % (int) Math.pow(10, leftPowIdx - 1))) /
                    (int) Math.pow(10, leftPowIdx - 1)) % 10;
            if (rightPart != leftPart) {
                isPallindrome = false;
                break;
            }
            leftPowIdx--;
            rightPowIdx++;
        }
        return isPallindrome;

    }

    public static void main(String[] args) {
        System.out.println(isPallindrome(156651));
    }

}
