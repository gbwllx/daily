package book.silicon.algorithm.part10twopointer;

/**
 * description: 所有的算法都是要充分利用题目给出的条件才能做到最快，通用算法效率都一般
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class E63SortColors {
    int[] sortColors(int a[]) {
        int p0 = 0, p2 = a.length;
        for (int i = 0; i < p2; ++i) {
            if (a[i] == 0) {
                int tmp = a[p0];
                a[p0] = a[i];
                a[i] = tmp;
                p0++;
            } else if (a[i] == 2) {
                p2--;
                int tmp = a[p2];
                a[p2] = a[i];
                a[i] = tmp;
                i--;
            }
        }
        return a;
    }
}
