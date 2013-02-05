package utils;

/**
 * Util class fro co ordinates
 */
public class CoOrdinate implements Comparable<CoOrdinate>{

    public float x, y;
    public double key;

    public CoOrdinate(float x, float y){
        this(x,y,0);
    }

    public CoOrdinate(float x, float y, double key){
        this.key = key;
        this.x = x;
        this.y = y;
    }

    public int compareTo(CoOrdinate o) {
        if(this.key == o.key)
            return 0;
        else if(this.key < o.key)
            return -1;
        else return 1;
    }

    public String toString(){
        return "[" + this.x + "," + this.y + "]";
    }
}
