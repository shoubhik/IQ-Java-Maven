package utils;

/**
 * User: shoubhik Date: 21/12/12 Time: 4:28 PM
 */
public class Utils {
    private Utils(){}

    public static String printArraySingleLine(int arr[]){
        return printArraySingleLine(arr, arr.length);
    }

    public static String printArraySingleLine(int arr[], int idx){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < idx;i++) sb.append(arr[i] + " ");
        return sb.toString();
    }

    public static String print2DArray(int arr[][], int rows, int columns){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <rows;i++){
            for(int  j = 0; j<columns;j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printArraySingleLineWithRotation(int arr[],
                                                          int startIdx,
                                                          int endIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i == startIdx)
                sb.append("| ");
            sb.append(arr[i] + " ");
            if(i == endIdx)
                sb.append("| ");

        }
        return sb.toString();

    }

    public static String toBinary(int num){
        return Integer.toBinaryString(num);
    }

    public static String toBinaryWithIndex(int num, int...indeces){
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(num));
        sb.append("\n");
        for(int  i = 31; i >= 0; i--) {
            for(int idx: indeces){
//                if()
            }
        }
        return Integer.toBinaryString(num);
    }
}
