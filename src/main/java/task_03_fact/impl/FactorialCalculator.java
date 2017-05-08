package task_03_fact.impl;

public class FactorialCalculator {
    public FactorialCalculator() {
    }


    public int calculate(int arg) {
        if (arg < 2) {
            return arg;
        }

        int a = arg;
        int b = arg - 1;

        while (b > 1) {
            a = a * b--;
        }
        return a;
    }
}
