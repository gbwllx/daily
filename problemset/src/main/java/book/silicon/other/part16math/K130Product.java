package book.silicon.other.part16math;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/27.
 */
public class K130Product {
    int[] getProduct(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) { b[i] = 1; } else { b[i] = b[i - 1] * a[i - 1]; }
        }
        int right = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            b[i] = b[i] * right;
            right = a[i] * right;
        }
        return b;
    }
}
