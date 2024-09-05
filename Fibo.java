/**
 * @author Anderson R. P. Sprenger
 * @author Vinicius P. Dias
 */

import java.util.ArrayList;
import java.util.List;

class Fibo {

    // FIBO-REC (n)
    //     se n ≤ 1
    //     então 
    //         devolva n
    //     senão 
    //         a ← FIBO-REC (n − 1)
    //         b ← FIBO-REC (n − 2)
    //         devolva a + b

    public int fiboRec(int n) {
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

    public int fibo(int n) {
        int [] f = new int[n + 1]; // 0 .. n
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            int a = f[i - 1];
            int b = f[i - 2];

            f[i] = a + b;
        }

        return f[n];
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

    public int memoizedFibo(int n) {
        int [] f = new int[n + 1]; // 0 .. n

        for (int i = 0; i < f.length; i++) {
            f[i] = -1;
        }

        return lookupFibo(f, n);
    }

    private int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }

        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }

        return f[n];
    }



    public void main(String[] args) {
        System.out.println("Hello world!\n");

        Fibo app = new Fibo();

        List<Integer> tests = new ArrayList<Integer>();
        tests.add(4);
        tests.add(8);
        tests.add(16);
        tests.add(32);

        for (Integer i : tests) {
            long startTime = System.currentTimeMillis();
            int fib = app.fiboRec(i);
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            System.out.println("fibRec " + i + ", "+ fib + ", " + execTime + "ms;");
        }

        System.out.println("\n");

        for (Integer i : tests) {
            long startTime = System.currentTimeMillis();
            int fib = app.fibo(i);
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            System.out.println("fib " + i + ", "+ fib + ", " + execTime + "ms;");
        }

        System.out.println("\n");

        for (Integer i : tests) {
            long startTime = System.currentTimeMillis();
            int fib = app.memoizedFibo(i);
            long endTime = System.currentTimeMillis();
            long execTime = endTime - startTime;
            System.out.println("memoizedFibo " + i + ", "+ fib + ", " + execTime + "ms;");
        }
    }
}