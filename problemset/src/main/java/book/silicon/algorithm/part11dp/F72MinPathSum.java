package book.silicon.algorithm.part11dp;

/**
 * description: 二维数组最小路径和
 * 给出一个二维mxn矩阵grid，含有非负整数。找出一条路径从最左上角到右下角，
 * 使之经过元素之和最小。假定只能向右或向下移动
 * path[i][j] = min(path[i][j-1],path[i-1][j])+grid[i][j]
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F72MinPathSum {
    int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            //左边界
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            //顶部边界
            path[0][j] = path[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = Math.min(path[i][j - 1] + grid[i][j], path[i - 1][j] + grid[i][j]);
            }
        }
        return path[m - 1][n - 1];
    }
}
