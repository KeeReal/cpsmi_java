package task_04_text_proc;

import java.util.HashSet;

public class main_04 {
    private static final String[] STRINGS = new String[]{
            "    xxxx, xxx x x",
            "xxxxxxxxxxxxxxxxx",
            "xxxxxxxxxxx.     ",
            "xxx,xxxxxxxxxxxxx",
            ".................",
            ".......xxxxx....."
    };


    private static final String DELIMITERS = "\t\n\r,. ";


    public static void main(String[] args) {
        // to hash
        HashSet<Character> delimiters = new HashSet<>();
        for (int i = 0; i < DELIMITERS.length(); ++i) {
            delimiters.add(DELIMITERS.charAt(i));
        }

        for (int i = 0; i < STRINGS.length; ++i) {
            int numWords = 0;
            int numAlpha = 0;
            boolean word = false;

            String s = STRINGS[i];
            for (int j = 0; j < s.length(); ++j) {
                char current = s.charAt(j);
                if (delimiters.contains(current)) {
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

            System.out.println(s + ": contains " + numAlpha + " alpha character(s) and " + numWords + " word(s)");
        }
    }
}
