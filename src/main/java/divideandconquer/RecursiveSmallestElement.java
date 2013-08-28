package divideandconquer;

/**
 * Created with IntelliJ IDEA. User: shoubhik Date: 28/8/13 Time: 6:36 PM To
 * change this template use File | Settings | File Templates.
 */
public class RecursiveSmallestElement {

    public static int smallestElement(int arr[], int ll, int rr){
        if(ll == rr)
            return arr[ll];
        if(rr-ll+1 == 2)
            return Math.min(arr[ll], arr[rr]);
        int mid  = (ll+rr)/2;
        return Math.min(smallestElement(arr, ll, mid), smallestElement(arr, mid+1, rr) );
    }

    public static void main(String[] args) {
        int arr[] = {1,4,-15,6,3,-10,11};
        System.out.println(smallestElement(arr, 0, arr.length-1));
    }
}
