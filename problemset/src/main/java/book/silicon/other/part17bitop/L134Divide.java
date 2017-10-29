package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L134Divide {
    int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long result = 0;
        while (a >= b) {
            long c = b;
            int i = 0;
            while (a >= c) {
                a = a - c;
                result += 1 << i;
                i++;
                c = c << 1;
            }
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            result = -result;
        }
        return (int)result;
    }
}
