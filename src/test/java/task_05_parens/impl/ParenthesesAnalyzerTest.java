package task_05_parens.impl;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesesAnalyzerTest {
    @Test
    public void isBalanced() throws Exception {
        final String[] LINES = new String[]{
                "(a(b))",
                "()(())",
                "(a)(b) c (d(efg))",
                ")(",
                ")()",
                "((())())"
        };


        ParenthesesAnalyzer analyzer = new ParenthesesAnalyzer();

        Assert.assertEquals(true, analyzer.isBalanced("(a(b))"));
        Assert.assertEquals(true, analyzer.isBalanced("(a)(b) c (d(efg))"));
        Assert.assertEquals(false, analyzer.isBalanced(")("));
        Assert.assertEquals(false, analyzer.isBalanced(")()"));
        Assert.assertEquals(false, analyzer.isBalanced("("));
        Assert.assertEquals(false, analyzer.isBalanced(")"));
        Assert.assertEquals(true, analyzer.isBalanced("((())())"));
    }
}