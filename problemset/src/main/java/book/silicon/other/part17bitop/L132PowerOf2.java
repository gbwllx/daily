package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L132PowerOf2 {
    boolean isPowerOf2(int n) {
        return ((n != 0) && ((n & (n - 1)) == 0));
    }
}
