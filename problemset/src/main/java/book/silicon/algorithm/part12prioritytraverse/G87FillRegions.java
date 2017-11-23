package book.silicon.algorithm.part12prioritytraverse;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/30.
 */
public class G87FillRegions {
    void fillRegions(char[][] board) {
        int m = board.length, n = board[0].length;
        //顶部的O开始遍历
        for (int j = 0; j < m; ++j) {
            if (board[0][j] == 'O') {
                DFS(board, 0, j);
            }
        }
        //右侧的O开始遍历
        for (int i = 1; i < n; ++i) {
            if (board[i][m - 1] == 'O') {
                DFS(board, i, m - 1);
            }
        }
        //底部的O开始遍历
        for (int j = 0; j < m - 1; ++j) {
            if (board[n - 1][j] == 'O') {
                DFS(board, n - 1, j);
            }
        }
        //左侧的O开始遍历
        for (int i = 1; i < n - 1; ++i) {
            if (board[i][0] == 'O') {
                DFS(board, i, 0);
            }
        }
        //把内部O替换为X，外部#替换成O
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void DFS(char[][] board, int i, int j) {
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            DFS(board, i - 1, j);//向上
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            DFS(board, i, j + 1);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            DFS(board, i + 1, j);//向上
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            DFS(board, i, j - 1);
        }
    }
}
