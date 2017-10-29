package book.silicon.algorithm.part11dp;

/**
 * description: 迷宫路径数
 * 给出一个mxn矩阵，求从左上角到右下角的总路径数，只能向右、向下移动
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F75UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        //初始化顶部
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        //遍历每个格子
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //上面+左边的路径树
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
