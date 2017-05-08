package task_04_text.impl;

import java.util.HashSet;

public class LineAnalyzer {
    private static final HashSet<Character> delimiters;
    static {
        delimiters = new HashSet<Character>();
        delimiters.add('\t');
        delimiters.add('\n');
        delimiters.add('\r');
        delimiters.add(',');
        delimiters.add('.');
        delimiters.add(' ');
    }


    public LineAnalyzer() {
    }


    public LineAnalyzerResult analyze(String line) {
        boolean word = false;
        int numWords = 0;
        int numAlpha = 0;

        for (int i = 0; i < line.length(); ++i) {
            char ch = line.charAt(i);
            if (delimiters.contains(ch)) {
                if (word) {
                    word = false;
                    numWords++;
                }
            } else {
                if (!word) {
                    word = true;
                }
                numAlpha++;
            }
        }

        if (word) {
            numWords++;
        }

        return new LineAnalyzerResult(numAlpha, numWords);
    }
}
