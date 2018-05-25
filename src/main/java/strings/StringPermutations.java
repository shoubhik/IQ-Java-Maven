package strings;

public class StringPermutations
{

  static void permutations(char arr[], int a, int b) {
    System.out.printf("(%d, %d, %s)", a, b, new String(arr  ));
    if(a == b) {
      System.out.println(new String(arr));
    } else {
      for (int i = a; i <= b; i++) {
        char temp = arr[a];
        arr[a] = arr[i];
        arr[i] = temp;
        permutations(arr, a + 1, b);
        temp = arr[a];
        arr[a] = arr[i];
        arr[i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    char[] arr = "abc".toCharArray();
    permutations(arr, 0, arr.length - 1);
  }
}
