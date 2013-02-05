package heap;

import utils.CoOrdinate;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of coordinates find the k closest to a given coordinate
 */
public class KNearestPoints {

    private static double getDistance(CoOrdinate center, CoOrdinate point){
        return Utils.getDistance(center, point);
    }

    public static void printKClosest(List<CoOrdinate> list, int k){
        Heap<CoOrdinate> heap = new Heap<CoOrdinate>(Heap.HEAP_TYPE.MIN_HEAP);
        for(CoOrdinate point : list)
            heap.add(point);
        if(k > heap.size())
            k = heap.size();
        for(int i = 0; i < k; i++){
            CoOrdinate pt = heap.extract();
            System.out.println( pt + " key = " + pt.key);
        }
    }

    public static void main(String[] args) {
        List<CoOrdinate> list = new ArrayList<CoOrdinate>();
        CoOrdinate center = new CoOrdinate(3,3);
        CoOrdinate p1 = new CoOrdinate(1,1);
        p1.key = getDistance(center, p1);
        CoOrdinate p2 = new CoOrdinate(5.5f,6);
        p2.key = getDistance(center, p2);
        CoOrdinate p3 = new CoOrdinate(-1,3.3f);
        p3.key = getDistance(center, p3);
        CoOrdinate p4 = new CoOrdinate(-1,-3.3f);
        p4.key = getDistance(center, p4);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        int k = 4;
        printKClosest(list, 4);


    }
}
