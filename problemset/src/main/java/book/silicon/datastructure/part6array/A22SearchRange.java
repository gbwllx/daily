package book.silicon.datastructure.part6array;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A22SearchRange {
    int[] searchRange(int a[], int target) {
        int[] range = {-1, -1};
        int lower = 0, upper = a.length, mid;
        if (a[upper - 1] < target) {
            return range;
        }

        while (lower < upper) {
            mid = (lower + upper) / 2;
            if (a[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        if (a[lower] != target) {
            return range;
        }
        range[0] = lower;
        upper = a.length;
        while (lower < upper) {
            mid = (lower + upper) / 2;
            if (a[mid] > target) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
            range[1] = upper - 1;
        }

        return range;
    }
}
