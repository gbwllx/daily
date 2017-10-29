package book.silicon.datastructure.part6array;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A18FirstMissingPositive {
    public static int firstMissingPositive(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            if (a[i] > 0 && a[i] <= n) {
                if (a[i] - 1 != i && a[a[i] - 1] != a[i]) {
                    int temp = a[a[i] - 1];
                    a[a[i] - 1] = a[i];
                    a[i] = temp;
                    i--;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            //输出第一个不匹配的数字
            if (a[i] - 1 != i) {return i + 1;}
        }

        return n + 1;
    }
}
