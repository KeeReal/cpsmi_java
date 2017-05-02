package task_05_parens;

public class main_05 {
    public static final String[] STRINGS = new String[]{
            "(a(b))",
            "()(())",
            "(a)(b) c (d(efg))",
            ")(",
            ")()",
            "((())())"
    };

    public static final char OPEN_PAREN = '(';
    public static final char CLOSE_PAREN = ')';


    public static void main(String[] args) {
        for (int i = 0; i < STRINGS.length; ++i) {
            String s = STRINGS[i];
            String result = isBalanced(s)
                    ? "is balanced"
                    : "is not balanced";

            System.out.println(s + " : " + result);
        }
    }


    private static boolean isBalanced(String s) {
        int parenthesesCounter = 0;

        for (int j = 0; j < s.length(); ++j) {
            char current = s.charAt(j);
            if (current == OPEN_PAREN) {
                parenthesesCounter++;
            } else if (current == CLOSE_PAREN) {
                if (parenthesesCounter == 0) {
                    return false;
                }
                parenthesesCounter--;
            }
        }
        return parenthesesCounter == 0;
    }
}
