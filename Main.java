import java.util.ArrayList;
import java.util.List;

class Main {

// FIBO-REC (n)
//     se n ≤ 1
//     então 
//         devolva n
//     senão 
//         a ← FIBO-REC (n − 1)
//         b ← FIBO-REC (n − 2)
//         devolva a + b

public static int fiboRec(int n) {
    if (n <= 1) {
        return n;
    }

    int a = fiboRec(n - 1);
    int b = fiboRec(n - 2);

    return a + b;
}

    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        List<Integer> tests = new ArrayList<Integer>();
        tests.add(4);
        tests.add(8);
        tests.add(16);
        tests.add(32);

        for (Integer i : tests) {
            long startTime = System.currentTimeMillis();
            int fib = fiboRec(i.intValue());
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            System.out.println("fibRec " + i.intValue() + ", "+ fiboRec(i.intValue()) + ", " + execTime + "ms;");
        }
    }
}