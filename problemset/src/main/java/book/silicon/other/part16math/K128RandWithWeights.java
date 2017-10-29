package book.silicon.other.part16math;

import java.util.Random;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/27.
 */
public class K128RandWithWeights {
    int randWithWeights(int[] w) {
        int n = w.length;
        int dist[] = new int[n];
        dist[0] = w[0];
        for (int i = 1; i < n; i++) {
            dist[i] = w[i] + dist[i - 1];
        }
        Random random = new Random();
        int rand = random.nextInt(dist[n - 1]);
        for (int i = 0; i < n; i++) {
            if (rand < dist[i]) {return i;}
        }
        return 0;
    }
}
