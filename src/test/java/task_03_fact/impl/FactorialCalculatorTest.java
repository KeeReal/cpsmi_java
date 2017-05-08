package task_03_fact.impl;

import org.junit.Assert;
import org.junit.Test;

public class FactorialCalculatorTest {
    @Test
    public void testCalculate() throws Exception {
        FactorialCalculator f = new FactorialCalculator();
        Assert.assertEquals("Expect !3 = 6", 6, f.calculate(3));
        Assert.assertEquals("Expect !4 = 24", 24, f.calculate(4));
    }
}