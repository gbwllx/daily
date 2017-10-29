package book.silicon.algorithm.part10twopointer;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class E66MaxArea2 {
    public static void main(String[] args) {
        int a[] = new int[] {1, 0, 2, 1, 0, 1, 3, 1};
        System.out.println(maxAreaII(a));
    }

    public static int maxAreaII(int a[]) {
        int n = a.length, result = 0;
        int highest = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] > a[highest]) {
                highest = i;
            }
        }
        int second = 0;
        for (int i = 0; i < highest; ++i) {
            if (second > a[i]) {
                result += second - a[i];
            } else {
                second = a[i];
            }
        }
        second = 0;
        for (int i = n - 1; i > highest; --i) {
            if (second > a[i]) {
                result += second - a[i];
            } else {
                second = a[i];
            }
        }
        return result;
    }
}
