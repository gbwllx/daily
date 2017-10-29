package book.silicon.datastructure.part9string;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class D51PrintPar {
    void printPar(int l, int r, char[] str, int count) {
        if (l < 0 || r < l) {return;}
        if (l == 0 && r == 0) {
            System.out.println(str);
        } else {
            if (l > 0) {
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > 1) {
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    public void printPar(int n) {
        char[] str = new char[n * 2];
        printPar(n, n, str, 0);
    }
}
