package readerwriters;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * User: shoubhik Date: 10/12/12 Time: 12:39 PM
 */
public class PaddedWriter {
    private int width = 0;
    private char fillChar = ' ';
    private final PrintStream writer;

    public PaddedWriter(PrintStream writer) {
        this.writer = writer;
    }

    public void setw(int i) {
        width = i;
    }

    public void setfill(char c) {
        fillChar = c;
    }

    public void write(String str) {
        write(str.toCharArray());
    }

    void write(char[] buf) {
        if (buf.length < width) {
            char[] pad = new char[width - buf.length];
            Arrays.fill(pad, fillChar);
            writer.print(pad);
        }
        writer.print(buf);
        setw(0);
    }

    public void write() {
        char[] pad = new char[width];
        Arrays.fill(pad, fillChar);
        writer.print(pad);
        setw(0);
    }

    public void endl() {
        writer.println();
        setw(0);
    }
}