package book.silicon.datastructure.part6array;

import java.util.ArrayList;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A20PascalTriangle {
    ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n < 1) {return res;}
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        res.add(row1);
        if (n == 1) {return res;}
        for (int i = 1; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(j, res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
