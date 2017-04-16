package task_03_fact;

import java.util.HashMap;

public class main_03 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("I need one argument of type INT");
            System.exit(0);
        }

        int arg = 0;
        try {
            arg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Dont f*ck with me");
            System.exit(0);
        }

        if (arg <= 0) {
            System.out.println("Only positive integers are allowed!");
            System.exit(0);
        }

        if (arg > 10) {
            System.out.println("Plz no");
            System.exit(0);
        }

        System.out.println("got: " + arg);

        HashMap<Integer, Integer> buffer = new HashMap<>();
        buffer.put(1, 1);
        buffer.put(2, 2);
//        for (int )
        int r = 1;
        for (int i = 2; i <= arg; ++i) {
            r *= i;
        }

        System.out.println(arg + "! = " + r);


    }
}
