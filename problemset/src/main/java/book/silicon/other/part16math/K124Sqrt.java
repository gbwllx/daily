package book.silicon.other.part16math;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class K124Sqrt {
    double sqrt(double a) {
        if (a == 0 || a == 1) { return 0; }
        double precision = 1.0e-7, start = 0, end = 0;
        if (a < 1) { end = 1; }
        while (end - start > precision) {
            double mid = (start + end) / 2;
            if (mid == a / mid) {return mid;} else if (mid > a / mid) { end = mid; } else { start = mid; }
        }
        return (start + end) / 2;
    }
}
