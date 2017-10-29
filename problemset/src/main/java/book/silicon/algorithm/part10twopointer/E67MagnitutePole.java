package book.silicon.algorithm.part10twopointer;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class E67MagnitutePole {
    int getMagnitutePole(int[] a) {
        if (a == null || a.length == 0) { return -1; }
        boolean[] isCurrMax = new boolean[a.length];
        int first = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= first) {
                first = a[i];
                isCurrMax[i] = true;
            }
        }
        int second = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] <= second) {
                second = a[i];
                if (isCurrMax[i]) { return i; }
            }
        }
        return -1;
    }
}
