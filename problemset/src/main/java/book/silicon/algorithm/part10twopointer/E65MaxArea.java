package book.silicon.algorithm.part10twopointer;

/**
 * description: 这个有数学原理（初中），不明白写不出来
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class E65MaxArea {
    int maxArea(int a[]) {
        int i = 0, j = a.length - 1;
        int result = 0;
        while (i < j) {
            int area = Math.min(a[i], a[j]) * (j - i);
            result = Math.max(result, area);
            if (a[i] <= a[j]) {i++;} else {j--;}
        }
        return result;
    }
}
