package backtracking;


import utils.MutableInteger;

/**
 * User: shoubhik Date: 28/12/12 Time: 11:27 PM
 */
public abstract class GeneralBackTrackingAlgo {

    protected int MAX_CANDIDATES = 100;

    public static class Data {
        private Object data;

        public Data(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    public static Data getData(Object o){
        return new Data(o);
    }

    private static boolean FINISHED = false; /* found all solutions yet*/

    public void backtrack(int a[], int k, Data input) {

        int c[] = new int[MAX_CANDIDATES] ;
        MutableInteger ncandidates = new MutableInteger(0);
        int i;

        if(is_a_solution(a, k, input))
            process_solution(a,k,input) ;
        else{
            k++;
            construct_candidates(a,k,input,c, ncandidates);
            for(i=0;i<ncandidates.getVal();i++){
                a[k] = c[i];
                backtrack(a,k,input);
                if(FINISHED) return;
            }
        }
    }

    protected abstract void construct_candidates(int[] a, int k, Data input,
                                                 int[] c,
                                                 MutableInteger ncandidates);

    protected abstract void process_solution(int[] a, int k, Data input);

    protected abstract boolean is_a_solution(int[] a, int k, Data input);


}
