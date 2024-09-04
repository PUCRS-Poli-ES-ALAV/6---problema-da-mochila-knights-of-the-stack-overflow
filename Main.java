import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // FIBO (n)
    //     f [0] ← 0 
    //     f [1] ← 1
    //     para i ← 2 até n faça
    //         f[i] ← f[i-1]+f[i-2]
    //     devolva f [n]

    public static int fibo(int n) {
        Map<Integer, Integer> f = new HashMap<>();
        f.put(0, 0);
        f.put(1, 1);

        for (Integer i = 2; i <= n; i++) {
            Integer a = f.get(i - 1);
            Integer b = f.get(i - 2);

            f.put(i, a + b);
        }

        return f.get(n);
    }

    // MEMOIZED-FIBO (n)
    //     para i ← 0 até n faça
    //         f [i] ← −1
    //     devolva LOOKUP-FIBO (f, n)

    // LOOKUP-FIBO (f, n)
    //     se f [n] ≥ 0
    //         então devolva f [n]
    //     se n ≤ 1
    //         então f [n] ← n
    //     senão 
    //         f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
    //     devolva f [n]




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

        System.out.println("\n");

        for (Integer i : tests) {
            long startTime = System.currentTimeMillis();
            int fib = fiboRec(i.intValue());
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            System.out.println("fib " + i.intValue() + ", "+ fibo(i.intValue()) + ", " + execTime + "ms;");
        }
    }
}