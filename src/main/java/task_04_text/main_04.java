package task_04_text;

import task_04_text.impl.LineAnalyzer;
import task_04_text.impl.LineAnalyzerResult;

public class main_04 {
    private static final String[] STRINGS = new String[]{
            "    xxxx, xxx x x",
            "xxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxx.     ",
            "xxx,xxxxxxxxxxxxx",
            ".................",
            ".......xxxxx....."
    };


    public static void main(String[] args) {
        LineAnalyzer l = new LineAnalyzer();
        for (String line : STRINGS) {
            LineAnalyzerResult res = l.analyze(line);
            System.out.println("line: " + line + " " + res.toString());
        }
    }
}
