package book.silicon.other.part16math;

import java.util.Random;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/27.
 */
public class K129pickK {
    int[] pickK(int[] a, int k) {
        int[] buf = new int[k];
        for (int i = 0; i < a.length; i++) {
            if (i < k) { buf[i] = a[i]; } else {
                Random rand = new Random(i);
                int index = rand.nextInt();
                if (index < k) { buf[index] = a[i]; }
            }
        }
        return buf;
    }
}
