package book.silicon.algorithm.part10twopointer;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class E60RemoveDuplicates {
    int removeDuplicates(int a[]) {
        int i = 0;
        int j;
        int n = a.length;
        if (n <= 1) {return n;}
        for (j = 1; j < n; j++) {
            if (a[j] != a[i]) {
                a[++i] = a[j];
            }
        }
        return i + 1;
    }
}
