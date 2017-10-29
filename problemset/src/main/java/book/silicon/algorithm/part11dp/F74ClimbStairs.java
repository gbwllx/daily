package book.silicon.algorithm.part11dp;

/**
 * description: 爬楼梯，假设有N个阶梯的楼梯，每次你只能爬上一个或两个台阶。计算出有多少种不同方法爬到顶部
 * dp[i] = dp[i-1]+dp[i-2],初始化时，dp[0]=dp[1]=1
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F74ClimbStairs {
    int climbStairs(int n) {
        if (n == 0 || n == 1) { return 1; }
        //考虑到数组下标从0开始
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            //前两个台阶的方法数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
