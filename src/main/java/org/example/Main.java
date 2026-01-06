package org.example;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println("Hello and welcome!");

        System.out.println(fibonacci(5));
        System.out.println(fibonacci(-1));

        System.out.println(test(1));

        /*
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }

         */
    }

    public static int fibonacci(int n) {
        int result;


        //assert funltionur nur wenn java -ea Main ausgeführt wird
        assert n>=0 : "Die Fibonacci Zahlen sind nur für positive Zahlen sefiniert";
        switch (n) {
            case 0: {
                return 0;
            }

            case 1: {
                return 1;
            }

            default: {
                result = fibonacci(n - 1) + fibonacci(n - 2);
            }
            return result;
        }
    }

    public static int test (int x) {
        switch (x) {
            case 0:
                System.out.println("Case 0");
                break;
            case 1:
                System.out.println("Case 1");
                return 1;
        } return 10;

    }
}
