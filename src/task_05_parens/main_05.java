package task_05_parens;

public class main_05 {
    public static final String[] STRINGS = new String[]{
            "(a(b))",
            "()(())",
            ")(",
            ")()",
            "((())())"
    };

    public static final char OPEN_PAREN = '(';
    public static final char CLOSE_PAREN = ')';


    public static void main(String[] args) {
        for (int i = 0; i < STRINGS.length; ++i) {
            String s = STRINGS[i];
            int counter = 0;
            for (int j = 0; j < s.length(); ++j) {
                char current = s.charAt(j);
                if (current == OPEN_PAREN) {
                    counter++;
                } else if (current == CLOSE_PAREN) {
                    if (counter == 0) {
                        counter = -100;
                        j = s.length() + 1;
                    }
                    counter--;
                }
            }

            System.out.println(s + " is ok? " + (counter == 0));
        }
    }
}
