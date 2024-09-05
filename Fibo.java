/**
 * @author Anderson R. P. Sprenger
 * @author Vinicius P. Dias
 */

import java.util.ArrayList;
import java.util.List;

class Fibo {

    public Counter counter = new Counter();

    // FIBO-REC (n)
    //     se n ≤ 1
    //     então 
    //         devolva n
    //     senão 
    //         a ← FIBO-REC (n − 1)
    //         b ← FIBO-REC (n − 2)
    //         devolva a + b

    public int fiboRec(int n) {
        if (n <= 1) { // 1
            counter.addCount(1); // return
            return n; // 1
        }
        counter.addCount(1); // if

        int a = fiboRec(n - 1); // 1
        int b = fiboRec(n - 2); // 2

        counter.addCount(3);
        return a + b; // 3
    }

    // FIBO (n)
    //     f [0] ← 0 
    //     f [1] ← 1
    //     para i ← 2 até n faça
    //         f[i] ← f[i-1]+f[i-2]
    //     devolva f [n]

    public int fibo(int n) {
        int [] f = new int[n + 1]; // f = [0 .. n] // 1
        f[0] = 0; // 2
        f[1] = 1; // 3
        counter.addCount(3);

        for (int i = 2; i <= n; i++) { // 1
            int a = f[i - 1]; // 2
            int b = f[i - 2]; // 3

            f[i] = a + b; // 4
            counter.addCount(4);
        }

        counter.addCount(1);
        return f[n]; // 1
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
        int [] f = new int[n + 1]; // 1 // 0 .. n
        counter.addCount(1);

        for (int i = 0; i < f.length; i++) {
            f[i] = -1; // n = f.length
        }
        counter.addCount(f.length);

        counter.addCount(1);
        return lookupFibo(f, n); // 1
    }

    private int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            counter.addCount(1); // return
            return f[n]; // 1
        }
        counter.addCount(1); // if

        if (n <= 1) { // 1
            f[n] = n; // 2
        } else { // 1
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2); // 2
        }

        counter.addCount(3);
        return f[n]; // 3
    }



    public void main(String[] args) {
        System.out.println("func(n), result, op count;");

        Fibo app = new Fibo();

        List<Integer> tests = new ArrayList<Integer>();
        tests.add(4);
        tests.add(8);
        tests.add(16);
        tests.add(32);

        Counter counter = app.counter;

        for (Integer i : tests) {
            counter.startCount();;
            int fib = app.fiboRec(i);
            System.out.println("fibRec(" + i + "), "+ fib + ", " + counter.getCount() + ";");
        }

        for (Integer i : tests) {
            counter.startCount();;
            int fib = app.fibo(i);
            System.out.println("fib(" + i + "), "+ fib + ", " + counter.getCount() + ";");
        }

        for (Integer i : tests) {
            counter.startCount();;
            int fib = app.memoizedFibo(i);
            System.out.println("memoizedFibo(" + i + "), "+ fib + ", " + counter.getCount() + ";");
        }
    }
}