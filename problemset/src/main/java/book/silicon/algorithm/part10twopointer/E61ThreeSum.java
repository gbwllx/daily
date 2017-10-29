package book.silicon.algorithm.part10twopointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/27.
 */
public class E61ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> resSet = new ArrayList<>();
        if (num.length < 3) { return resSet; }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; ++i) {
            if (num[i] > 0) { break; }
            if (i > 0 && num[i] == num[i - 1]) { continue; }
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(num[i]);
                    res.add(num[start]);
                    res.add(num[end]);
                    resSet.add(res);
                    do {start++;} while (start < end && num[start] == num[start - 1]);
                    do {end--;} while (start < end && num[end] == num[end + 1]);
                }
            }
        }
        return resSet;
    }

}
