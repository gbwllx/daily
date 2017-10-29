package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L137ClimbStairs {
    void climbStairs(int n) {
        for (int i = 0; i < 32 && n > 0; i++) {
            if ((n & 1) > 0) { System.out.println("k=" + i + ","); }
            n >>= 1;
        }
    }
}
