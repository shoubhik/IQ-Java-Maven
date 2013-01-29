package divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Implement a method for a web service call that receives a collection of n
 coordinate points and returns
 the kth closest point to the origin (0,0). For example,
 if k=1 the closest point to the origin should be
 returned. If k=n the furthest point from the origin should be returned. (Use
 Divide and Conquer Approach looking for implementation in Java)
 */
public class KthDistantPoint {

    public static class Coord2D{
        private float x, y;

        public Coord2D(float x, float y){
            this.x = x;
            this.y = y;
        }

        public double getDistance(Coord2D point){
            return Math.sqrt((this.x-point.x )*( this.x-point.x) +
                             (this.y-point.y )*( this.y-point.y));

        }
        // considering distance from origin
        public boolean isLessThan(Coord2D point){
            return this.getDistance(ORIGIN) <  point.getDistance(ORIGIN);
        }

        public String toString(){
            return "(x = "  + this.x + " y = " + this.y + ")";
        }
    }

    public static final Coord2D ORIGIN = new Coord2D(0,0);

    /**
     * the quick select algo similar to quick sort.
     * @param coordinates
     * @param low
     * @param high
     * @param k
     * @return
     */
    public static Coord2D quickSelect(List<Coord2D> coordinates, int low,
                                      int high, int k){
        int pivot = partition(coordinates, low, high);
        if(k < pivot)
            return quickSelect(coordinates, low, pivot - 1, k);
        else if(k > pivot)
            return quickSelect(coordinates, pivot + 1, high, k);
        else
            return coordinates.get(k);
    }

    private static int partition(List<Coord2D> coordinates, int low, int high) {
        int pivot  = high;
        Coord2D pivotElement = coordinates.get(pivot);
        int firstHigh = low;
        for(int i = low ; i < high; i++){
            if(coordinates.get(i).isLessThan(pivotElement)){
                swap(coordinates, i, firstHigh);
                firstHigh++;
            }
        }
        swap(coordinates, firstHigh, pivot);
        return firstHigh;
    }

    private static void swap(List<Coord2D> coord2DList, int idx1, int idx2){
        Coord2D temp = coord2DList.get(idx1);
        coord2DList.set(idx1,  coord2DList.get(idx2));
        coord2DList.set(idx2, temp);
    }

    public static void main(String[] args) {
        List<Coord2D> coordinates= new ArrayList<Coord2D>();
        coordinates.add(new Coord2D(4,4));
        coordinates.add(new Coord2D(1,1));
        coordinates.add(new Coord2D(5,5));
        coordinates.add(new Coord2D(3,3));

        int kth = 4;
        kth--; // for zero index
        Coord2D result = quickSelect(coordinates, 0 , coordinates.size()-1, kth);
        System.out.println(kth + " th point from origin is " + result);
    }
}
