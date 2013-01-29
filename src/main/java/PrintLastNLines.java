import utils.MutableInteger;

/**
 * WAP to print last 10 lines of given string. If string has less than 10
 * lines then print whole string, lines are separated by ‘\n’
 */
public class PrintLastNLines {

    private static void printLines(String str, String line, int numLinesToPrint,
                                   MutableInteger printedLines, int currentIdx)
    {
        if(currentIdx < str.length()){
            int lineIdx = str.indexOf("\n",currentIdx);
            if(lineIdx == -1) lineIdx = str.length();
            String nxtLine = str.substring(currentIdx, lineIdx);
            currentIdx = lineIdx + 1;
            printLines(str, nxtLine, numLinesToPrint, printedLines, currentIdx);
        }
        if(printedLines.getVal() >= numLinesToPrint)
            return;
        System.out.println(line);
        printedLines.increment();

    }

    public static void main(String[] args) {
        String str = "first line\nsecond line\nthird line\nfourth line";
        int idx = str.indexOf("\n");
        int linesToPrint = 3;

        printLines(str, str.substring(0,idx), linesToPrint, new MutableInteger(0),
                   idx + 1);
    }
}
