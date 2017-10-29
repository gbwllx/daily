package book.silicon.algorithm.part11dp;

/**
 * description: 刷房子
 * 在一条街上，给H个房子刷墙，要求每个房子刷一种颜色，相邻房子不能刷同一种颜色。
 * 每种颜色成本不同，求最小刷墙成本。
 * d[i][j] = min(d[i-1][k])+color[j],其中0<=k<color.length, k!=j
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F76MinCost {
    int minCost(int h, int[] color) {
        if (h == 0 || color.length == 0) {return 0;}
        int min = Integer.MAX_VALUE;
        int[][] d = new int[h][color.length];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < color.length; j++) {
                //初始化第一个房子
                if (i == 0) { d[i][j] = color[j]; } else {
                    min = Integer.MAX_VALUE;
                    //找出在刷第j种颜色时，最小代价
                    for (int k = 0; k < color.length; k++) {
                        if (k == j) { continue; }
                        min = Math.min(min, d[i - 1][k]);
                    }
                    d[i][j] = min + color[j];
                }
            }
        }
        min = Integer.MAX_VALUE;
        //找出最后一栋房子刷各种颜色之后的最小值
        for (int j = 0; j < color.length; j++) {
            min = Math.min(min, d[h - 1][j]);
        }
        return min;
    }
}
