package task_04_text.impl;

import org.junit.Assert;
import org.junit.Test;

public class LineAnalyzerTest {
    @Test
    public void analyze() throws Exception {
        LineAnalyzer analyzer = new LineAnalyzer();
        resultShouldBe(9, 4, analyzer.analyze("    xxxx, xxx x x"));
        resultShouldBe(17, 1, analyzer.analyze("xxxxxxxxxxxxxxxxx"));
        resultShouldBe(11, 1, analyzer.analyze("xxxxxxxxxxx.     "));
        resultShouldBe(16, 2, analyzer.analyze("xxx,xxxxxxxxxxxxx"));
        resultShouldBe(0, 0, analyzer.analyze("................."));
        resultShouldBe(5, 1, analyzer.analyze(".......xxxxx....."));
    }


    private void resultShouldBe(int alphas, int words, LineAnalyzerResult result) {
        Assert.assertEquals(result.getAlphas(), alphas);
        Assert.assertEquals(result.getWords(), words);
    }
}