package Labwork3.input_output;

public class WordCount {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
        }

        // output
        StdOut.println("number of words = " + count);
    }
}