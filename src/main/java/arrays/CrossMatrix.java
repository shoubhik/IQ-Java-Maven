package arrays;

import utils.Utils;

/**
 *  Determine if a matrix is a cross-matrix.
 A cross-matrix is a one in which all the diagonal elements are same and not
 repeated anywhere else.
 */
public class CrossMatrix {

    public static boolean isCrossMatrix(int arr[][], int rows , int columns){
        int diagElement = arr[0][0];
        for(int i = 0 ; i< rows;i++){
            for(int j  = 0 ; j<columns;j++){
                if(i != j && arr[i][j] == diagElement)
                    return false;
                else if( i == j && arr[i][j] != diagElement)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{2,1,1},{3,2,3},{4,4,2}};
        System.out.println("input = ");
        System.out.println(Utils.print2DArray(arr,3,3));
        System.out.println("isCrossMatrix = "  +
                                   String.valueOf(isCrossMatrix(arr,3,3)));
        System.out.println();

        int arr1[][] = new int[][]{{3,1,1},{3,2,3},{4,4,2}};
        System.out.println("input = ");
        System.out.println(Utils.print2DArray(arr1,3,3));
        System.out.println("isCrossMatrix = "  +
                                   String.valueOf(isCrossMatrix(arr1,3,3)));

        System.out.println();
        int arr2[][] = new int[][]{{2,1,2},{3,2,3},{4,4,2}};
        System.out.println("input = ");
        System.out.println(Utils.print2DArray(arr2,3,3));
        System.out.println("isCrossMatrix = "  +
                                   String.valueOf(isCrossMatrix(arr2,3,3)));
    }
}
