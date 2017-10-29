package book.silicon.algorithm.part11dp;

/**
 * description: 最小化数组乘积
 * 给出两个数组a和b，两个数组大小分别为m和n，其中m<n。现要求将(n-m)个0插入a，使得a*b的值最小，求其最小乘积
 * 1. dp[i] = a[i]*b[j],当i=0,j=0时
 * 2. dp[i] = min(a[i]*b[j],dp[i][j-1]),当i=0,0<j<=n-m时
 * 3. dp[i] = min(a[i]*b[j]+dp[i-1][j-1],dp[i][j-1]),当0<i<=j<=i+n-m时
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F69MinProduct {
    int minProduct(int a[], int b[]) {
        int m = a.length, n = b.length;
        //记录每种组合的最小乘积
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = i; j < i + (n - m) + 1; j++) {
                if (j > i) {
                    //要么使用a[i]*b[j],要么使用0*b[j]
                    if (i > 0) {
                        dp[i][j] = Math.min(a[i] * b[j] + dp[i - 1][j - 1], dp[i][j - 1]);
                    } else {
                        dp[i][j] = Math.min(a[i] * b[j], dp[i][j - 1]);
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = a[i] * b[j];
                    } else {
                        dp[i][j] = a[i] * b[j] + dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
