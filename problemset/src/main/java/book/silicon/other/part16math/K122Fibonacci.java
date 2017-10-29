package book.silicon.other.part16math;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class K122Fibonacci {
    int fib(int n) {
        if (n <= 2) { return 1;}
        int a = 1, b = 1, i = 3, res = 0;
        while (i < n) {
            res = a + b;
            a = b;
            b = res;
            i++;
        }
        return res;
    }
}
