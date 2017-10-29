package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L133PowerOf4 {
    boolean isPowerOf4(int n) {
        return n != 0 && (n & 0xAAAAAAAA) == 0 && (n & (n - 1)) == 0;
    }
}
