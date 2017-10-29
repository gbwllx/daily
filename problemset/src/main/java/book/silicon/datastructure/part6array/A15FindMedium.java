package book.silicon.datastructure.part6array;

/**
 * description: 查找两数组的中值
 *
 * TODO 求mid有几种，什么时候用哪种？
 * author: gubing.gb
 * date: 2017/10/18.
 */


public class A15FindMedium {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (isEmptyArray(a, b)) { return 0.0;}
        int m = a.length, n = b.length;
        int k = (n + m - 1) / 2 + 1;
        return findKthSortedArrays(a, b, k);
    }

    private boolean isEmptyArray(int[] a, int[] b) {
        return (a == null || a.length == 0) && (b == null || b.length == 0);
    }

    public static double findKthSortedArrays(int a[], int b[], int k) {
        int m = a.length, n = b.length;
        if (m > n) {return findKthSortedArrays(b, a, k);}

        int left = 0;
        int right = m;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int j = k - 1 - mid;
            if (j >= n || a[mid] < b[j]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int aiminus1 = left - 1 >= 0 ? a[left - 1] : Integer.MIN_VALUE;
        int bj = k - 1 - left >= 0 ? b[k - 1 - left] : Integer.MIN_VALUE;
        int valK = Math.max(aiminus1, bj);
        if ((n + m) % 2 == 1) {
            return valK;
        }
        int bjplus1 = k - left >= n ? Integer.MAX_VALUE : b[k - left];
        int ai = left >= m ? Integer.MAX_VALUE : a[left];

        return ((double)(valK + Math.min(bjplus1, ai))) / 2.0;
    }
}
