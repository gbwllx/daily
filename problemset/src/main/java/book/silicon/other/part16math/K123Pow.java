package book.silicon.other.part16math;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class K123Pow {
    double pow(double x, int n) {
        if (n == 0) { return 1.0; }
        double half = pow(x, n / 2);
        if (n % 2 == 0) { return half * half; } else if (n > 0) { return half * half * x; } else {
            return half * half / x;
        }
    }
}
