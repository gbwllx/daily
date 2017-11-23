package book.silicon.algorithm.part12prioritytraverse;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/30.
 */
public class G86ZeroArea {
    int countZeroArea(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        int visited[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找出一个未访问的0元素
                if (visited[i][j] == 0 && grid[i][j] == 0) {
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int[][] grid, int x, int y, int[][] visited) {
        if (visited[x][y] != 0) { return; }
        visited[x][y] = 1;
        //向上
        if (x > 0 && visited[x - 1][y] == 0 && grid[x - 1][y] == 0) {
            DFS(grid, x - 1, y, visited);

        }
        //向下
        if (x < grid.length - 1 && visited[x + 1][y] == 0 && grid[x + 1][y] == 0) {
            DFS(grid, x + 1, y, visited);

        }
        //向左
        if (y > 0 && visited[x][y - 1] == 0 && grid[x][y - 1] == 0) {
            DFS(grid, x, y - 1, visited);

        }
        //向右
        if (y < grid[0].length - 1 && visited[x][y + 1] == 0 && grid[x][y + 1] == 0) {
            DFS(grid, x, y + 1, visited);

        }
    }
}
