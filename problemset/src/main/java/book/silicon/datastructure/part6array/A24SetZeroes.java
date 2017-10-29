package book.silicon.datastructure.part6array;

/**
 * description: mxn矩阵，如果某元素为0，那么将其所在行和列的所有元素都设为0.不允许使用额外空间。
 * author: gubing.gb
 * date: 2017/10/23.
 */
public class A24SetZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) { return; }

        int n = matrix[0].length;
        int x = -1, y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (x == -1 && y == -1) {
                        //找到第一个0元素
                        x = i;
                        y = j;
                    } else {
                        //在第一个0元素所在行和列设置0
                        matrix[x][j] = 0;
                        matrix[i][y] = 0;
                    }
                }
            }
        }

        if (x == -1 || y == -1) { return; }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[x][j] == 0 || matrix[i][y] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
