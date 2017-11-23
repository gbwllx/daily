package book.silicon.algorithm.part12prioritytraverse;

import java.util.ArrayList;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class G85BucketFill {
    void bucketfill(ArrayList<ArrayList<Integer>> image, int newcolor, int x, int y) {
        int m = image.size(), n = image.get(0).size();
        int oldcolor = image.get(x).get(y);
        if (oldcolor == newcolor) { return; }
        image.get(x).set(y, newcolor);
        //向左遍历
        if (x > 0 && image.get(x - 1).get(y) == oldcolor) {
            bucketfill(image, newcolor, x - 1, y);
        }
        //向上遍历
        if (y > 0 && image.get(x).get(y - 1) == oldcolor) {
            bucketfill(image, newcolor, x, y - 1);
        }
        //向右遍历
        if (x < m - 1 && image.get(x + 1).get(y) == oldcolor) {
            bucketfill(image, newcolor, x + 1, y);
        }
        //向下遍历
        if (y < n - 1 && image.get(x).get(y + 1) == oldcolor) {
            bucketfill(image, newcolor, x, y + 1);
        }
    }
}
