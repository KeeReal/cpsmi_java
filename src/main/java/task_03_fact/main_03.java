package task_03_fact;

import task_03_fact.impl.FactorialCalculator;

import java.util.HashMap;

public class main_03 {
    public static void main(String[] args) {


        if (args.length == 0) {
            System.err.println("I need one argument!");
            System.exit(0);
        }


        int arg = 0;
        try {
            arg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument must be of type INT");
            System.exit(0);
        }

        if (arg <= 0) {
            System.err.println("Only positive integers are allowed!");
            System.exit(0);
        }

        if (arg > 10) {
            System.out.println("I don't want to work with such big numbers");
            System.exit(0);
        }

        System.out.println("got: " + arg);

        FactorialCalculator factorialCalculator = new FactorialCalculator();
        System.out.println("!" + arg + " = " + factorialCalculator.calculate(arg));
    }
}
