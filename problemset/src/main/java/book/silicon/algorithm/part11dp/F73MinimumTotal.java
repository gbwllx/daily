package book.silicon.algorithm.part11dp;

import java.util.ArrayList;

/**
 * description: 三角形最小路径
 * 输入一个三角形，找出一条从顶部到地步的最小路径和，只能往下移动相邻的节点
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F73MinimumTotal {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == triangle.size() - 1) {
                    path.add(triangle.get(i).get(j));
                } else {
                    //相邻元素最小和
                    path.set(j, triangle.get(i).get(j) + Math.min(path.get(j), path.get(j + 1)));
                }
            }
        }
        return path.get(0);
    }
}
