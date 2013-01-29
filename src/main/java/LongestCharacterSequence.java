/**
 *
 Given a string, find the start position of the largest block of repeated
 charactes.

 After the solution, I was asked to write down as many test cases I could to
 test the function as if it was created by someone else.
 */
public class LongestCharacterSequence {

    public static class Data{
        public  int longestCount = 0;
        public int startPos = -1;

    }

    public static Data getCount(String str){
        Data data = new Data();
        int i = 1, count = 1;
        if(str.length() == 0 || str == null)
            return data;
        if(str.length() == 1){
            data.longestCount = 1;
            data.startPos = 0;
            return data;
        }
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(i-1))
                count++;
            else{
                if(data.longestCount < count){
                    data.longestCount = count;
                    data.startPos = i-count;
                }
                count = 1;
            }
            i++;
        }
        return data;
    }

    public static void main(String[] args) {
        String str = "abcdddeeeeeefsddeee";
//        String str = "a";
        System.out.println("input = " + str);
        Data data = getCount(str);
        System.out.printf("start = %d count = %d\n", data.startPos,
                          data.longestCount);
    }


}

