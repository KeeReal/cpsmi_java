package task_05_parens.impl;

public class ParenthesesAnalyzer {
    private static final char OPEN_PAREN = '(';
    private static final char CLOSE_PAREN = ')';


    public ParenthesesAnalyzer() {
    }


    public boolean isBalanced(String line) {
        int parenthesesCounter = 0;

        for (int j = 0; j < line.length(); ++j) {
            char current = line.charAt(j);
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
