package book.silicon.datastructure.part6array;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A19MergeSortedArray {
    void mergeTwoSortedArrays(int[] a, int m, int[] b, int n) {
        while (n > 0) {
            if (m <= 0 || a[m-1] < b[n-1]){
                a[n+m-1] = b[--n];
            } else {
                a[n+m-1] = a[--m];
            }
        }
    }
}
