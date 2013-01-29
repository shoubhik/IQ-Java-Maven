package utils;

/**
 * User: shoubhik Date: 20/12/12 Time: 9:54 PM
 */
public class MutableInteger {

    private int val;

    public MutableInteger(int val){
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    public int setVal(int val) {
        return this.val = val;
    }

    public void increment(){
        this.val++;
    }
}
