package task_05_parens;

import task_05_parens.impl.ParenthesesAnalyzer;

public class main_05 {
    private static final String[] LINES = new String[]{
            "(a(b))",
            "()(())",
            "(a)(b) c (d(efg))",
            ")(",
            ")()",
            "((())())"
    };


    public static void main(String[] args) {
        ParenthesesAnalyzer parens = new ParenthesesAnalyzer();
        for (String line : LINES) {
            boolean isBalanced = parens.isBalanced(line);
            System.out.print(line);
            if (isBalanced) {
                System.out.println(" : is balanced");
            } else {
                System.out.println(" : is not balanced");
            }
        }
    }
}