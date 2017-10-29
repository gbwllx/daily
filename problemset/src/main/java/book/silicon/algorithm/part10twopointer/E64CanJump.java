package book.silicon.algorithm.part10twopointer;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class E64CanJump {
    boolean canJump(int a[]) {
        if (a.length <= 1) { return true; }
        int i, currMax = 0;
        for (i = 0; i < a.length - 1; ++i) {
            if (a[i] == 0 && currMax < i + 1) {return false;}
            if (a[i] + i > currMax && a[i] > 0) {
                currMax = i + a[i];
                if (currMax >= a.length - 1) { return true; }
            }
        }
        return false;
    }
}
