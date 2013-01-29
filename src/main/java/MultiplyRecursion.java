/**
 * User: shoubhik Date: 27/12/12 Time: 4:15 PM
 */
public class MultiplyRecursion {

    private static void multiply(int n, int m, int result) {
        if(m == 0) System.out.println(result);
        else{
            result += n;
            multiply(n, m -1, result);
        }
    }

    public static void main(String[] args) {
        multiply(5, 5, 0);
    }
}
